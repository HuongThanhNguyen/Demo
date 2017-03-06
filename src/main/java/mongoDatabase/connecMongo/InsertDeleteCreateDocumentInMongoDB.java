package mongoDatabase.connecMongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class InsertDeleteCreateDocumentInMongoDB {
	public static final String DB_NAME = "MyWorld";
	private static final String COLLECTION_NAME = "user";
	private static final int AGE_YOUNG = 18;
	private static final int AGE_OLD = 50;
	private static MongoClient mongoClient = ConnecToMongoDB.getMongoClient();;
	private static DB db = mongoClient.getDB(DB_NAME);
	private static DBCollection dbcl = db.getCollection(COLLECTION_NAME);
	private static DBCursor cursor;
	private static BasicDBObject query1;
	private static BasicDBObject query2;
	private static BasicDBObject query3;
	private static java.util.List<String> list = new ArrayList<>();
	private static java.util.List<String> list1 = new ArrayList<>();

	public static void createDocument(ObjectId objectId, String userName, int age, int flag)
			throws UnknownHostException {
		BasicDBObject doc = new BasicDBObject();
		doc.append("_id", objectId);
		doc.append("User_Name", userName);
		doc.append("age", age);
		doc.append("flag", flag);
		dbcl.insert(doc);
	}

	public static void createDocumentAgeLT18() throws UnknownHostException {
		BasicDBObject doc = new BasicDBObject();
		doc.append("_id", "AgeLT18");
		dbcl.insert(doc);
	}

	public static void createDocumentAgeGTE18() throws UnknownHostException {
		BasicDBObject doc = new BasicDBObject();
		doc.append("_id", "AgeGTE18");
		dbcl.insert(doc);
	}

	public static void createDocumentDie() throws UnknownHostException {
		BasicDBObject doc = new BasicDBObject();
		doc.append("_id", "Die");
		dbcl.insert(doc);
	}

	public static void displayCollection() throws UnknownHostException {
		cursor = dbcl.find();
		int i = 1;
		while (cursor.hasNext()) {
			System.out.println("Document: " + i);
			System.out.println(cursor.next());
			i++;
		}
		System.out.println(dbcl.count());
		query1 = new BasicDBObject().append("flag", 0);
		System.out.println(dbcl.find(query1).count());
	}

	public static int countFlagE0() throws UnknownHostException {
		query1 = new BasicDBObject().append("flag", 0);
		return (int) dbcl.find(query1).count();
	}

	public static void incAge(int max_Age_Current) throws UnknownHostException {

		query1 = new BasicDBObject().append("$inc", new BasicDBObject().append("age", 1));

		while (max_Age_Current >= 0) {
			max_Age_Current--;
			query2 = new BasicDBObject().append("age", max_Age_Current);
			query3 = new BasicDBObject().append("flag", 0);
			BasicDBList and = new BasicDBList();
			and.add(query2);
			and.add(query3);
			DBObject dbObject = new BasicDBObject("$and", and);
			dbcl.updateMulti(dbObject, query1);

		}
	}

	public static void insertDocumentAgeLT18() throws UnknownHostException {

		query1 = new BasicDBObject().append("age", new BasicDBObject().append("$lt", AGE_YOUNG));
		cursor = dbcl.find(query1);
		while (cursor.hasNext()) {
			list.add(cursor.next().get("_id").toString());
		}
		query2 = new BasicDBObject().append("$addToSet",
				new BasicDBObject().append("use", new BasicDBObject().append("$each", list)));
		dbcl.update(new BasicDBObject().append("_id", "AgeLT18"), query2);

		list.clear();

		query3 = new BasicDBObject().append("age", new BasicDBObject().append("$gte", AGE_YOUNG));
		DBCursor cursor2 = dbcl.find(query3);
		while (cursor2.hasNext()) {
			list1.add(cursor2.next().get("_id").toString());
		}
		query3 = new BasicDBObject().append("$pullAll", new BasicDBObject().append("use", list1));
		dbcl.update(new BasicDBObject().append("_id", "AgeLT18"), query3);
		list1.clear();
	}

	public static void insertDocumentAgeGTE18() throws UnknownHostException {

		query1 = new BasicDBObject().append("age", new BasicDBObject().append("$gte", AGE_YOUNG));
		cursor = dbcl.find(query1);
		while (cursor.hasNext()) {
			list1.add(cursor.next().get("_id").toString());
		}
		query2 = new BasicDBObject().append("$addToSet",
				new BasicDBObject().append("use", new BasicDBObject().append("$each", list1)));
		dbcl.update(new BasicDBObject().append("_id", "AgeGTE18"), query2);

		list1.clear();

	}

	public static void insertDocumentDie() throws UnknownHostException {
		Random rd = new Random();

		query1 = new BasicDBObject().append("age", new BasicDBObject().append("$gte", AGE_OLD));
		query2 = new BasicDBObject().append("flag", 0);
		BasicDBList and = new BasicDBList();
		and.add(query1);
		and.add(query2);
		DBObject dbObject = new BasicDBObject("$and", and);
		cursor = dbcl.find(dbObject);
		while (cursor.hasNext()) {
			Object s = cursor.next().get("_id");
			int numberRD = rd.nextInt(100) + 1;
			if (numberRD > 50) {
				query3 = new BasicDBObject().append("$set", new BasicDBObject().append("flag", 1));
				dbcl.update(new BasicDBObject().append("_id", s), query3);
				list.add(s.toString());
			}
		}
		BasicDBObject newDocument1 = new BasicDBObject().append("$addToSet",
				new BasicDBObject().append("use", new BasicDBObject().append("$each", list)));
		dbcl.update(new BasicDBObject().append("_id", "Die"), newDocument1);

		BasicDBObject newDocument2 = new BasicDBObject().append("$pullAll", new BasicDBObject().append("use", list));
		dbcl.update(new BasicDBObject().append("_id", "AgeGTE18"), newDocument2);
		list.clear();
	}
}
