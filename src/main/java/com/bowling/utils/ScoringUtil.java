package com.bowling.utils;

import com.bowling.domain.Bowl;
import com.bowling.domain.Frame;
import com.bowling.domain.Match;

/**
 * @author SuhmitaMondal
 * created on 15/02/2020
 */

public class ScoringUtil {

    public static int BOWLING_MATCH_SCORE = 0;
    public static int BOWLING_HIGHEST_SCORE = 300;

    /*
    * Will return true if it's the first try of a frame and all the pins were knocked as it would be a strike then
    * */
    public static boolean isStrike(Frame frame){
        Bowl firstBowl = frame.getBowlByTryNumber(Bowl.TryNumber.FIRST_TRY);
        if(firstBowl!= null && (firstBowl.getNoOfKnockedPins() == 10)){
            return true;
        }
        else return false;
    }

    /*
     * Will return true if all the pins are knocked for a frame
     * */
    public static boolean isSpare(Frame frame){
        int noOfKnockedPinsAtFirstBowl = frame.getBowlByTryNumber(Bowl.TryNumber.FIRST_TRY).getNoOfKnockedPins();
        int noOfKnockedPinsAtSecondBowl = 0;
        if(frame.getBowlByTryNumber(Bowl.TryNumber.SECOND_TRY) != null){
            noOfKnockedPinsAtSecondBowl = frame.getBowlByTryNumber(Bowl.TryNumber.SECOND_TRY).getNoOfKnockedPins();
        }
        if(noOfKnockedPinsAtFirstBowl+noOfKnockedPinsAtSecondBowl == 10)
            return true;
        else return false;
    }


    /*
     * Will return true if all the attempts were Strike
     * */
    public static boolean isAllAttemptsStrike(Match match){
        for(Frame frame: match.getFrames()){
            if(!isStrike(frame))
                return false;
        }
        return true;
    }

    /*
     * Calculate points of a Frame
     * */
    public static void calculateMatchPoints(Match match) {
        for (int i = 0; i < match.getFrames().size(); i++) {
            Frame frame = match.getFrames().get(i);

            if (i <= 9) {
                if (isStrike(frame) && (i + 1 != match.getFrames().size())) {
                    frame.setFrameScore(frame.getFrameScore() + match.getFrames().get(i + 1).getFrameScore());
                }
                else if (isSpare(frame) && (i + 1 != match.getFrames().size())) {
                    int knockedPin = match.getFrames().get(i + 1).getBowlByTryNumber(Bowl.TryNumber.FIRST_TRY).getNoOfKnockedPins();
                    frame.setFrameScore(frame.getFrameScore() + knockedPin);
                }
                BOWLING_MATCH_SCORE += frame.getFrameScore();
            }
        }
    }


    /*
     * Calculate and return the match score
     * */
    public static int getScore(Match match){
        BOWLING_MATCH_SCORE = 0;
        if(match.getFrames() == null)
            return BOWLING_MATCH_SCORE;
        else if(isAllAttemptsStrike(match)){
            return BOWLING_HIGHEST_SCORE;
        }
        else {
            calculateMatchPoints(match);
            return BOWLING_MATCH_SCORE;
        }
    }

}
