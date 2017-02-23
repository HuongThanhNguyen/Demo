package thread;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Horse extends Thread {
	static final int tongS = 100;
	private String nameHorse;
	private LocalTime timeStartOneHorse, timeFinishOneHorse;
	private int stepHorse = 0;
	private Duration timeMarch;
	OutputRace outputDataRaceHore=new OutputRace();

	public Duration gettimeMarch() {
		return timeMarch;
	}

	public Horse(String object) {
		this.nameHorse = object;
	}

	public int getStepHorse() {
		return stepHorse;
	}

	public String getNameHorse() {
		return nameHorse;
	}

	public void run() {
		timeStartOneHorse = LocalTime.now();
		int tong = 0;
		Random rd = new Random();
		while (true) {
			int i = rd.nextInt(10) + 1;
			if (tong < tongS) {
				stepHorse++;
				tong += i;
				if (tong > tongS) {
					stepHorse++;
					tong -= tongS;
				}
				if (tong == tongS) {
					timeFinishOneHorse = LocalTime.now();
					timeMarch = Duration.between(timeStartOneHorse, timeFinishOneHorse);
					String s = nameHorse + " ve dich voi " + stepHorse + " buoc chay" + " voi time: " + timeMarch.toMillis() + " millis";
					System.out.println(s);
					outputDataRaceHore.printlOutputFile(s);
					break;
				}
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
