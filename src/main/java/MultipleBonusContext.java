public class MultipleBonusContext implements BonusContext {
    private final BonusContext firstBonusContext;
    private final BonusContext secondBonusContext;

    public MultipleBonusContext(BonusContext firstBonusContext, BonusContext secondBonusContext) {
        this.firstBonusContext = firstBonusContext;
        this.secondBonusContext = secondBonusContext;
    }

    @Override
    public boolean isBonusActivated() {
        return firstBonusContext.isBonusActivated() || secondBonusContext.isBonusActivated();
    }

    @Override
    public int calculateScore(int score) {
        return firstBonusContext.calculateScore(score) + secondBonusContext.calculateScore(score) - score;
    }
}
