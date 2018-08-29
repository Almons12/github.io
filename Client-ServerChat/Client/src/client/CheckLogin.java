package client;

import Exception.LoginFail;
import Exception.LoginIsEmpty;

public class CheckLogin extends GuiClient {

	public static void init(byte isAnswer) throws LoginFail {

		if (isAnswer == 3) {
			throw new LoginFail(local.getLoginFail());
		}
		if (isAnswer == 2) {
			throw new LoginFail(local.getUserIsOnline());
		}
		if (isAnswer == 6) {
			throw new LoginFail(local.getUserIsBanned());
		}

	}

	public static boolean loginIsEmpty(String login, String password) throws LoginIsEmpty {

		if (login.equals("") | password.equals("")) {
			throw new LoginIsEmpty(local.getLoginEmpty());
		}

		return true;

	}

}
