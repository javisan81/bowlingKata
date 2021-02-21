public class Game {
    private Frame frame1 = new Frame();
    private Frame frame2 = new Frame();

    public int score() {
        return frame1.score(false) + frame2.score(frame1.isSpare());
    }

    public void roll(int pins) {
        if(frame1.isOpen()){
            frame1.roll(pins);
        }else{
            frame2.roll(pins);
        }
    }
}
