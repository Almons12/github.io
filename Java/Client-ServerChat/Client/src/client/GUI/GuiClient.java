package client.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Exception.LoginFail;
import Exception.LoginIsEmpty;
import client.CheckLogin;
import client.Radio;
import client.busines.SocketConnect;

public class GuiClient extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTextArea incoming;
	public static JTextArea list;
	private JTextField outgoing;
	private JTextField login;
	private JPasswordField password;
	private JButton loginButton;
	private JButton sendButton;
	private JButton registrationButton;
	private JLabel systemMsg;
	private JLabel clientList;
	private JLabel messages;
	private JLabel message;
	private JLabel messgLogin;
	private JLabel clientName;
	private JScrollPane qScroller;
	private JScrollPane qScrollerList;
	public static Msg local;
	private GridBagConstraints constraints;
	private JComboBox changeLocal;
	private String client;
	private boolean loginOrRegister;
	private Radio radio;
	SocketConnect socketConnect = new SocketConnect();

	public void go() {
		setLocal();
		constraints = new GridBagConstraints();
		incoming = new JTextArea(15, 40);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		list = new JTextArea(15, 20);
		list.setLineWrap(true);
		list.setWrapStyleWord(true);
		list.setEditable(false);
		messages = new JLabel();
		message = new JLabel();
		clientList = new JLabel();
		messgLogin = new JLabel();
		sendButton = new JButton();
		loginButton = new JButton();
		registrationButton = new JButton();
		localUpdate();
		qScroller = new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		qScrollerList = new JScrollPane(list);
		qScrollerList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScrollerList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		outgoing = new JTextField(20);
		login = new JTextField(11);
		password = new JPasswordField(11);
		systemMsg = new JLabel();
		clientName = new JLabel();
		systemMsg.setForeground(Color.RED);
		sendButton.addActionListener(new SendButtonListener());
		loginButton.addActionListener(new LoginButtonListener());
		registrationButton.addActionListener(new RegistrationButtonListener());
		setResizable(false);
		setTitle("Chat");
		viewOne();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void localUpdate() {
		messages.setText(local.getMessages());
		message.setText(local.getMessage());
		clientList.setText(local.getClientList());
		messgLogin.setText(local.getMessgLogin());
		sendButton.setText(local.getSendButton());
		loginButton.setText(local.getLoginButton());
		registrationButton.setText(local.getRegistration());
	}

	private void viewOne() {
		setSize(260, 180);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		int x, y;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.gridheight = 1;
		setInGrid(messgLogin, x = 0, y = 0);
		setInGrid(changeLocal, 1, 0);
		setInGrid(login, 0, 1);
		setInGrid(password, 0, 2);
		setInGrid(loginButton, 0, 3);
		setInGrid(registrationButton, 0, 4);
		setInGrid(systemMsg, 0, 5);
	}

	private void viewTwo() {
		setSize(740, 400);
		setLocationRelativeTo(null);
		remove(messgLogin);
		remove(login);
		remove(password);
		remove(loginButton);
		remove(systemMsg);
		remove(changeLocal);
		remove(registrationButton);
		setLayout(new GridBagLayout());
		int x, y;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.gridheight = 1;
		setInGrid(messages, x = 0, y = 0);
		setInGrid(clientList, 1, 0);
		setInGrid(qScroller, 0, 1);
		setInGrid(qScrollerList, 1, 1);
		setInGrid(message, 0, 2);
		setInGrid(outgoing, 0, 3);
		setInGrid(clientName, 1, 3);
		setInGrid(sendButton, 0, 4);
		setInGrid(systemMsg, 0, 5);
	}

	private void setInGrid(Component component, int x, int y) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(component, constraints);
	}

	private void setLocal() {
		local = Msg.UA;
		String[] items = { "UA", "RU", "EN" };
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) changeLocal.getSelectedItem();
				local = Msg.valueOf(item);
				localUpdate();
			}
		};
		changeLocal = new JComboBox(items);
		changeLocal.addActionListener(actionListener);
	}

	private class SendButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (outgoing.getText().equals("")) {
				systemMsg.setText(local.getEnterMsg());
			} else {
				systemMsg.setText("");
				socketConnect.writer.println(outgoing.getText());
				socketConnect.writer.flush();
				outgoing.setText("");
				outgoing.requestFocus();
			}
		}
	}

	private class RegistrationButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				CheckLogin.loginIsEmpty(login.getText(), password.getText());
				systemMsg.setText("");
				loginOrRegister = false;
				socketConnect.setUpNetworking(login.getText(), password.getText(), loginOrRegister);
				if (socketConnect.getIsAnswer() == 5) {
					systemMsg.setText(local.getRegTr());
				}
				if (socketConnect.getIsAnswer() == 4) {
					systemMsg.setText(local.getRegFl());
				}
				socketConnect.sock.close();
			} catch (IOException e1) {
				systemMsg.setText(local.getConnectfail());
			} catch (LoginIsEmpty e1) {
				systemMsg.setText(e1.getMessage());
			}
		}
	}

	private class LoginButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				CheckLogin.loginIsEmpty(login.getText(), password.getText());
				loginOrRegister = true;
				socketConnect.setUpNetworking(login.getText(), password.getText(), loginOrRegister);
				systemMsg.setText("");
				client = login.getText();
				login.setText("");
				password.setText("");
				CheckLogin.init(socketConnect.getIsAnswer());
				socketConnect.threadStart();
				viewTwo();
				socketConnect.threadRadio();
				clientName.setText(local.getClient() + client);
				setTitle("Chat:  " + client);
				incoming.append(local.getConnectToChat());
			} catch (IOException e1) {
				systemMsg.setText(local.getConnectfail());
			} catch (LoginFail e1) {
				systemMsg.setText(e1.getMessage());
				try {
					socketConnect.sock.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			} catch (LoginIsEmpty e1) {
				systemMsg.setText(e1.getMessage());
			}
		}
	}

	
}
