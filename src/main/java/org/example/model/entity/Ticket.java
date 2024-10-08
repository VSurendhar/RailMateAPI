package org.example.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_table")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    private Integer pnrNo;
    private Character fromLocation;
    private Character toLocation;

    // Constructors
    public Ticket() {
    }

    public Ticket(Integer pnrNo, Character fromLocation, Character toLocation, Seat seat) {
        this.pnrNo = pnrNo;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.seat = seat;
    }

    // Getters and Setters
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }


    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Integer getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(Integer pnrNo) {
        this.pnrNo = pnrNo;
    }

    public Character getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Character fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Character getToLocation() {
        return toLocation;
    }

    public void setToLocation(Character toLocation) {
        this.toLocation = toLocation;
    }

    public boolean isOverlap(char new_from, char new_to) {
        if (new_to <= fromLocation) {
            return false;
        }

        if (new_from >= toLocation) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", pnrNo=" + pnrNo +
                ", fromLocation=" + fromLocation +
                ", toLocation=" + toLocation +
                '}';
    }

}