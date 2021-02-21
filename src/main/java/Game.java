import java.util.stream.IntStream;

public class Game {
    private final Frame[] frames = IntStream.range(0, 10).mapToObj(i -> new Frame()).toArray(Frame[]::new);

    public int score() {
        int result = 0;
        boolean isSpare = false;
        boolean isSquare = false;
        int numberOfFramesAfterSquare = 0;
        for (Frame frame : frames) {
            if (isSquare) {
                numberOfFramesAfterSquare++;
            } else {
                numberOfFramesAfterSquare = 0;
            }
            result += frame.score(isSpare, isSquare);
            isSpare = frame.isSpare();
            isSquare = frame.isSquare() || numberOfFramesAfterSquare == 1;
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
