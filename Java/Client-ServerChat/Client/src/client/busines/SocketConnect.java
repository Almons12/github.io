package client.busines;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import client.Radio;
import client.GUI.GuiClient;

public class SocketConnect {

	public Socket sock;
	private BufferedReader reader;
	public PrintWriter writer;
	private byte isAnswer;

	public byte getIsAnswer() {
		return isAnswer;
	}

	public void setUpNetworking(String login, String password, boolean loginOrRegister)
			throws UnknownHostException, IOException {
		sock = new Socket("127.0.0.1", 5000);
		InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
		reader = new BufferedReader(streamReader);
		writer = new PrintWriter(sock.getOutputStream());
		writer.println(login);
		writer.flush();
		writer.println(password);
		writer.flush();
		writer.println(loginOrRegister);
		writer.flush();
		isAnswer = Byte.parseByte(reader.readLine());
		System.out.println(isAnswer);
	}

	public void threadStart() {
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
	}

	public void threadRadio() {
		Thread readerThread = new Thread(new Radio());
		readerThread.start();
	}

	private class IncomingReader implements Runnable {

		@Override
		public void run() {

			String message;
			char messCh;
			try {
				while ((message = reader.readLine()) != null) {
					messCh = message.charAt(0);
					switch (messCh) {
					case '!':
						GuiClient.incoming.append(message.substring(1, message.length()) + "\n");
						GuiClient.incoming.setCaretPosition(GuiClient.incoming.getDocument().getLength());
						break;
					case '$':
						GuiClient.list.setText("");
						GuiClient.list.append(replaceList(message));
						break;
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, GuiClient.local.getConnectDrop());
				System.exit(0);
			}
		}
	}

	private String replaceList(String message) {

		String str = message.replaceAll("[\\$\\[\\]]", "");
		return str.replace(", ", "\n");
	}

}
