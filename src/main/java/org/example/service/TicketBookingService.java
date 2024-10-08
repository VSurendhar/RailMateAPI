package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.model.BookMetaData;
import org.example.model.CancelMetaData;
import org.example.model.entity.Seat;
import org.example.model.entity.Summary;
import org.example.model.entity.Ticket;
import org.example.model.entity.UpdateMetaData;
import org.example.repository.mainRepository.TicketBookingRepository;
import org.example.repository.metaDataRepository.PnrGeneratorRepository;
import org.example.repository.summaryRepository.SummaryRepository;
import org.example.repository.ticketRepository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketBookingService {

    @Autowired
    TicketBookingRepository ticketBookingRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    SummaryRepository summaryRepository;

    @Autowired
    PnrGeneratorRepository pnrGeneratorRepository;

    public void bookTicket(BookMetaData bookMetaData) {
        for (Integer seatNo : bookMetaData.getSeatList()) {
            int pnrNumber = pnrGeneratorRepository.getValue();
            insertTicketById(seatNo, pnrNumber, bookMetaData.getFrom().charAt(0), bookMetaData.getTo().charAt(0), true);
        }
        pnrGeneratorRepository.updateTable();
    }

    public void cancelTicket(CancelMetaData cancelMetaData) {
        for (Integer seatNo : cancelMetaData.getSeatList()) {
            removeTicketById(seatNo, cancelMetaData.getPnrNo());
        }
    }

    public List<Integer> getAvailableSeats(char from, char to) {

        List<Integer> availableSeatList = new ArrayList<>();

        List<Seat> seatList = ticketBookingRepository.findAll();

        for (Seat seat : seatList) {
            if (seat.canSit(from, to)) {
                availableSeatList.add(seat.getId());
            }
        }

        return availableSeatList;

    }


    private void removeTicketById(int seatNo, int pnrNumber) {
        mremoveTicketById(seatNo, pnrNumber, true);
        List<UpdateMetaData> updateMetaDataList = update(seatNo);
        for (UpdateMetaData updateMetaData : updateMetaDataList) {
            summaryRepository.save(new Summary(updateMetaData.getFrom(), updateMetaData.getTo(), updateMetaData.getPnrNo(), "RAC" + updateMetaData.getFromSeatNumber() + " to " + "R" + updateMetaData.getToSeatNumber(), "UPDATE"));
        }
    }

    private void insertTicketById(int seatNo, int pnrNumber, char from, char to, boolean summary) {
        Seat seat = ticketBookingRepository.findById(seatNo).orElseThrow(() -> new RuntimeException("Seat not found"));
        Ticket ticket = new Ticket(pnrNumber, from, to, seat);
        ticketBookingRepository.insertTicket(seat, ticket);
        if (summary) {
            if (seatNo > 12) {
                summaryRepository.save(new Summary(from, to, pnrNumber, "RAC" + seatNo, "BOOK"));
            } else {
                summaryRepository.save(new Summary(from, to, pnrNumber, "R" + seatNo, "BOOK"));
            }
        }
    }

    @Transactional
    protected void mremoveTicketById(int seatNo, int pnrNumber, boolean summary) {

        Ticket ticket = ticketRepository.findTicket(seatNo, pnrNumber);

        if (ticket == null) {
            System.out.println("Ticket not found");
        }

        ticketRepository.removeTicket(seatNo, pnrNumber);
        ticketRepository.flush();


        if (summary) {
            if (seatNo > 12) {
                summaryRepository.save(new Summary(ticket.getFromLocation(), ticket.getToLocation(), pnrNumber, "RAC" + seatNo, "CANCEL"));
            } else {
                summaryRepository.save(new Summary(ticket.getFromLocation(), ticket.getToLocation(), pnrNumber, "R" + seatNo, "CANCEL"));
            }
        }

        List<Ticket> ticketList = ticketRepository.findAllBySeatNo(seatNo);
        System.out.println("From Remove => Tickets from the seat No" + seatNo + " is " + ticketList);

    }

    private List<UpdateMetaData> update(int seatNo) {

        Seat targetSeat;

        List<UpdateMetaData> updateMetaDataList = new ArrayList<>();

        for (int i = 13; i <= 20; i++) {
            targetSeat = ticketBookingRepository.findById(seatNo).orElseThrow(() -> new RuntimeException("Seat not found"));
            updateMetaDataList.addAll(insertAllValidTickets(i, targetSeat));
        }

        return updateMetaDataList;

    }

    private List<UpdateMetaData> insertAllValidTickets(int sourceSeatNo, Seat targetSeat) {

        List<UpdateMetaData> updateMetaDataList = new ArrayList<>();
        List<Ticket> ticketList = getTicketsBySeatNo(sourceSeatNo);

        for (Ticket ticket : ticketList) {
            boolean canSit = targetSeat.canSit(ticket.getFromLocation(), ticket.getToLocation());
            if (canSit) {
                mremoveTicketById(sourceSeatNo, ticket.getPnrNo(), false);
                insertTicketById(targetSeat.getId(), ticket.getPnrNo(), ticket.getFromLocation(), ticket.getToLocation(), false);
                updateMetaDataList.add(new UpdateMetaData(ticket.getPnrNo(), ticket.getFromLocation(), ticket.getToLocation(), sourceSeatNo, targetSeat.getId()));
            }
        }

        return updateMetaDataList;

    }

    private List<Ticket> getTicketsBySeatNo(int id) {
        return ticketRepository.findAllBySeatNo(id);
    }

}