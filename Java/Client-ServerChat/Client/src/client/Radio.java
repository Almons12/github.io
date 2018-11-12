
package client;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javazoom.jl.player.Player;

public class Radio implements Runnable {
	private Player player;
	private URL url;

	
	public void stop() {
		player.close();
	}

	@Override
	public void run() {
		try {
			url = new URL("http://localhost:8000/live");
			InputStream fin = url.openStream();
			InputStream is = new BufferedInputStream(fin);
			player = new Player(is);
			player.play();
		} catch (FileNotFoundException e) {
		} catch (Exception e) {
		}

	}

}
