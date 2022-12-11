package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayingNumbers {

	private List<Integer> playingNumbers;

	public List<Integer> getPlayingNumbers() {
		return playingNumbers;
	}

	public PlayingNumbers(List<Integer> playingNumbers) {
		validateNull(playingNumbers);
		validateSize(playingNumbers);
		validateDuplicate(playingNumbers);
		validateList(playingNumbers);
		this.playingNumbers = playingNumbers;
	}

	private void validateNull(List<Integer> playingNumbers) {
		if (playingNumbers == null) {
			throw new IllegalArgumentException("입력된 값이 없습니다.");
		}
	}

	private void validateSize(List<Integer> playingNumbers) {
		if (playingNumbers.size() != 3) {
			throw new IllegalArgumentException("세 자리 수가 아닙니다.");
		}
	}

	private void validateDuplicate(List<Integer> playingNumbers) {
		Set<Integer> duplicate = new HashSet<>(playingNumbers);
		if (duplicate.size() != 3) {
			throw new IllegalArgumentException("서로 다른 수만 입력해주세요.");
		}
	}

	private void validateNumber(Integer number) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
		}
	}

	private void validateList(List<Integer> playingNumbers) {
		playingNumbers.forEach(this::validateNumber);
	}
}
