package com.bowling.api;

/**
 * @author SuhmitaMondal
 * created on 15/02/2020
 */

public interface IBowlingGame {

    void roll(int noOfPins);

    int score();
}
