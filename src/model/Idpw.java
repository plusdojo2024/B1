package model;
import java.io.Serializable;

public class Idpw implements Serializable {
	private String user_name;
	private String user_pass;	// PW

	public Idpw(String user_name, String user_pass) {
		this.user_name = user_name;
		this.user_pass = user_pass;
	}

	public Idpw() {
		this.user_name = "";
		this.user_pass = "";
	}

	public String getName() {
		return user_name;
	}

	public void setName(String user_name) {
		this.user_name = user_name;
	}

	public String getPw() {
		return user_pass;
	}

	public void setPw(String user_pass) {
		this.user_pass = user_pass;
	}
}
