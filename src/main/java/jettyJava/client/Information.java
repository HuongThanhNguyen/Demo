package jettyJava.client;

public class Information {

	private String user;
	private String pass;
	private String api;

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

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public Information(String user, String pass, String api) {
		super();
		this.user = user;
		this.pass = pass;
		this.api = api;
	}
}
