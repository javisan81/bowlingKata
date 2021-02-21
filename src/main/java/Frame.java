import java.util.HashMap;
import java.util.Map;

public class Frame {
    private int numberOfRollsPlayed = 0;
    private int totalScore = 0;

    private final static Map<Integer, SingleBonusContext> bonusByNumberOfRollsPlayed = new HashMap<Integer, SingleBonusContext>() {
        {
            this.put(1, BonusContext.SquareBonus());
            this.put(2, BonusContext.SpareBonus());
        }
    };

    public void roll(int pins) {
        numberOfRollsPlayed++;
        totalScore += pins;
    }

    public int score(BonusContext bonusContext) {
        return bonusContext.calculateScore(this.totalScore);
    }

    public boolean isOpen() {
        return !isSquare() && numberOfRollsPlayed < 2;
    }

    public BonusContext nextBonusContext(BonusContext currentBonus) {
        if (currentBonus.isBonusActivated()) {
            return new MultipleBonusContext(currentBonus, calculateNextBonusContext());
        }
        return calculateNextBonusContext();
    }

    private BonusContext calculateNextBonusContext() {
        return areAllPinsDown() ? getBonusContext() : BonusContext.NoBonusApply();
    }

    private boolean isSquare() {
        return areAllPinsDown() && numberOfRollsPlayed == 1;
    }

    private boolean areAllPinsDown() {
        return totalScore == 10;
    }

    private SingleBonusContext getBonusContext() {
        return new SingleBonusContext(bonusByNumberOfRollsPlayed.getOrDefault(numberOfRollsPlayed, BonusContext.NoBonusApply()));
    }
}
