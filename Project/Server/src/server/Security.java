package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Security {

	private Map<String, String> personMap = new HashMap();
	private static String fileName = "src/file.txt";
	private static FileWriter fw;
	private static BufferedWriter bw;
	private static FileReader fr;
	private static BufferedReader br;

	public Security() {
		go();
	}

	public void go() {

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String s = null;
			int a;
			while ((s = br.readLine()) != null) {
				a = s.indexOf("|");
				personMap.put(s.substring(0, a), s.substring(a + 1, s.length()));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validation(String login, String password, ArrayList<String> loginList) {

		long count = loginList.stream().filter(string -> string.equals(login)).count();

		if (count == 0) {
			for (Map.Entry<String, String> entry : personMap.entrySet()) {
				if (entry.getKey().equals(login) && entry.getValue().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean registration(String login, String password) {

		for (Map.Entry<String, String> entry : personMap.entrySet()) {
			if (entry.getKey().equals(login)) {
				return false;
			}
		}
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			for (Map.Entry<String, String> entry1 : personMap.entrySet()) {
				bw.write(entry1.getKey() + "|" + entry1.getValue() + "\n");
			}
			bw.write(login + "|" + password + "\n");
			bw.close();
			go();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
