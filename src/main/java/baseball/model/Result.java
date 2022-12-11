package baseball.model;

public enum Result {
	NOTHING("낫싱"),
	STRIKE("%d스트라이크"),
	BALL("%d볼"),
	BALL_STRIKE("%d볼 %d스트라이크"),
	;

	private final String result;

	Result(String result) {
		this.result = result;
	}

	public static String of(Score score) {
		if (score.isNothing()) {
			return NOTHING.result;
		}
		if (score.isStrike()) {
			return String.format(STRIKE.result, score.getNumberOfStrikes());
		}
		if (score.isBall()) {
			return String.format(BALL.result, score.getNumberOfBalls());
		}
		return String.format(BALL_STRIKE.result, score.getNumberOfBalls(), score.getNumberOfStrikes());
	}
}
