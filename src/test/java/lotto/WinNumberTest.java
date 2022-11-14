package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinNumberTest {
    private WinNumber wn = new WinNumber();

    private static Stream<Arguments> provideUserWinNumber(){
        return Stream.of(
                Arguments.of("0,1,2,3,4,5","6"),
                Arguments.of("1,2,3,4,5,6","6")
                );
    }

    @DisplayName("형식에 맞지 않는 당첨 번호 혹은 보너스 번호 입력시 예외 발생")
    @ParameterizedTest
    @MethodSource("provideUserWinNumber")
    void isWinNumberInvalid(String winNumber,String bonusNumber) {

        assertThatThrownBy(() -> wn.makingWinNumber(winNumber,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
