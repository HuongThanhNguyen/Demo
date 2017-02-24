package thread;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Horse extends Thread {
	private static final int LengtSuccess = 100;
	private String nameHorse;
	private LocalTime timeStartOneHorse, timeFinishOneHorse;
	private int stepHorse = 0;
	private Duration timeMarch;
	private static final int TimeSleepThread=500;

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
		int leghtStep = 0;
		Random rd = new Random();
		while (true) {
			int i = rd.nextInt(10) + 1;
			if (leghtStep < LengtSuccess) {
				stepHorse++;
				leghtStep += i;
				if (leghtStep > LengtSuccess) {
					stepHorse++;
					leghtStep -= LengtSuccess;
				}
				if (leghtStep == LengtSuccess) {
					timeFinishOneHorse = LocalTime.now();
					timeMarch = Duration.between(timeStartOneHorse, timeFinishOneHorse);
					printHorseFinish();
					break;
				}
			}
			try {
				Thread.sleep(TimeSleepThread);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	void printHorseFinish(){
		String s = nameHorse + " ve dich voi " + stepHorse + " buoc chay" + " voi time: " + timeMarch.toMillis() + " millis";
		System.out.println(s);
		InputAndOutputFile.printlFileOutput(s);
	}
}
