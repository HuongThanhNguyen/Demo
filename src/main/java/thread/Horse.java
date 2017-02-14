package thread;

/*
 * lam bai toan dua ngua:
 * co 10 con ngua cung xuat phat cung luc
 * cu sau nua giay, moi con se chay mot buoc la mot so int random tu 1 den 10
 * neu con ngua nao co quang duong bang tong cac buoc chay bang dung 100 thi con ngua do se ve dich va in ra
 * Con ngua thu xxx da ve dich voi yyy buoc chay.
 */
public class Horse {

	public static void main(String args[]) {

		ThreadHorse horse1 = new ThreadHorse("Con ngua thu 1");
		ThreadHorse horse2 = new ThreadHorse("Con ngua thu 2");
		ThreadHorse horse3 = new ThreadHorse("Con ngua thu 3");
		ThreadHorse horse4 = new ThreadHorse("Con ngua thu 4");
		ThreadHorse horse5 = new ThreadHorse("Con ngua thu 5");
		ThreadHorse horse6 = new ThreadHorse("Con ngua thu 6");
		ThreadHorse horse7 = new ThreadHorse("Con ngua thu 7");
		ThreadHorse horse8 = new ThreadHorse("Con ngua thu 8");
		ThreadHorse horse9 = new ThreadHorse("Con ngua thu 9");
		ThreadHorse horse10 = new ThreadHorse("Con ngua thu 10");

		horse1.start();
		horse2.start();
		horse3.start();
		horse4.start();
		horse5.start();
		horse6.start();
		horse7.start();
		horse8.start();
		horse9.start();
		horse10.start();
	}
}
