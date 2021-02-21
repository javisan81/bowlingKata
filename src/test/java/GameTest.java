import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameTest {
    @Test
    public void noFrame(){
        Game bowling = new Game();
        assertThat(bowling.score(), is(0));
    }

    @Test
    public void oneFrameOneRoll(){
        Game bowling = new Game();
        bowling.roll(1);
        assertThat(bowling.score(), is(1));
    }

    @Test
    public void oneFrameTwoRolls(){
        Game bowling = new Game();
        bowling.roll(1);
        bowling.roll(1);
        assertThat(bowling.score(), is(2));
    }

    @Test
    public void twoFramesFirsIsSpare(){
        Game bowling = new Game();
        bowling.roll(9);
        bowling.roll(1);

        bowling.roll(1);
        bowling.roll(1);
        assertThat(bowling.score(), is(14));
    }

    @Test
    public void threeFramesFirsIsSpare(){
        Game bowling = new Game();
        bowling.roll(9);
        bowling.roll(1);

        bowling.roll(1);
        bowling.roll(1);

        bowling.roll(1);
        bowling.roll(1);
        assertThat(bowling.score(), is(16));
    }

    @Test
    public void threeFramesFirsIsSquare(){
        Game bowling = new Game();
        bowling.roll(10);

        bowling.roll(1);
        bowling.roll(1);

        bowling.roll(1);
        bowling.roll(1);
        assertThat(bowling.score(), is(18));
    }

    @Test
    public void threeFramesFirsIsSquareSecondIsSpare(){
        Game bowling = new Game();
        bowling.roll(10);

        bowling.roll(9);
        bowling.roll(1);

        bowling.roll(1);
        bowling.roll(1);
        assertThat(bowling.score(), is(36));
    }

    @Test
    public void fourFramesFirsIsSquareSecondIsSquare(){
        Game bowling = new Game();
        bowling.roll(10);

        bowling.roll(10);

        bowling.roll(1);
        bowling.roll(1);

        bowling.roll(1);
        bowling.roll(1);
        assertThat(bowling.score(), is(40));
    }

}
