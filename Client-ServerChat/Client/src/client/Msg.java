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
			"Соединение с сервером потеряно",
			"Зарегистрироваться",
			"Пользователь зарегистрирован",
			"Пользователь уже существует",
			"Неверный логин или пароль"),
	
	UA("Повідомлення користувачів", 
			"Список користувачів", 
			"Введіть ваш логін і пароль", 
			"Введіть коректні дані!", 
			"Сервер недоступний",
			"Увійти",
			"Надіслати",
			"Ви підключились до чату! \n",
			"Введіть повідомлення!",
			"Користувач: ",
			"Введіть ваше повідомлення",
			"З'єднання з сервером втрачено!",
			"Зареєструватись",
			"Користувача зареєстрованно",
			"Користувач вже існує",
			"Невірний логін або пароль"),
	
	EN("User messages", 
			"User list", 
			"Enter your login and password", 
			"Enter the correct data!", 
			"The server is not available",
			"Sign in",
			"Send",
			"Connected to chat! \n",
			"Enter a message!",
			"User: ",
			"Enter your message",
			"Connection to the server lost!",
			"Register",
			"User is registered",
			"User already exists",
			"Invalid login or password");

	private final String messages;
	private final String clientList;
	private final String messgLogin;
	private final String loginEmpty;
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
	private final String loginFail;
	
	private Msg(String messages,
			String clientList,
			String messgLogin,
			String loginEmpty,
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
			String regFl,
			String loginFail) {
		
		this.messages = messages;
		this.clientList = clientList;
		this.messgLogin = messgLogin;
		this.loginEmpty = loginEmpty;
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
		this.loginFail = loginFail;
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

	public String getLoginEmpty() {
		return loginEmpty;
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

	public String getLoginFail() {
		return loginFail;
	}
	
	

	
}
