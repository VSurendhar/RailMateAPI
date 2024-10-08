package org.example.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seat_table")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seat_gen")
    @TableGenerator(
            name = "seat_gen",
            table = "id_generator_table",
            pkColumnName = "gen_name",
            valueColumnName = "gen_value",
            pkColumnValue = "seat_id",
            initialValue = 0,
            allocationSize = 1
    )

    private Integer id;

    @OneToMany(mappedBy = "seat", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketList = new ArrayList<>();

    private String type;

    public Seat(String type) {
        this.type = type;
    }

    public Seat(Integer id, List<Ticket> ticketList) {
        this.id = id;
        this.ticketList = ticketList;
    }

    public Seat() {

    }


    public Integer getId() {
        return id;
    }


    public List<Ticket> getTicketList() {
        return ticketList;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", ticket List='" + ticketList + '\'' +
                '}';
    }

    public boolean canSit(Character fromLocation, Character toLocation) {

        if (ticketList.isEmpty()) {
            return true;
        }

        for (Ticket ticket : ticketList) {

            boolean overlap = ticket.isOverlap(fromLocation, toLocation);

            if (overlap) {
                return false;
            }

        }

        return true;

    }


}