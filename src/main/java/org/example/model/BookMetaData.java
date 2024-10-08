package org.example.model;

import java.util.List;

public class BookMetaData {

    @Override
    public String toString() {
        return "BookMetaData{" +
                "from=" + from +
                ", to=" + to +
                ", seat List =" + seatList +
                '}';
    }

    private String from;
    private String to;
    private List<Integer> seatList;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BookMetaData() {
    }

    public List<Integer> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Integer> seatList) {
        this.seatList = seatList;
    }

    public BookMetaData(String from, String to, List<Integer> seatList) {
        this.from = from;
        this.to = to;
        this.seatList = seatList;
    }

}
