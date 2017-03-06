package mongoDatabase.thread;

import java.net.UnknownHostException;
import java.util.Random;
import java.util.UUID;

import org.bson.types.ObjectId;

import mongoDatabase.connecMongo.InsertDeleteCreateDocumentInMongoDB;

public class Birth extends Thread {
	private ObjectId objectId;
	private String userName;
	private int age;
	private final int TIMESLEEP = 5;
	private final int MAX_RANDOM = 101;
	private int flag;

	public String getUserName() {
		return userName;
	}

	public int getAge() {
		return age;
	}

	public void run() {
		Random rd = new Random();
		int n = rd.nextInt(MAX_RANDOM);
		for (int i = 0; i < n; i++) {
			userName = UUID.randomUUID().toString();
			age = 0;
			flag = 0;
			objectId = new ObjectId();
			try {
				InsertDeleteCreateDocumentInMongoDB.createDocument(objectId, userName, age, flag);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			System.out.println(objectId + ": " + userName + ": " + age);
		}
		try {
			Thread.sleep(TIMESLEEP);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}
