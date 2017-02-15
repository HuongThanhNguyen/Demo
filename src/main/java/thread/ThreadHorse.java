package thread;

import java.util.Random;

public class ThreadHorse implements Runnable {
	final int tongS=100;
	private Random rd = new Random();
	private String nameHorse;
	private Thread t;

	public ThreadHorse(String name) {
		this.nameHorse = name;
	}

	public void run() {
		int tong = 0;
		int dem = 0;
		while(true) {
			int i = rd.nextInt(10) + 1;					
			if (tong < tongS) {
				dem++;
				tong += i;
				System.out.println(nameHorse+ ": "+tong);
				if (tong > tongS) {
					dem++;
					tong -=tongS;
					System.out.println(nameHorse+ ": "+tong);
				}
				if (tong == tongS) {
					System.out.println(nameHorse + " ve dich voi " + dem + " buoc chay");
					break;
				}	
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
