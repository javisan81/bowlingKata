public class Frame {
    private int numberOfRollsPlayed = 0;
    private int totalScore = 0;

    public void roll(int pins) {
        numberOfRollsPlayed++;
        totalScore += pins;
    }

    public int score(boolean lastFrameIsSpare, boolean weAreInSquareBonus) {
        return lastFrameIsSpare || weAreInSquareBonus ? 2 * totalScore : totalScore;
    }

    public boolean isOpen() {
        return !isSquare() && numberOfRollsPlayed < 2;
    }

    public boolean isSpare() {
        return totalScore == 10 && numberOfRollsPlayed == 2;
    }

    public boolean isSquare() {
        return numberOfRollsPlayed == 1 && totalScore == 10;
    }
}
