package baseball.view;

import baseball.model.Command;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String scanInput() {
		System.out.println("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	public static boolean isKeepGaming() {
		System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
			3,
			Command.RESTART.getCommand(),
			Command.QUIT.getCommand());
		return Command.of(Console.readLine()).isRestart();
	}
}
