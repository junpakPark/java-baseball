package baseball.model;

import java.util.List;

public enum Command {
	RESTART("1"), QUIT("2"),
	;

	private final String command;

	Command(String command) {
		this.command = command;
	}

	public static Command of(String command) {
		validate(command);
		if (command.equals(RESTART.command)) {
			return RESTART;
		}
		return QUIT;
	}

	public boolean isRestart() {
		return this == RESTART;
	}

	private static void validate(String command) {
		List<String> commands = List.of(RESTART.command, QUIT.command);
		if (!commands.contains(command)) {
			throw new IllegalArgumentException("1 혹은 2만 입력해주세요.");
		}
	}

	public String getCommand() {
		return command;
	}
}
