public class BonusContext implements Cloneable{
    private final int howManyFramesApply;
    private int framesPlayedAfterBonusGained;

    public BonusContext(int howManyFramesApply) {
        this.framesPlayedAfterBonusGained =0;
        this.howManyFramesApply = howManyFramesApply;
    }

    public BonusContext(BonusContext bonusContext){
        this(bonusContext.howManyFramesApply);
    }

    public void newFramePlayed() {
        framesPlayedAfterBonusGained++;
    }

    public boolean isBonusActivated() {
        return framesPlayedAfterBonusGained < howManyFramesApply;
    }

    public int calculateScore(int score) {
        int result = this.isBonusActivated() ? 2 * score : score;
        this.newFramePlayed();
        return result;
    }

    public static BonusContext NoBonusApply() {
        return new BonusContext(0);
    }

    public static BonusContext SpareBonus() {
        return new BonusContext(1);
    }

    public static BonusContext SquareBonus() {
        return new BonusContext(2);
    }
}
