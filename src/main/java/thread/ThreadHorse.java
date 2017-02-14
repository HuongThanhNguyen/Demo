package thread;

import java.util.Random;

public class ThreadHorse implements Runnable {
	private Random rd = new Random();
	private String nameHorse;
	private Thread t;

	public ThreadHorse(String name) {
		this.nameHorse = name;
	}

	public void run() {
		int tong = 0;
		int dem = 0;
		for (;;) {
			int i = rd.nextInt(10) + 1;

			if (tong == 100) {
				System.out.println(nameHorse + " ve dich voi " + dem + " buoc chay");
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

	public void start() {
		if (t == null) {
			t = new Thread(this, nameHorse);
			t.start();
		}
	}
}
