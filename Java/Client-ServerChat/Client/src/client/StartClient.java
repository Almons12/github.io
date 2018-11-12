package client;

import client.GUI.GuiClient;

public class StartClient {

	public static void main(String[] args) {
		new SplashScr();
		GuiClient client = new GuiClient();
		client.go();
	}

}
