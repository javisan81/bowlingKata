public class SingleBonusContext implements BonusContext {
    private final int howManyFramesApply;
    private int framesPlayedAfterBonusGained;

    public SingleBonusContext(int howManyFramesApply) {
        this.framesPlayedAfterBonusGained = 0;
        this.howManyFramesApply = howManyFramesApply;
    }

    public SingleBonusContext(SingleBonusContext bonusContext) {
        this(bonusContext.howManyFramesApply);
    }

    @Override
    public boolean isBonusActivated() {
        return framesPlayedAfterBonusGained < howManyFramesApply;
    }

    @Override
    public int calculateScore(int score) {
        int result = this.isBonusActivated() ? 2 * score : score;
        framesPlayedAfterBonusGained++;
        return result;
    }
}
