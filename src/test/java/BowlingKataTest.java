import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BowlingKataTest {
    @Test
    public void noFrame(){
        Bowling bowling = new Bowling();
        assertThat(bowling.score(), is(0));
    }
}
