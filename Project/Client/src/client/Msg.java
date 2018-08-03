package client;

public enum Msg {
	RU("Сообщения пользователей", 
			"Список пользователей", 
			"Введите ваш логин и пароль", 
			"Введите корректные данные!", 
			"Сервер недоступный",
			"Войти",
			"Отправить",
			"Вы подключились к чату! \n",
			"Введите сообщение!",
			"Пользователь: ",
			"Введите ваше сообщение",
			"Соединение с сервером потеряно"),
	
	UA("Повідомлення користувачів", 
			"Список користувачів", 
			"Введіть ваш логін і пароль", 
			"Введіть корректні данні!", 
			"Сервер недоступний",
			"Увійти",
			"Надіслати",
			"Ви підключились до чату! \n",
			"Введіть повідомлення!",
			"Користувач: ",
			"Введіть ваше повідомлення",
			"З'єднання з сервером втраченно!");

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
			String connectDrop) {
		
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
	
	

	
}
