package baseball;

public class GameResult {

    private int strike;
    private int ball;
    public int getStrike() {
        return this.strike;
    }


    public int getBall() {
        return this.ball;
    }

    public void addResult(ResultStatus resultStatus) {
        if(resultStatus.isStrike()){
            this.strike += 1;
        }

        if(resultStatus.isBall()){
            this.ball += 1;
        }
    }

    public boolean isEnd() {
        return this.strike == 3;
    }
}
