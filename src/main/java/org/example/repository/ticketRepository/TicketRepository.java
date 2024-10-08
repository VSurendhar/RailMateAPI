package org.example.repository.ticketRepository;

import jakarta.transaction.Transactional;
import org.example.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(value = "SELECT s FROM Ticket s WHERE s.seat.id = :id AND s.pnrNo = :pnrNo")
    Ticket findTicket(@Param("id") int id, @Param("pnrNo") int pnrNo);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Ticket s WHERE s.seat.id = :id AND s.pnrNo = :pnrNo")
    void removeTicket(@Param("id") int id, @Param("pnrNo") int pnrNo);

    @Query(value = "SELECT s FROM Ticket s WHERE s.seat.id = :id")
    List<Ticket> findAllBySeatNo(int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Ticket s")
    void removeAllTickets();

}
