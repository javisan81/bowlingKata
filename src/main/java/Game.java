import java.util.stream.IntStream;

public class Game {
    private final Frame[] frames = IntStream.range(0, 10).mapToObj(i -> new Frame()).toArray(Frame[]::new);

    public int score() {
        int result = 0;
        boolean isSpare = false;
        for (Frame frame : frames) {
            result += frame.score(isSpare);
            isSpare = frame.isSpare();
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
