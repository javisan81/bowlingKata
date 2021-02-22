import java.util.stream.IntStream;

public class Game {
    private final Frame[] frames = IntStream.range(0, 10).mapToObj(this::newFrame).toArray(Frame[]::new);

    private Frame newFrame(int i) {
        return i < 9 ? new Frame() : new TenthFrame();
    }

    public int score() {
        int result = 0;
        BonusContext currentBonusContext = new SingleBonusContext(0);
        for (Frame frame : frames) {
            result += frame.score(currentBonusContext);
            currentBonusContext = frame.nextBonusContext(currentBonusContext);
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
