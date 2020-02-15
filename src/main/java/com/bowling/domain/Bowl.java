package com.bowling.domain;

/**
 * @author SuhmitaMondal
 * created on 15/02/2020
 */

public class Bowl {
    private int noOfKnockedPins;
    private TryNumber tryNumber;

    public Bowl(){
    }

    public Bowl(int noOfKnockedPins, TryNumber tryNumber){
        this.noOfKnockedPins = noOfKnockedPins;
        this.tryNumber = tryNumber;
    }

    public enum TryNumber{
        FIRST_TRY,
        SECOND_TRY
    }

    public int getNoOfKnockedPins() {
        return noOfKnockedPins;
    }

    public void setNoOfKnockedPins(int noOfKnockedPins) {
        this.noOfKnockedPins = noOfKnockedPins;
    }

    public TryNumber getTryNumberNo() {
        return tryNumber;
    }

    public void setTryNumber(TryNumber tryNumber) {
        this.tryNumber = tryNumber;
    }
}
