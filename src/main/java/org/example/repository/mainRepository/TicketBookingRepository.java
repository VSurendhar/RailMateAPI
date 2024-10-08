package org.example.repository.mainRepository;

import org.example.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingRepository extends JpaRepository<Seat, Integer>, TicketBookingCustomRepository {
}