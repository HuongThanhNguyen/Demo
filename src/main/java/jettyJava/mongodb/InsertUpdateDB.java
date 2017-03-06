package jettyJava.mongodb;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class InsertUpdateDB {
	private static final String DB_NAME = "UserWeb";
	private static final String COLLECTION_NAME = "login";
	private static MongoClient mongoClient = ConnecDB.getMongoClient();
	private static DB db = mongoClient.getDB(DB_NAME);
	private static DBCollection dbCollection = db.getCollection(COLLECTION_NAME);

	public static void insertCollection(String userName, String passWord) throws UnknownHostException {
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.append("_id", passWord);
		basicDBObject.append("userName", userName);
		dbCollection.insert(basicDBObject);
	}

	public static String checkUserPass(String user, String pass) {
		String userName = "";
		BasicDBObject basicDBObject = new BasicDBObject().append("_id", pass);
		DBCursor cursor = dbCollection.find(basicDBObject);
		while (cursor.hasNext()) {
			userName = cursor.next().get("userName").toString();
			System.out.println(userName);
		}
		if (userName.equals(user)) {
			return "true";
		} else {
			return "false";
		}
	}
}
