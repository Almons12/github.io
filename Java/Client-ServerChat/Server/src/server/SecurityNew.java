package server;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class SecurityNew {

	static {
		new DOMConfigurator().doConfigure("src/log4j.xml", LogManager.getLoggerRepository());
	}
	static Logger logger = Logger.getLogger(SecurityNew.class);
	
	
	private Map<String, String> clientMap = new HashMap();
	private JDBCConnectionPool pool;
	private Statement statement;
	private Connection connection;
	private ResultSet rs;
	private ArrayList<Clients> list;

	private final static String DRIVER = "com.mysql.jdbc.Driver";

	public SecurityNew() {
		try {
			pool = new JDBCConnectionPool(DRIVER, "jdbc:mysql://localhost:3306/test", "root", "");
			connection = pool.checkOut();
			statement = connection.createStatement();
			readDB();
		} catch (SQLException e) {
			System.out.println("Server not found!");
		}

	}

	public void readDB() throws SQLException {
		list = new ArrayList<>();
		list.clear();
		rs = statement.executeQuery("SELECT * FROM clients;");

		while (rs.next()) {
			list.add(new Clients(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getByte(4)));

		}
	}

	public byte validation(String login, String password, ArrayList<String> loginList) throws SQLException {
		readDB();
		long count = loginList.stream().filter(string -> string.equals(login)).count();

		if (count == 0) {
			for (Clients client : list) {
				if (client.getLogin().equals(login) && client.getPassword().equals(password)
						&& client.getBanned() == 1) {
					return 6;// client is banned
				}
				if (client.getLogin().equals(login) && client.getPassword().equals(password)) {
					return 1;// client is
				}
			}
		} else {
			return 2;// client alredy is chat
		}
		return 3;// client not is
	}

	public byte registration(String login, String password) throws SQLException {
		readDB();
		for (Clients client : list) {
			if (client.getLogin().equals(login)) {
				return 4;// client alredy reg
			}
		}
		statement.executeUpdate("INSERT INTO clients (login, password) VALUES ('" + login + "','" + password + "');");
		logger.info("Client " + login + " register the chat! "+ LocalDateTime.now());
		readDB();
		return 5;// client reg
	}

	public void insertMessage(String login, String message) throws SQLException {

		statement.executeUpdate("INSERT INTO Message (Clients, Message, Time) VALUES ('" + login + "','" + message
				+ "','" + LocalDateTime.now() + "');");

	}
	

	public void insertClient(PrintWriter writer) throws SQLException {
		statement.executeUpdate("INSERT INTO test (Test) VALUES ('"+writer+"');");
		
	}
}
