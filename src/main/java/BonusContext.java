public interface BonusContext {
    static SingleBonusContext NoBonusApply() {
        return new SingleBonusContext(0);
    }

    static SingleBonusContext SpareBonus() {
        return new SingleBonusContext(1);
    }

    static SingleBonusContext SquareBonus() {
        return new SingleBonusContext(2);
    }

    boolean isBonusActivated();

    int calculateScore(int score);
}
