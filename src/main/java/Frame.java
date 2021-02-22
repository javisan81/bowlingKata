public interface Frame {
    void roll(int pins);

    int score(BonusContext bonusContext);

    boolean isOpen();

    BonusContext nextBonusContext(BonusContext currentBonus);

    static Frame newFrame(int framePos) {
        return framePos < 9 ? new NormalFrame() : new TenthFrame();
    }
}
