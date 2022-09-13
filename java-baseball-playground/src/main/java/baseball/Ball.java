package baseball;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int num;

    public Ball(int position, int num) {
        if(!ValidationUtil.validate(num)){
            throw new IllegalStateException("숫자는 1~9 사이여야 합니다.");
        };
        this.position = position;
        this.num = num;

    }

    public ResultStatus play(Ball ball) {

        if(this.equals(ball)){
            return ResultStatus.STRIKE;
        }

        if(ball.isSameNum(this.num)){
            return ResultStatus.BALL;
        }

        return ResultStatus.NOTHING;
    }

    private boolean isSameNum(int num) {
        return this.num == num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && num == ball.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, num);
    }
}
