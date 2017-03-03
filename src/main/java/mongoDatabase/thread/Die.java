package mongoDatabase.thread;

import java.net.UnknownHostException;

import mongoDatabase.connecMongo.InsertDeleteCreateDocumentInMongoDB;

public class Die extends Thread {
	private final int TimeSleep = 5;

	public void run() {
		try {
			InsertDeleteCreateDocumentInMongoDB.insertDocumentDie();

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
