package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Pitcher {
	private final PlayingNumbers playingNumbers;

	public Pitcher() {
		this.playingNumbers = new PlayingNumbers(makeThreeNumbers());
	}

	public PlayingNumbers getPlayingNumbers() {
		return playingNumbers;
	}

	private List<Integer> makeThreeNumbers() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		return computer;
	}
}
