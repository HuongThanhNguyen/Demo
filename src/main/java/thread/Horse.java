package thread;

import java.util.Random;

/*
 * Làm bài toán đua ngựa:
Có 10 con ngựa cùng xuất phát cùng lúc
Cứ sau nửa giây, mỗi con sẽ chạy một bước là một số int random từ 1 đến 10
Nếu con ngựa nào có quãng đường bằng tổng các bước chạy bằng đúng 100 thì con ngựa đó sẽ về đích và in ra:
Con ngựa thứ xxx đã về đích với yyy bước chạy
Nếu quãng đường vượt quá 100, quãng đường sẽ bằng hiệu của nó với 100.
 */
public class Horse {
	static Random rd = new Random();

	public static void main(String args[]) {

		Thread horse1 = new Thread(new Runnable() {

			public void run() {
				int tong = 0;
				int dem = 0;
				for (;;) {
					int i = rd.nextInt(10) + 1;
					dem++;
					if (tong == 100) {
						System.out.println("con ngua thu 1 ve dich voi " + dem + " buoc chay");
						break;
					}
					if (tong > 100) {
						dem++;
						tong = tong - 100;
					}
					if (tong < 100) {
						dem++;
						tong = tong + i;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread horse2 = new Thread(new Runnable() {
			public void run() {
				int tong = 0;
				int dem = 0;
				for (;;) {
					int i = rd.nextInt(10) + 1;
					dem++;
					if (tong == 100) {
						System.out.println("con ngua thu 2 ve dich voi " + dem + " buoc chay");
						break;
					}
					if (tong > 100) {
						dem++;
						tong = tong - 100;
					}
					if (tong < 100) {
						dem++;
						tong = tong + i;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread horse3 = new Thread(new Runnable() {

			public void run() {
				int tong = 0;
				int dem = 0;
				for (;;) {
					int i = rd.nextInt(10) + 1;
					dem++;
					if (tong == 100) {
						System.out.println("con ngua thu 3 ve dich voi " + dem + " buoc chay");
						break;
					}
					if (tong > 100) {
						dem++;
						tong = tong - 100;
					}
					if (tong < 100) {
						dem++;
						tong = tong + i;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread horse4 = new Thread(new Runnable() {

			public void run() {
				int tong = 0;
				int dem = 0;
				for (;;) {
					int i = rd.nextInt(10) + 1;
					dem++;
					if (tong == 100) {
						System.out.println("con ngua thu 4 ve dich voi " + dem + " buoc chay");
						break;
					}
					if (tong > 100) {
						dem++;
						tong = tong - 100;
					}
					if (tong < 100) {
						dem++;
						tong = tong + i;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread horse5 = new Thread(new Runnable() {

			public void run() {
				int tong = 0;
				int dem = 0;
				for (;;) {
					int i = rd.nextInt(10) + 1;
					dem++;
					if (tong == 100) {
						System.out.println("con ngua thu 5 ve dich voi " + dem + " buoc chay");
						break;
					}
					if (tong > 100) {
						dem++;
						tong = tong - 100;
					}
					if (tong < 100) {
						dem++;
						tong = tong + i;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread horse6 = new Thread(new Runnable() {

			public void run() {
				int tong = 0;
				int dem = 0;
				for (;;) {
					int i = rd.nextInt(10) + 1;
					dem++;
					if (tong == 100) {
						System.out.println("con ngua thu 6 ve dich voi " + dem + " buoc chay");
						break;
					}
					if (tong > 100) {
						dem++;
						tong = tong - 100;
					}
					if (tong < 100) {
						dem++;
						tong = tong + i;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread horse7 = new Thread(new Runnable() {

			public void run() {
				int tong = 0;
				int dem = 0;
				for (;;) {
					int i = rd.nextInt(10) + 1;
					dem++;
					if (tong == 100) {
						System.out.println("con ngua thu 7 ve dich voi " + dem + " buoc chay");
						break;
					}
					if (tong > 100) {
						dem++;
						tong = tong - 100;
					}
					if (tong < 100) {
						dem++;
						tong = tong + i;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread horse8 = new Thread(new Runnable() {

			public void run() {
				int tong = 0;
				int dem = 0;
				for (;;) {
					int i = rd.nextInt(10) + 1;
					dem++;
					if (tong == 100) {
						System.out.println("con ngua thu 8 ve dich voi " + dem + " buoc chay");
						break;
					}
					if (tong > 100) {
						dem++;
						tong = tong - 100;
					}
					if (tong < 100) {
						dem++;
						tong = tong + i;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread horse9 = new Thread(new Runnable() {

			public void run() {
				int tong = 0;
				int dem = 0;
				for (;;) {
					int i = rd.nextInt(10) + 1;
					dem++;
					if (tong == 100) {
						System.out.println("con ngua thu 9 ve dich voi " + dem + " buoc chay");
						break;
					}
					if (tong > 100) {
						dem++;
						tong = tong - 100;
					}
					if (tong < 100) {
						dem++;
						tong = tong + i;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread horse10 = new Thread(new Runnable() {

			public void run() {
				int tong = 0;
				int dem = 0;
				for (;;) {
					int i = rd.nextInt(10) + 1;
					dem++;
					if (tong == 100) {
						System.out.println("con ngua thu 10 ve dich voi " + dem + " buoc chay");
						break;
					}
					if (tong > 100) {
						dem++;
						tong = tong - 100;
					}
					if (tong < 100) {
						dem++;
						tong = tong + i;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

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
