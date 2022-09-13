package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilTest {

    @Test
    void validate(){
        assertThat(ValidationUtil.validate(1)).isTrue();
        assertThat(ValidationUtil.validate(9)).isTrue();
        assertThat(ValidationUtil.validate(10)).isFalse();
        assertThat(ValidationUtil.validate(0)).isFalse();
    }


}
