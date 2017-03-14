package jettyJava.server;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;

public class CheckTimeToLive extends Thread {
	private static final int TIMESLEEP = 1;
	private static Duration timeConnect;
	private static LocalTime localTime;

	public void run() {
		deleteSession();
	}

	public synchronized void deleteSession() {
		
		while (Server.sessions.size() >= 0) {
			Set<String> nameUser = Server.sessions.keySet();
			for (String string : nameUser) {
				localTime=LocalTime.now();
				timeConnect = Duration.between(Server.sessions.get(string).getTimeToLive(), localTime);
				if (timeConnect.toMillis() >= 0) {
					Server.sessions.remove(string);
				}
			}
			try {
				Thread.sleep(TIMESLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
