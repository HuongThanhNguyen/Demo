package jettyJava.server;

import com.google.gson.annotations.Since;

public class Respond {

	private String message;
	@Since(1.1)private String token;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Respond(String message, String token) {
		super();
		this.message = message;
		this.token = token;
	}
}
