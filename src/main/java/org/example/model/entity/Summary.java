package org.example.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "summary_table")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int summaryId;

    private char fromLocation;
    private char toLocation;
    private int pnrNo;
    private String seatID;
    private String entryType;

    public Summary() {

    }

    public Summary(char fromLocation, char toLocation, int pnrNo, String seatID, String entryType) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.pnrNo = pnrNo;
        this.seatID = seatID;
        this.entryType = entryType;
    }


    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatList) {
        this.seatID = seatList;
    }

    public int getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(int summaryId) {
        this.summaryId = summaryId;
    }

    public char getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(char from) {
        this.fromLocation = from;
    }

    public char getToLocation() {
        return toLocation;
    }

    public void setToLocation(char to) {
        this.toLocation = to;
    }

    public int getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(int pnrNo) {
        this.pnrNo = pnrNo;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    @Override
    public String toString() {
        return "from= " + fromLocation +
                ", to= " + toLocation +
                ", pnrNo= " + pnrNo +
                ", Entry Type= " + entryType +
                ", seatList=  " + seatID;
    }

}