package jettyJava.session;

import java.time.LocalTime;

public class Session {

	private String user;
	private String pass;
	private LocalTime timeToLive;
	private String token;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setTimeToLive(LocalTime timeToLive) {
		this.timeToLive = timeToLive;
	}

	public LocalTime getTimeToLive() {
		return timeToLive;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Session(String user, String pass, LocalTime timeToLive,String token) {
		super();
		this.user = user;
		this.pass = pass;
		this.timeToLive = timeToLive;
		this.token=token;
	}
}
