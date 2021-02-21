import java.util.stream.IntStream;

public class Game {
    private final Frame[] frames = IntStream.range(0, 10).mapToObj(i -> new Frame()).toArray(Frame[]::new);

    public int score() {
        int result = 0;
        BonusContext currentBonusContext = new BonusContext(0);
        for (Frame frame : frames) {
            result += frame.score(currentBonusContext);
            currentBonusContext = BonusContext.newBonusContext(frame, currentBonusContext);
        }
        return result;
    }

    public void roll(int pins) {
        for (Frame frame : frames) {
            if (frame.isOpen()) {
                frame.roll(pins);
                return;
            }
        }
    }
}
