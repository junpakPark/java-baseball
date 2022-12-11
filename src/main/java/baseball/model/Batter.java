package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Batter {

	private final PlayingNumbers playingNumbers;

	public Batter(String input) {
		this.playingNumbers = new PlayingNumbers(splitDigits(input));
	}

	public PlayingNumbers getPlayingNumbers() {
		return playingNumbers;
	}

	private List<Integer> splitDigits(String input) {
		return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
	}
}
