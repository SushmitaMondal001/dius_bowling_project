import com.bowling.BowlingGameImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author SuhmitaMondal
 * created on 15/02/2020
 */

public class BowlingGameTest {

    BowlingGameImpl bowlingGame;

    @Before
    public void setUp(){
        bowlingGame = new BowlingGameImpl();
    }

    @Test
    public void testRoll(){
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(10);
        assertEquals(30, bowlingGame.score());
        assertNotEquals(5, bowlingGame.score());
    }

    @Test
    public void testAllStrikes(){
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        assertEquals(300, bowlingGame.score());
    }

    @Test
    public void testScoreWhenStrikeHappensAtLast(){
        bowlingGame.roll(3);
        bowlingGame.roll(3);
        bowlingGame.roll(1);
        bowlingGame.roll(9);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        assertEquals(196, bowlingGame.score());
    }

    @Test
    public void testScoreWhenSpareHappensAtLast(){
        bowlingGame.roll(3);
        bowlingGame.roll(3);
        bowlingGame.roll(1);
        bowlingGame.roll(9);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(1);
        bowlingGame.roll(9);
        bowlingGame.roll(1);
        assertEquals(177, bowlingGame.score());
    }

    @Test
    public void testReturnScore0(){
        assertEquals(0, bowlingGame.score());
    }

}
