package baseball.controller;

import baseball.model.Baseball;
import baseball.model.Score;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

	public void run() {
		do {
			playInning();
		} while (InputView.isKeepGaming());
	}

	private void playInning() {
		boolean isKeepInning = true;
		Baseball baseball = new Baseball();
		while (isKeepInning) {
			Score score = baseball.playInning(InputView.scanInput());
			OutputView.printResult(score);
			isKeepInning = baseball.isKeepInning(score);
		}
	}
}
