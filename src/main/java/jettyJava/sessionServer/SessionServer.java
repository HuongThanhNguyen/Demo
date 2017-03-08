package jettyJava.sessionServer;

import java.time.LocalTime;

public class SessionServer {

	private String user;
	private String pass;
	private LocalTime timeToLive;

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

	public SessionServer(String user, String pass, LocalTime timeToLive) {
		super();
		this.user = user;
		this.pass = pass;
		this.timeToLive = timeToLive;
	}
}
