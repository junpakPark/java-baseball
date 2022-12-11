package baseball.model;

import java.util.Set;
import java.util.stream.Collectors;

public class Referee {

	private final int PLAYING_NUMBER_SIZE = 3;

	private final PlayingNumbers pitcherNumbers;
	private final Score score;

	public Referee(PlayingNumbers pitcherNumbers) {
		this.pitcherNumbers = pitcherNumbers;
		this.score = new Score();
	}

	public Score judgeScore(PlayingNumbers batterNumbers) {
		resetScore();
		getNumberOfStrikes(batterNumbers);
		getNumberOfBalls(batterNumbers);
		return score;
	}

	private void resetScore() {
		score.setNumberOfStrikes(0);
		score.setNumberOfBalls(0);
	}

	private void getNumberOfStrikes(PlayingNumbers batterNumbers) {
		for (int index = 0; index < PLAYING_NUMBER_SIZE; index++) {
			if (pitcherNumbers.getPlayingNumbers().get(index).equals(batterNumbers.getPlayingNumbers().get(index))) {
				score.setNumberOfStrikes(score.getNumberOfStrikes() + 1);
			}
		}
	}

	private void getNumberOfBalls(PlayingNumbers batterNumbers) {
		Set<Integer> ballNumbers = pitcherNumbers.getPlayingNumbers()
			.stream()
			.filter(batterNumbers.getPlayingNumbers()::contains)
			.collect(Collectors.toSet());

		score.setNumberOfBalls(Math.max(0, ballNumbers.size() - score.getNumberOfStrikes()));
	}

}
