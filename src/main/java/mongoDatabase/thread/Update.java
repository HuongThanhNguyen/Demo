package mongoDatabase.thread;

import java.net.UnknownHostException;

import mongoDatabase.connecMongo.InsertDeleteCreateDocumentInMongoDB;
import mongoDatabase.main.Main;

public class Update extends Thread {
	private final int TimeSleep = 5;
	private final int max_Age_Current = Main.max_Age_Current;

	public void run() {
		try {
			InsertDeleteCreateDocumentInMongoDB.incAge(max_Age_Current);
			InsertDeleteCreateDocumentInMongoDB.insertDocumentAgeLT18();
			InsertDeleteCreateDocumentInMongoDB.insertDocumentAgeGTE18();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(TimeSleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
