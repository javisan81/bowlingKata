import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameTest {
    @Test
    public void noFrame(){
        Game bowling = new Game();
        assertThat(bowling.score(), is(0));
    }

}
