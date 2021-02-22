import java.util.Arrays;

import static java.util.Arrays.stream;

public class TenthFrame implements Frame {
    private final int[] scores = new int[]{0, 0, 0};
    private int numberOfRollsPlayed = 0;

    @Override
    public boolean isOpen() {
        return (sumScores() >= 10) ? numberOfRollsPlayed < 3 : numberOfRollsPlayed < 2;
    }

    private int sumScores() {
        return stream(scores).sum();
    }

    public void roll(int pins) {
        scores[numberOfRollsPlayed] = pins;
        numberOfRollsPlayed++;
    }

    public int score(BonusContext bonusContext) {
        int frameScore = sumScores();
        if (scores[0] == 10) {
            frameScore += scores[1] + scores[2];
        }
        if (scores[1] == 10 || (scores[1] + scores[0] == 10)) {
            frameScore += scores[2];
        }
        return bonusContext.calculateScore(frameScore);
    }


    public BonusContext nextBonusContext(BonusContext currentBonus) {
        return BonusContext.NoBonusApply();
    }

}
