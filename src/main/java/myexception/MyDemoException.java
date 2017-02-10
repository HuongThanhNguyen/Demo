package myexception;

public class MyDemoException {
	static void tong2SoDuong(int a, int b) throws MyException {
		if (a < 0 || b < 0) {
			throw new MyException();
		}
		System.out.println(a + b);
	}

	public static void main(String args[]) {

		try {
			tong2SoDuong(10, 15);
			tong2SoDuong(-3, 10);
		} catch (MyException e) {
			System.out.println(e);
		}
	}
}
