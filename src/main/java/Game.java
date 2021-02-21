import java.util.stream.IntStream;

public class Game {
    private final Frame[] frames = IntStream.range(0, 10).mapToObj(i -> new Frame()).toArray(Frame[]::new);

    public int score() {
        int result = 0;
        BonusContext bonusContext = new BonusContext(0);
        for (Frame frame : frames) {
            boolean bonusApply = bonusContext.isBonusActivated();
            result += frame.score(bonusApply);
            bonusContext.newFramePlayed();
            if(frame.isSpare()) {
                bonusContext = new BonusContext(1);
            }else if(frame.isSquare()){
                bonusContext = new BonusContext(2);
            }
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
