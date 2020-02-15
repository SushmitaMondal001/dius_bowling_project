package com.bowling;

import com.bowling.api.IBowlingGame;
import com.bowling.domain.Bowl;
import com.bowling.domain.Frame;
import com.bowling.domain.Match;
import com.bowling.utils.ScoringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SuhmitaMondal
 * created on 15/02/2020
 */

public class BowlingGameImpl implements IBowlingGame {

    Match bowlingGameMatch;

    public BowlingGameImpl(){
        bowlingGameMatch = new Match();
    }

    @Override
    public void roll(int noOfPins){
        Bowl bowl = new Bowl();
        bowl.setNoOfKnockedPins(noOfPins);
        List<Frame> frames = bowlingGameMatch.getFrames();
        frames = setFramesForMatch(frames, bowl);
        bowlingGameMatch.setFrames(frames);
    }

    /*
     * Depending on the current frames in the match, this roll would be setup
     * */
    private List<Frame> setFramesForMatch(List<Frame> frames, Bowl bowl){

        Frame lastFrame;
        List<Bowl> bowlList = new ArrayList<>();

        // If rolling for the first time there won't be any frames in the match, so creating match
        if(frames == null){
            bowl.setTryNumber(Bowl.TryNumber.FIRST_TRY);
            bowlList.add(bowl);
            lastFrame = new Frame(bowlList, bowl.getNoOfKnockedPins());
            frames = new ArrayList<>();
            frames.add(lastFrame);
            return frames;
        }
        else{
            lastFrame = frames.get(frames.size()-1);
            List<Bowl> bowlsOfLastFrames = lastFrame.getBowlList();

            bowlTryNumberSetup(lastFrame, bowl, frames.size()-1);

            // If previous frame either filled up with the roll or had been Strike
            // Creating FIRST_TRY for the new frame
            if(bowl.getTryNumberNo().equals(Bowl.TryNumber.FIRST_TRY)){
                bowlList.add(bowl);
                lastFrame = new Frame(bowlList, bowl.getNoOfKnockedPins());
                frames.add(lastFrame);
            }

            else if(bowl.getTryNumberNo().equals(Bowl.TryNumber.SECOND_TRY)){
                bowlsOfLastFrames.add(bowl);
                lastFrame.setFrameScore(lastFrame.getFrameScore() + bowl.getNoOfKnockedPins());
            }
            return frames;
        }
    }


    /*
     * Setting up TryNumber based on the last frame status
     * */
    private Bowl bowlTryNumberSetup(Frame lastFrame, Bowl bowl, int index){
        if(lastFrame.getBowlByTryNumber(Bowl.TryNumber.SECOND_TRY) != null){
            bowl.setTryNumber(Bowl.TryNumber.FIRST_TRY);
        }

        if(lastFrame.getBowlByTryNumber(Bowl.TryNumber.SECOND_TRY) == null){
            if(index == 10 && lastFrame.getBowlByTryNumber(Bowl.TryNumber.FIRST_TRY) == null){
                bowl.setTryNumber(Bowl.TryNumber.FIRST_TRY);
            }
            else if(index == 10 && lastFrame.getBowlByTryNumber(Bowl.TryNumber.FIRST_TRY) != null){
                bowl.setTryNumber(Bowl.TryNumber.SECOND_TRY);
            }
            else if((lastFrame.getBowlByTryNumber(Bowl.TryNumber.FIRST_TRY).getNoOfKnockedPins() == 10)){
                bowl.setTryNumber(Bowl.TryNumber.FIRST_TRY);
            }
            else bowl.setTryNumber(Bowl.TryNumber.SECOND_TRY);
        }
        return bowl;
    }


    /*
     * Will return score at any moment while running the game
     * */
    @Override
    public int score() {
        return ScoringUtil.getScore(bowlingGameMatch);
    }
}
