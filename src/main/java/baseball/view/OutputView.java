package baseball.view;

import baseball.model.Result;
import baseball.model.Score;

public class OutputView {

	public static void printResult(Score score) {
		System.out.println(Result.of(score));
	}
}
