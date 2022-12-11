package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class PlayingNumbersTest {

	@DisplayName("Null 입력시 메세지 리턴한다.")
	@ParameterizedTest
	@NullSource
	void validateNullTest(List<Integer> playingNumbers) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			PlayingNumbers numbers = new PlayingNumbers(playingNumbers);
		});
		assertEquals("입력된 값이 없습니다.", exception.getMessage());
	}

	@DisplayName("리스트의 사이즈가 3이 아닐 시 메시지를 리턴한다.")
	@ParameterizedTest
	@MethodSource("sizeParametersProvider")
	void validateSizeTest(List<Integer> playingNumbers) {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			PlayingNumbers numbers = new PlayingNumbers(playingNumbers);
		});
		assertEquals("세 자리 수가 아닙니다.", exception.getMessage());
	}

	@DisplayName("중복된 숫자가 있을 시 오류를 리턴한다.")
	@ParameterizedTest
	@MethodSource("duplicateParametersProvider")
	void validateDuplicateTest(List<Integer> playingNumbers) {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			PlayingNumbers numbers = new PlayingNumbers(playingNumbers);
		});
		assertEquals("서로 다른 수만 입력해주세요.", exception.getMessage());
	}

	@DisplayName("1~9 사이의 숫자가 아닐 시 오류를 리턴한다.")
	@ParameterizedTest
	@MethodSource("numberParametersProvider")
	void validateListTest(List<Integer> playingNumbers) {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			PlayingNumbers numbers = new PlayingNumbers(playingNumbers);
		});
		assertEquals("1~9 사이의 숫자만 입력해주세요.", exception.getMessage());
	}

	private static Stream<Arguments> sizeParametersProvider() {
		return Stream.of(
			Arguments.arguments(List.of()),
			Arguments.arguments(List.of(1)),
			Arguments.arguments(List.of(1, 2)),
			Arguments.arguments(List.of(1, 2, 3, 4))
		);
	}

	private static Stream<Arguments> duplicateParametersProvider() {
		return Stream.of(
			Arguments.arguments(List.of(1, 1, 1)),
			Arguments.arguments(List.of(1, 1, 2)),
			Arguments.arguments(List.of(1, 2, 2))
		);
	}

	private static Stream<Arguments> numberParametersProvider() {
		return Stream.of(
			Arguments.arguments(List.of(0, 1, 2)),
			Arguments.arguments(List.of(10, 1, 2)),
			Arguments.arguments(List.of(0, 10, -1))
		);
	}
}
