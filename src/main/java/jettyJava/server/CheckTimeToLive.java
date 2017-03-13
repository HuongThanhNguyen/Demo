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
		
		while (Server.sessiones.size() >= 0) {
			System.out.println(Server.sessiones.size());
			Set<String> nameUser = Server.sessiones.keySet();
			for (String string : nameUser) {
				localTime=LocalTime.now();
				timeConnect = Duration.between(Server.sessiones.get(string).getTimeToLive(), localTime);
				if (timeConnect.toMillis() >= 0) {
					Server.sessiones.remove(string);
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
