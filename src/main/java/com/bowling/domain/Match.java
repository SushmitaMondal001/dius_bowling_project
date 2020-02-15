package com.bowling.domain;

import java.util.List;

/**
 * @author SuhmitaMondal
 * created on 15/02/2020
 */

public class Match {
    private int score;
    private List<Frame> frames;

    public Match(){
    }

    public Match(int score, List<Frame> frames){
        this.score = score;
        this.frames = frames;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }
}
