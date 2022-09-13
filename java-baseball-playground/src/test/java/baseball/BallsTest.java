package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls com;

    @BeforeEach
    void init(){
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void strike_3(){
        GameResult gameResult = com.playGame(Arrays.asList(1, 2, 3));
        assertThat(gameResult.getStrike()).isEqualTo(3);
        assertThat(gameResult.isEnd()).isTrue();
    }

    @Test
    void strike_1_ball_2(){
        GameResult result = com.playGame(Arrays.asList(1, 3, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void strike_2_ball_1(){
        GameResult result = com.playGame(Arrays.asList(1, 2, 2));
        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void strike_1(){
        assertThat(com.result(new Ball(2, 2))).isEqualTo(ResultStatus.STRIKE);
    }

    @Test
    void ball_1(){
        assertThat(com.result(new Ball(1, 2))).isEqualTo(ResultStatus.BALL);
    }


    @Test
    void nothing(){
        assertThat(com.result(new Ball(1, 8))).isEqualTo(ResultStatus.NOTHING);
    }

}
