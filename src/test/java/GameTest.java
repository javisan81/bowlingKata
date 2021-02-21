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

}
