public class TenthFrame implements Frame {
    private int scoreRoll0 = 0;
    private int scoreRoll1 = 0;
    private int scoreRoll2 = 0;
    private int numberOfRollsPlayed = 0;

    @Override
    public boolean isOpen() {
        return (scoreRoll0 + scoreRoll1 >= 10) ? numberOfRollsPlayed < 3 : numberOfRollsPlayed < 2;
    }

    public void roll(int pins) {
        numberOfRollsPlayed++;
        if (numberOfRollsPlayed == 1) {
            scoreRoll0 = pins;
        } else if (numberOfRollsPlayed == 2) {
            scoreRoll1 = pins;
        } else {
            scoreRoll2 = pins;
        }
    }

    public int score(BonusContext bonusContext) {
        int frameScore = scoreRoll0 + scoreRoll1 + scoreRoll2;
        if (scoreRoll0 == 10) {
            frameScore += scoreRoll1 + scoreRoll2;
        }
        if (scoreRoll1 == 10 ) {
            frameScore += scoreRoll2;
        }
        return bonusContext.calculateScore(frameScore);
    }


    public BonusContext nextBonusContext(BonusContext currentBonus) {
        return BonusContext.NoBonusApply();
    }

}
