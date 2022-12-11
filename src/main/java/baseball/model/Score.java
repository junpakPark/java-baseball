package baseball.model;

public class Score {

	int numberOfBalls;

	int numberOfStrikes;

	public Score() {
		this.numberOfBalls = 0;
		this.numberOfStrikes = 0;
	}

	public int getNumberOfBalls() {
		return numberOfBalls;
	}

	public void setNumberOfBalls(int numberOfBalls) {
		this.numberOfBalls = numberOfBalls;
	}

	public int getNumberOfStrikes() {
		return numberOfStrikes;
	}

	public void setNumberOfStrikes(int numberOfStrikes) {
		this.numberOfStrikes = numberOfStrikes;
	}

	public boolean isNothing() {
		return isStrike() && isBall();
	}

	public boolean isBall() {
		return numberOfStrikes == 0;
	}

	public boolean isStrike() {
		return numberOfBalls == 0;
	}
}
