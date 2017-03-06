package mongoDatabase.main;

import java.net.UnknownHostException;

import mongoDatabase.connecMongo.InsertDeleteCreateDocumentInMongoDB;
import mongoDatabase.thread.Birth;
import mongoDatabase.thread.Die;
import mongoDatabase.thread.Update;
/*
 * Demo kết nối tới MongoDB, sử dụng để lưu dữ liệu.
 * tạo 3 thread: Birth, Update, Die
 * Với Birth: bao gồm: ID: ObjectId(random); name(random); age(defaul=0)
 * thread Birth có chức năng: Random số lượng user mang các đặc tính trên và lưu nó vào MongoDB
 * Thread Update có chức năng là sau mỗi một lần chạy thread Birth thì user.age được tự động tăng 1.
 * Thread Die có chức năng là random phần trăm chết đi của 1 user. nếu % lớn hơn 50 thì user đó đã chết, nhỏ hơn 50 user đó còn sống.
 * chương trình thực hiện khi số lượng user còn sống đạt một MAX được cho trước.
 * */
public class Main {

	private static final int MAX_POPULATION = 5000;
	public static int max_Age_Current = 0;

	public static void main(String args[]) throws UnknownHostException {
		int m = 0;
		int i = 0;
		while (m < MAX_POPULATION) {
			Birth birth = new Birth();
			birth.start();
			try {
				birth.join();
				max_Age_Current++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Update update = new Update();
			update.start();
			try {
				update.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i == 0) {
				InsertDeleteCreateDocumentInMongoDB.createDocumentAgeLT18();
			}
			if (i == 18) {
				InsertDeleteCreateDocumentInMongoDB.createDocumentAgeGTE18();
			}
			if (i == 50) {
				InsertDeleteCreateDocumentInMongoDB.createDocumentDie();
			}
			Die die = new Die();
			die.start();
			try {
				die.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			m = InsertDeleteCreateDocumentInMongoDB.countFlagE0();
			i++;
		}
		InsertDeleteCreateDocumentInMongoDB.displayCollection();

	}

}
