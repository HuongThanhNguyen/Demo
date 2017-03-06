package jettyJava.mongodb;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class ConnecDB {
	private static final String HOST_NAME="localhost";
	private static final int POST=27017;
	
	public static MongoClient getMongoClient(){
		MongoClient mongoClient=null;
		try {
			mongoClient=new MongoClient(HOST_NAME,POST);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return mongoClient;
	}
}
