public class Frame {
    private int numberOfRollsPlayed = 0;
    private int totalScore = 0;

    public void roll(int pins) {
        numberOfRollsPlayed++;
        totalScore += pins;
    }

    public int score(boolean lastFrameIsSpare) {
        return lastFrameIsSpare ? 2 * totalScore : totalScore;
    }

    public boolean isOpen() {
        return numberOfRollsPlayed < 2;
    }

    public boolean isSpare() {
        return totalScore == 10 && numberOfRollsPlayed == 2;
    }
}
