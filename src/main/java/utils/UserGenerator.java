package utils;

import businessobjects.User;

public class UserGenerator {
	
	User[] users = new User[3];

	public UserGenerator() {
		userGenerate();
	}

	public void userGenerate() {

		for (int i = 0; i < 3; i++) {
			users[i] = new User(PropertyProvider.getProperty("password" + i), PropertyProvider.getProperty("user" + i));
		}
	}

	public User getUser(int i) {
		return users[i];
	}

}
