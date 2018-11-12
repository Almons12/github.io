package server;

public class Clients {

	private int id;
	private String login;
	private String password;
	private byte banned;
	
	public int getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public byte getBanned() {
		return banned;
	}
	public Clients(int id, String login, String password, byte banned) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.banned = banned;
	}
	
	
}
