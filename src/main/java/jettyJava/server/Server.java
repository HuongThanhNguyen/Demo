package jettyJava.server;

import java.util.HashMap;
import java.util.Map;

import jettyJava.session.Session;

public class Server {
	public static Map<String, Session> sessiones = new HashMap<>();

	public static void start() {
		org.eclipse.jetty.server.Server s = new org.eclipse.jetty.server.Server(8888);
		s.setHandler(new Handler() {});

		CheckTimeToLive checkTimeToLive = new CheckTimeToLive();
		try {
			s.start();
			checkTimeToLive.start();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			s.join();
			checkTimeToLive.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		start();

	}

}