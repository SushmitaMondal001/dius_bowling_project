package com.bowling.domain;

import java.util.List;

/**
 * @author SuhmitaMondal
 * created on 15/02/2020
 */

public class Frame {
    private List<Bowl> bowlList;
    private int frameScore;

    public Frame(){

    }

    public Frame(List<Bowl> bowls, int frameScore){
        this.bowlList = bowls;
        this.frameScore = frameScore;
    }

    public List<Bowl> getBowlList() {
        return bowlList;
    }

    public void setBowlList(List<Bowl> bowlList) {
        this.bowlList = bowlList;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }

    public Bowl getBowlByTryNumber(Bowl.TryNumber tryNumber){
        return this.bowlList.stream().filter(b -> b.getTryNumberNo().equals(tryNumber)).findFirst().orElse(null);
    }
}
