package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private int user_num;

	public LoginUser() {
		this(0);
	}

	public LoginUser(int user_num) {
		this.user_num = user_num;
	}

	public int getUser_name() {
		return user_num;
	}

	public void setUser_name(int user_num) {
		this.user_num = user_num;
	}
}
