package org.example.controller;

import org.example.model.BookMetaData;
import org.example.model.CancelMetaData;
import org.example.service.TicketBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TCApp")
public class TicketBookingController {

    TicketBookingService ticketBookingService;

    TicketBookingController(TicketBookingService ticketBookingService) {
        this.ticketBookingService = ticketBookingService;
    }

    @GetMapping("/getAllSeats")
    public List<Integer> getAvailableSeats(@RequestParam char from, @RequestParam char to) {
        return ticketBookingService.getAvailableSeats(from, to);
    }

    @PostMapping("/book")
    public void bookSeat(@RequestBody BookMetaData bookMetaData) {
        System.out.println("bookMetaData -> " + bookMetaData);
        ticketBookingService.bookTicket(bookMetaData);
    }

    @PostMapping("/cancelSeat")
    public void cancelSeat(@RequestBody CancelMetaData cancelMetaData) {
        System.out.println("cancelMetaData -> " + cancelMetaData);
        ticketBookingService.cancelTicket(cancelMetaData);
    }

}