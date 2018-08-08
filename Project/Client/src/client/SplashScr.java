package client;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.SplashScreen;

public class SplashScr {

	public SplashScr() {
		SplashScreen splash = SplashScreen.getSplashScreen();
		Rectangle bounds = splash.getBounds();
		Graphics2D g2 = splash.createGraphics();
		g2.setColor(Color.blue);

		for (int i = 0; i <= 100; i++) {
			g2.fillRect(0, bounds.height-20, bounds.width * i / 100, 20);
			splash.update();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
