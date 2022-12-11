package baseball.model;

public class Baseball {

	private final Pitcher pitcher;
	private final Referee referee;

	public Baseball() {
		this.pitcher = new Pitcher();
		this.referee = new Referee(pitcher.getPlayingNumbers());
	}

	public Score playInning(String numbers) {
		Batter batter = new Batter(numbers);
		return referee.judgeScore(batter.getPlayingNumbers());
	}

	public boolean isKeepInning(Score score) {
		return !Result.of(score).equals("3스트라이크");
	}
}
