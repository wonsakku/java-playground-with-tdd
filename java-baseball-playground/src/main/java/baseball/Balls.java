package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    private List<Ball> balls;
    private GameResult result;

    public Balls(List<Integer> nums) {
        this.balls = initBall(nums);
        this.result = new GameResult();
    }

    private List<Ball> initBall(List<Integer> nums) {
        return IntStream.range(0, nums.size())
                .mapToObj(idx -> new Ball(idx+1, nums.get(idx)))
                .collect(Collectors.toList());
    }


    public ResultStatus result(Ball ball) {
        return this.balls.stream()
                .map(com -> com.play(ball))
                .filter(ResultStatus::isNotNothing)
                .findAny()
                .orElse(ResultStatus.NOTHING);
    }

    public GameResult playGame(List<Integer> asList) {

        for(int i = 0 ; i < asList.size() ; i++){
            ResultStatus resultStatus = result(new Ball(i + 1, asList.get(i)));
            result.addResult(resultStatus);
        }

        return this.result;
    }
}





