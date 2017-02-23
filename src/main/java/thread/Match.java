package thread;

import java.time.Duration;
import java.util.List;

public class Match {
	String nameHorseWin;
	int stepHorseWin;
	Duration TimeHorseWin;

	public String getNameHorseWin() {
		return nameHorseWin;
	}

	public void proccessedOneMatchHorse(int match, List<Horse> listHorseOneMatch) {
		OutputRace ouputRace=new OutputRace();
		
		String s1 = " tran dau thu " + match + ":\n"+"-----------------------";
		System.out.println(s1);
		ouputRace.printlOutputFile(s1);
		try {
			for (Horse oneHorse : listHorseOneMatch) {

				oneHorse.start();
			}
			for (Horse oneHorse : listHorseOneMatch) {
				oneHorse.join();
			}
		} catch (InterruptedException e) {
			System.err.println("Error: " + e);
			ouputRace.printlOutputFile("Error: " + e);
		}
		nameHorseWin = listHorseOneMatch.get(0).getNameHorse();
		stepHorseWin = listHorseOneMatch.get(0).getStepHorse();
		TimeHorseWin = listHorseOneMatch.get(0).gettimeMarch();

		for (Horse onHorse : listHorseOneMatch) {
			if (stepHorseWin > onHorse.getStepHorse()) {
				nameHorseWin = onHorse.getNameHorse();
				stepHorseWin = onHorse.getStepHorse();
				TimeHorseWin = onHorse.gettimeMarch();
			}
		}

		String s2 = "----------------------------- \n" + "con ngua: " + nameHorseWin + " chien thang tran dau " + match
				+ " voi so buoc chay la: " + stepHorseWin + " voi thoi gian la: " + TimeHorseWin.toMillis() + " millis\n--------------";
		System.out.println(s2);
		ouputRace.printlOutputFile(s2);
	}
}
