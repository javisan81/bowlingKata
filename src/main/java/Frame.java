public class Frame {
    private int numberOfRollsPlayed = 0;
    private int totalScore = 0;

    public void roll(int pins) {
        numberOfRollsPlayed++;
        totalScore += pins;
    }

    public int score(BonusContext bonusContext) {
        int result = bonusContext.isBonusActivated() ? 2 * totalScore : totalScore;
        bonusContext.newFramePlayed();
        return result;
    }

    public boolean isOpen() {
        return !isSquare() && numberOfRollsPlayed < 2;
    }

    private boolean isSpare() {
        return totalScore == 10 && numberOfRollsPlayed == 2;
    }

    private boolean isSquare() {
        return numberOfRollsPlayed == 1 && totalScore == 10;
    }

    public BonusContext nextBonusContext(BonusContext currentBonus) {
        if(currentBonus.isBonusActivated()){
            return currentBonus;
        }
        if (this.isSpare()) {
            return new BonusContext(1);
        } else if (this.isSquare()) {
            return new BonusContext(2);
        }else {
            return new BonusContext(0);
        }
    }
}
