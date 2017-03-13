package jettyJava.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.json.simple.JSONObject;

import jettyJava.session.Session;

public abstract class Handler extends AbstractHandler {

	private static final String SUCCESS_RESPOND;
	private static final String ERROR_RESPOND;
	private static final String ERROR_EDIT_RESPOND;
	private static final String SUCCESS_EDIT_RESPOND;
	private static final String API_LOGIN = "login";
	private static final String API_EDIT = "edit";
	private static final int TIMETOLIVE=30;
	private static String user_Name;
	private static String pass;
	private static String api;
	private static String token;
	static {
		JSONObject json = new JSONObject();
		json.put("Message", "Success");
		SUCCESS_RESPOND = json.toJSONString();

		json = new JSONObject();
		json.put("Message", "Fail");
		ERROR_RESPOND = json.toJSONString();

		json = new JSONObject();
		json.put("Message", "edit user info success!");
		SUCCESS_EDIT_RESPOND = json.toJSONString();

		json = new JSONObject();
		json.put("Message", "user_name or password is error!");
		ERROR_EDIT_RESPOND = json.toJSONString();

	}

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		baseRequest.setHandled(true);
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		InputStreamReader isr = new InputStreamReader(request.getInputStream());
		BufferedReader reader = new BufferedReader(isr);
		String inputString = reader.readLine();
		String dataRespond = null;
		target = target.substring(1);
		String[] target1 = target.split("/");
		user_Name = target1[0];
		pass = target1[1];
		api = target1[2];
		if (api.equals(API_LOGIN)) {

			boolean checkUserPass = jettyJava.mongodb.InsertUpdateDB.checkUserPass(user_Name, pass);
			if (validateParameter(target)) {
				if (checkUserPass == true) {
					token = "this is Token" + user_Name;
					addSession(user_Name, pass, LocalTime.now(), token);
					dataRespond = SUCCESS_RESPOND;
				} else {
					dataRespond = ERROR_RESPOND;
				}
			} else {
				dataRespond = ERROR_RESPOND;
			}
		} else if (api.equals(API_EDIT)) {
			if (Server.sessiones.containsKey(user_Name) && Server.sessiones.size() > 0) {
				dataRespond = SUCCESS_EDIT_RESPOND;
			} else {
				dataRespond = ERROR_EDIT_RESPOND;
			}
		}
		System.out.println("input string: " + inputString);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(dataRespond);
		writer.flush();
		writer.close();
	}

	public static boolean validateParameter(String param) {
		return ((param != null) && (!param.equals("")));
	}
	public synchronized void addSession(String user, String pass, LocalTime timeToLive,String token){
		Server.sessiones.put(user_Name, new Session(user_Name, pass, LocalTime.now().plusMinutes(TIMETOLIVE), token));
	}
}
