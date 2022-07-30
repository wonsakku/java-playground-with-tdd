package baseball;

public class PlayResult {

    public static final int GAME_END_STRIKE_COUNT = 3;
    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus status) {
        if(status.isStrike()){
            this.strike++;
            return ;
        }
        if(status.isBall()){
            this.ball++;
            return ;
        }
    }

    public boolean isGameEnd() {
        return this.strike == GAME_END_STRIKE_COUNT;
    }
}
