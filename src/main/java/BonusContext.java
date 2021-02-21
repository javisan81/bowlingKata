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

    public static BonusContext newBonusContext(Frame frame, BonusContext bonusContext) {
        if(bonusContext.isBonusActivated()){
            return bonusContext;
        }
        if (frame.isSpare()) {
            return new BonusContext(1);
        } else if (frame.isSquare()) {
            return new BonusContext(2);
        }else {
            return new BonusContext(0);
        }
    }
}
