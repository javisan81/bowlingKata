public class BonusContext {
    private final int howManyFramesApply;
    private int framesPlayedAfterBonusGained;

    public BonusContext(int howManyFramesApply) {
        this.howManyFramesApply = howManyFramesApply;
    }

    public void newFramePlayed() {
        framesPlayedAfterBonusGained++;
    }

    public boolean isBonusActivated() {
        return framesPlayedAfterBonusGained < howManyFramesApply;
    }
}
