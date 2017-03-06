package mongoDatabase.thread;

import java.net.UnknownHostException;

import mongoDatabase.connecMongo.InsertDeleteCreateDocumentInMongoDB;
import mongoDatabase.main.Main;

public class Update extends Thread {
	private final int TIMESLEEP = 5;
	private final int MAX_AGE_CURRENT = Main.max_Age_Current;

	public void run() {
		try {
			InsertDeleteCreateDocumentInMongoDB.incAge(MAX_AGE_CURRENT);
			InsertDeleteCreateDocumentInMongoDB.insertDocumentAgeLT18();
			InsertDeleteCreateDocumentInMongoDB.insertDocumentAgeGTE18();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(TIMESLEEP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
