package client;

public enum Msg {
	RU("��������� �������������", 
			"������ �������������", 
			"������� ��� ����� � ������", 
			"������� ���������� ������!", 
			"������ �����������",
			"�����",
			"���������",
			"�� ������������ � ����! \n",
			"������� ���������!",
			"������������: ",
			"������� ���� ���������",
			"���������� � �������� ��������",
			"������������������",
			"������������ ���������������",
			"������������ ��� ����������"),
	
	UA("����������� ������������", 
			"������ ������������", 
			"������ ��� ���� � ������", 
			"������ �������� ����!", 
			"������ �����������",
			"�����",
			"��������",
			"�� ����������� �� ����! \n",
			"������ �����������!",
			"����������: ",
			"������ ���� �����������",
			"�'������� � �������� ���������!",
			"��������������",
			"����������� �������������",
			"���������� ��� ����");

	private final String messages;
	private final String clientList;
	private final String messgLogin;
	private final String loginfail;
	private final String connectfail;
	private final String loginButton;
	private final String sendButton;
	private final String connectToChat;
	private final String enterMsg;
	private final String client;
	private final String message;
	private final String connectDrop;
	private final String registration;
	private final String regTr;
	private final String regFl;
	
	private Msg(String messages,
			String clientList,
			String messgLogin,
			String loginfail,
			String connectfail,
			String loginButton,
			String sendButton,
			String connectToChat,
			String enterMsg,
			String client,
			String message,
			String connectDrop,
			String registration,
			String regTr,
			String regFl) {
		
		this.messages = messages;
		this.clientList = clientList;
		this.messgLogin = messgLogin;
		this.loginfail = loginfail;
		this.connectfail = connectfail;
		this.loginButton = loginButton;
		this.sendButton = sendButton;
		this.connectToChat = connectToChat;
		this.enterMsg = enterMsg;
		this.client = client;
		this.message = message;
		this.connectDrop = connectDrop;
		this.registration = registration;
		this.regTr = regTr;
		this.regFl = regFl;
	}

	public String getMessages() {
		return messages;
	}

	public String getClientList() {
		return clientList;
	}

	public String getMessgLogin() {
		return messgLogin;
	}

	public String getLoginfail() {
		return loginfail;
	}

	public String getConnectfail() {
		return connectfail;
	}

	public String getLoginButton() {
		return loginButton;
	}

	public String getSendButton() {
		return sendButton;
	}

	public String getConnectToChat() {
		return connectToChat;
	}

	public String getEnterMsg() {
		return enterMsg;
	}

	public String getClient() {
		return client;
	}

	public String getMessage() {
		return message;
	}

	public String getConnectDrop() {
		return connectDrop;
	}

	public String getRegistration() {
		return registration;
	}

	public String getRegTr() {
		return regTr;
	}

	public String getRegFl() {
		return regFl;
	}
	
	

	
}
