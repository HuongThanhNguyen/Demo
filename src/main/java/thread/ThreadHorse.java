package thread;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class ThreadHorse extends Thread {
	final int tongS=100;
	private Random rd = new Random();
	private String nameHorse;
	private LocalTime time1,time2;
	private int stepHorse=0;
	private Duration timeRace;
	
	public Duration getTimeRace() {
		return timeRace;
	}
	public ThreadHorse(String object) {
		this.nameHorse = object;
	}
	public int getStepHorse() {
		return stepHorse;
	}
	public String getNameHorse() {
		return nameHorse;
	}
	public void run() {
		time1=LocalTime.now();
		int tong = 80;
		while(true) {
			int i = rd.nextInt(10) + 1;					
			if (tong < tongS) {
				stepHorse++;
				tong += i;
				if (tong > tongS) {
					stepHorse++;
					tong -=tongS;
				}
				if (tong == tongS) {
					time2=LocalTime.now();
					timeRace=Duration.between(time1, time2);					
					String s=nameHorse+ " ve dich voi " + stepHorse + " buoc chay"+" voi time: "+timeRace;
					System.out.println(s);
					Horse.printlOutputFile(s);
					break;
				}	
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
