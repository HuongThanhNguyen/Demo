package thread;

import java.time.Duration;
import java.util.List;

public class Match {
	private String nameHorseWin;
	private int stepHorseWin;
	private Duration TimeHorseWin;

	public String getNameHorseWin() {
		return nameHorseWin;
	}

	public void MatchHorse(int match, List<Horse> listHorseOneMatch) {

		String s1 = " tran dau thu " + match + ":\n" + "-----------------------";
		System.out.println(s1);
		InputAndOutputFile.printlFileOutput(s1);

		try {
			for (Horse oneHorse : listHorseOneMatch) {

				oneHorse.start();
			}
			for (Horse oneHorse : listHorseOneMatch) {
				oneHorse.join();
			}
		} catch (InterruptedException e) {
			System.err.println("Error: " + e);
			InputAndOutputFile.printlFileOutput("Error: " + e);
		}
		findHorseWin(match, listHorseOneMatch);
		printHorseWin(match);
	}

	private void findHorseWin(int match, List<Horse> listHorseOneMatch) {
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
	}

	private void printHorseWin(int match) {
		String s2 = "----------------------------- \n" + "con ngua: " + nameHorseWin + " chien thang tran dau " + match
				+ " voi so buoc chay la: " + stepHorseWin + " voi thoi gian la: " + TimeHorseWin.toMillis()
				+ " millis\n--------------";
		System.out.println(s2);
		InputAndOutputFile.printlFileOutput(s2);
	}

}
