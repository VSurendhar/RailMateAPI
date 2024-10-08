package org.example.service;

import org.example.model.entity.Summary;
import org.example.repository.mainRepository.TicketBookingRepository;
import org.example.repository.metaDataRepository.IdGeneratorRepository;
import org.example.repository.metaDataRepository.PnrGeneratorRepository;
import org.example.repository.summaryRepository.SummaryRepository;
import org.example.repository.ticketRepository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperConsoleService {

    @Autowired
    SummaryRepository summaryRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketBookingRepository ticketBookingRepository;

    @Autowired
    IdGeneratorRepository idGeneratorRepository;

    @Autowired
    PnrGeneratorRepository pnrGeneratorRepository;

    public List<Summary> listAllSummary() {
        return summaryRepository.findAll();
    }

    public void reinitialize() {
        ticketRepository.deleteAll();
        summaryRepository.deleteAll();
    }

    public void initialize() {

        ticketRepository.removeAllTickets();
        summaryRepository.deleteAll();
        pnrGeneratorRepository.insertInitialValue();

    }

}
