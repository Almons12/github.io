package client;

import Exception.LoginFail;
import Exception.LoginIsEmpty;

public class CheckLogin extends GuiClient {

	public static void init(boolean b) throws LoginFail {

		if (!b) {
			throw new LoginFail(local.getLoginFail());
		}

	}

	public static boolean loginIsEmpty(String login, String password) throws LoginIsEmpty {

		if (login.equals("") | password.equals("")) {
			throw new LoginIsEmpty(local.getLoginFail());
		}

		return false;

	}

}
