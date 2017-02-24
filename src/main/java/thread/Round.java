package thread;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Round {
	private int horseInMatch = 0;
	private LocalTime timeStartOneRound, timeFinishOneRound;
	private int countRound = 1;
	private int countMatch = 1;
	private List<Horse> listHorse = new ArrayList<>();
	private List<Horse> listHorseWinOneRound = new ArrayList<>();
	private Match matchHorse = new Match();
	private int maxMatch;
	private List<Horse> listHorseOneMatch;

	public void oneRound() {
		listHorse = InputAndOutputFile.inputToList();
		while (listHorse.size() > 1) {

			String s = "----------------------\n" + "vong dau thu: " + countRound + "\n-------------------------";
			System.out.println(s);
			InputAndOutputFile.printlFileOutput(s);
			cacularNumberHorseInMatch(listHorse.size());
			listHorseOneMatch = listHorse.subList(0, horseInMatch);
			printTimeStartRound(countMatch);
			matchHorse.MatchHorse(countMatch, listHorseOneMatch);
			listHorseWinOneRound.add(new Horse(matchHorse.getNameHorseWin()));
			if (countRound == maxMatch||countMatch==maxMatch) {
				printTimeFinishRound();
				setListHorse();
				countMatch = 1;
				countRound += 1;
				continue;
			}

			listHorseOneMatch.clear();
			countMatch += 1;

		}
	}

	private void cacularNumberHorseInMatch(int numberHorse) {

		for (int i = 10; i > 0; --i) {
			if (numberHorse <= 10) {
				horseInMatch = numberHorse;
				maxMatch = 1;
				break;
			}
			if ((numberHorse % i) + i <= 10) {
				horseInMatch = (numberHorse % i) + i;
				maxMatch = numberHorse / i;
				break;
			}
		}
	}

	private void printTimeStartRound(int countMatch) {
		if (countMatch == 1) {
			timeStartOneRound = LocalTime.now();
			String s1 = "thoi gian bat dau vong " + countRound + ": " + timeStartOneRound + "\n----------------------";
			System.out.println(s1);
			InputAndOutputFile.printlFileOutput(s1);
		}
	}

	private void printTimeFinishRound() {
		timeFinishOneRound = LocalTime.now();
		String s2 = "thoi gian ket thuc vong " + countRound + ": " + timeFinishOneRound;
		System.out.println(s2);
		InputAndOutputFile.printlFileOutput(s2);
	}

	private void setListHorse() {
		listHorse = new ArrayList<Horse>(listHorseWinOneRound);
		listHorseWinOneRound.clear();
	}
}
