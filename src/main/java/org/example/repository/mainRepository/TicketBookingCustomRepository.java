package org.example.repository.mainRepository;

import org.example.model.entity.Seat;
import org.example.model.entity.Ticket;

public interface TicketBookingCustomRepository {
    void insertTicket(Seat seat, Ticket ticket);
}