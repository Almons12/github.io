package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ClientHandler1 {

	private ArrayList clientOutputStreams;
	private String login;
	private BufferedReader reader;
	private ArrayList<String> loginList = new ArrayList();
	private String password;
	private SecurityNew security = new SecurityNew();
	private boolean log;
	private boolean reg;
	private boolean log1;

	public class ClientHandler implements Runnable {

		BufferedReader reader;
		Socket sock;
		String login1;

		public ClientHandler(Socket clientSocket, String login) {
			try {
				this.login1 = login;
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
				loginList.add(login1);
				list(loginList);
				tellEveryone("���������� " + login1 + " ������ � ���!");
				System.out.println("got a connection");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					tellEveryone(login1 + ": " + message);
				}
			} catch (Exception ex) {
				loginList.remove(login1);
				list(loginList);
				tellEveryone("���������� " + login1 + " ������ � ����!");
			}
		}
	}

	public void go() {
		clientOutputStreams = new ArrayList();
		try {
			ServerSocket serverSock = new ServerSocket(5000);
			System.out.println("Run...");
			while (true) {
				Socket clientSocket = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);

				InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
				reader = new BufferedReader(isReader);
				login = reader.readLine();
				password = reader.readLine();
				reg = Boolean.parseBoolean(reader.readLine());
				if (reg) {
					log = security.validation(login, password, loginList);
					writer.println(log);
					writer.flush();
				} else {
					log1 = security.registration(login, password);
					writer.println(log1);
					writer.flush();
				}
				if (log) {
					Thread t = new Thread(new ClientHandler(clientSocket, login));
					t.start();
				}
				log = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void tellEveryone(String message) {
		Iterator it = clientOutputStreams.iterator();
		while (it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println("!" + message);
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void list(ArrayList<String> login) {
		Iterator it = clientOutputStreams.iterator();
		while (it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println("$" + login);
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
