package org.example.model.entity;

public class UpdateMetaData {

    private int pnrNo;
    private char from;
    private char to;
    private int fromSeatNumber;
    private int toSeatNumber;

    public UpdateMetaData(int pnrNo, char from, char to, int fromSeatNumber, int toSeatNumber) {
        this.pnrNo = pnrNo;
        this.from = from;
        this.to = to;
        this.fromSeatNumber = fromSeatNumber;
        this.toSeatNumber = toSeatNumber;
    }

    @Override
    public String toString() {
        return "UpdateMetaData{" +
                "pnrNo=" + pnrNo +
                ", from=" + from +
                ", to=" + to +
                ", fromSeatNumber=" + fromSeatNumber +
                ", toSeatNumber=" + toSeatNumber +
                '}';
    }

    public int getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(int pnrNo) {
        this.pnrNo = pnrNo;
    }

    public char getFrom() {
        return from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public char getTo() {
        return to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    public int getFromSeatNumber() {
        return fromSeatNumber;
    }

    public void setFromSeatNumber(int fromSeatNumber) {
        this.fromSeatNumber = fromSeatNumber;
    }

    public int getToSeatNumber() {
        return toSeatNumber;
    }

    public void setToSeatNumber(int toSeatNumber) {
        this.toSeatNumber = toSeatNumber;
    }
}