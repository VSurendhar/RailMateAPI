package org.example.model;

import java.util.List;

public class CancelMetaData {

    @Override
    public String toString() {
        return "CancelMetaData{" + "pnrNo=" + pnrNo + ", seatList=" + seatList + '}';
    }

    private int pnrNo;
    private List<Integer> seatList;

    public CancelMetaData(int pnrNo, List<Integer> seatList) {
        this.pnrNo = pnrNo;
        this.seatList = seatList;
    }

    public int getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(int pnrNo) {
        this.pnrNo = pnrNo;
    }

    public List<Integer> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Integer> seatList) {
        this.seatList = seatList;
    }

    public CancelMetaData() {
    }

}
