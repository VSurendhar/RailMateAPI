package org.example.repository.mainRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.model.entity.Seat;
import org.example.model.entity.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public class TicketBookingCustomRepositoryImpl implements TicketBookingCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void insertTicket(Seat seat, Ticket ticket) {
        if (seat != null) {
            seat.getTicketList().add(ticket);
            em.persist(seat);
        } else {
            throw new RuntimeException("Seat not exists");
        }
    }

}
