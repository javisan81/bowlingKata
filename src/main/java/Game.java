public class Game {
    private int totalScore = 0;
    public int score() {
        return totalScore;
    }

    public void roll(int pins) {
        totalScore = pins;
    }
}
