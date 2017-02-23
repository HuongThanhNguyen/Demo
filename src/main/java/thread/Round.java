package thread;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Round {
	public void proccessedOneRound() {

		DataFromFileInput dataFromFileInput = new DataFromFileInput();
		Match matchHorse = new Match();
		OutputRace ouputRace=new OutputRace();

		List<Horse> listHorse = dataFromFileInput.inputToList();
		List<Horse> listHorseWinOneRound = new ArrayList<>();

		int countRound = 1;
		int horseInMatch = 0;
		int maxMatch = 0;

		while (listHorse.size() > 1) {

			for (int i = 10; i > 0; --i) {
				if (listHorse.size() <= 10) {
					horseInMatch = listHorse.size();
					maxMatch = 1;
					break;
				}
				if ((listHorse.size() % i) + i <= 10) {
					horseInMatch = i;
					maxMatch = listHorse.size() / i;
					break;
				}
			}
			String s="----------------------\n"+"vong dau thu: " + countRound+"\n-------------------------";
			System.out.println(s);
			ouputRace.printlOutputFile(s);
			List<Horse> listHorseOneMatch;

			for (int i = 1; i <= maxMatch; i++) {
				LocalTime timeStartOneRound, timeFinishOneRound;

				if (i < maxMatch) {

					listHorseOneMatch = listHorse.subList(0, horseInMatch);
					if (i == 1) {
						timeStartOneRound = LocalTime.now();
						String s1="thoi gian bat dau vong "+countRound+": "+ timeStartOneRound+"\n-----------------------";
						System.out.println(s1);
						ouputRace.printlOutputFile(s1);
					}
					matchHorse.proccessedOneMatchHorse((i), listHorseOneMatch);

					listHorseWinOneRound.add(new Horse(matchHorse.getNameHorseWin()));

					listHorseOneMatch.clear();

				} else if (i == maxMatch) {

					listHorseOneMatch = listHorse.subList(0, listHorse.size());
					if (i == 1) {
						timeStartOneRound = LocalTime.now();
						String s1="thoi gian bat dau vong "+countRound+": "+ timeStartOneRound+"\n----------------------";
						System.out.println(s1);
						ouputRace.printlOutputFile(s1);
					}
					matchHorse.proccessedOneMatchHorse((i), listHorseOneMatch);

					timeFinishOneRound = LocalTime.now();
					String s2="thoi gian ket thuc vong "+countRound+": "+ timeFinishOneRound;
					System.out.println(s2);
					ouputRace.printlOutputFile(s2);

					listHorseWinOneRound.add(new Horse(matchHorse.getNameHorseWin()));

					listHorseOneMatch.clear();

				}
			}

			listHorse = new ArrayList<Horse>(listHorseWinOneRound);
			listHorseWinOneRound.clear();

			countRound += 1;
		}
	}
}
