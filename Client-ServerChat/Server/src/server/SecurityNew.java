package server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SecurityNew {

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
			// clientMap.put(result1.getString("login"), result1.getString("password"));
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
		readDB();
		return 5;// client reg
	}

}
