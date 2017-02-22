package thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RaceHorse {

	List<ThreadHorse> listnew = new ArrayList<ThreadHorse>();
	int race = 1;
	int round = 1;
	static PrintWriter prw;
	int maxRace = 0;
	int horseOfOneRound;

	public void threadHorse1(List<ThreadHorse> list) {
		for (int i = 10; i > 0; --i) {
			if (list.size() <= 10) {
				maxRace = 1;
				horseOfOneRound = list.size();
				break;
			}
			if ((list.size() % i) + i <= 10) {
				maxRace = list.size() / i;
				horseOfOneRound = i;
				System.out.println(horseOfOneRound);
				break;
			}
		}

		LocalTime timeStartRound;
		LocalTime timeFinishRound;
		String horserFinish;
		int stepFinish;
		Duration timeFinish = null;
		printlOutputFile("----------------------");
		String s4 = "Vong " + (round) + " - Luot " + (race) + ":";
		System.out.println(s4);
		printlOutputFile(s4);
		// vong cuoi cung co so ngua co gia tri tren hoac duoi so ngua tren 1 vong
		if (race == (maxRace)) {
			try {
				for (int i = (race - 1) * horseOfOneRound; i <= list.size() - 1; i++) {
					//in ra thoi gian bat dau vong dua
					if (i == 0) {
						timeStartRound = LocalTime.now();
						printlOutputFile("----------------------");
						System.out.println("Start vong " + round + ": " + timeStartRound);
						printlOutputFile("Start vong " + round + ": " + timeStartRound);
					}
					list.get(i).start();
				}
				for (int i = (race - 1) * horseOfOneRound; i <= list.size() - 1; i++) {
					list.get(i).join();
					//in ra thoi gian ket thuc 1 vong dua
					if (i == (list.size() - 1)) {
						timeFinishRound = LocalTime.now();
						System.out.println("finish vong " + round + ": " + timeFinishRound);
						printlOutputFile("Finish vong " + round + ": " + timeFinishRound);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// tim va in ra con ngua chien thang o 1 luot dua
			stepFinish = list.get((race - 1) * horseOfOneRound).getStepHorse();
			horserFinish = list.get((race - 1) * horseOfOneRound).getNameHorse();
			timeFinish = list.get((race - 1) * horseOfOneRound).getTimeRace();
			for (int i = (race - 1) * horseOfOneRound; i <= list.size() - 1; i++) {
				if (stepFinish > list.get(i).getStepHorse()) {
					horserFinish = list.get(i).getNameHorse();
					stepFinish = list.get(i).getStepHorse();
					timeFinish = list.get(i).getTimeRace();
				}
			}
			printlOutputFile("----------------------");
			String s = horserFinish + " Chien thang voi " + stepFinish + " buoc chay" + " voi time:"
					+ timeFinish.toMillis() + " millis";
			printlOutputFile(s);
			System.out.println(s);

			// add con ngua chien thang vao list moi
			listnew.add(new ThreadHorse(horserFinish));

			// do la vong cuoi cung, chuyen ds ngua tu list moi sang list de
			// thuc thi tiep chuong trinh
			Horse.list = new ArrayList<ThreadHorse>(listnew);

			// xoa list moi de thuc hien cho vong dua tiep theo
			listnew.clear();
			maxRace = 1;
			horseOfOneRound = list.size();

			// tang so vong dua
			round += 1;
			
			//set lai gia tri 
			race = 1;

		} else if (race < maxRace) { // xu ly voi cac vong co so ngua thi dau
										// =10
			try {
				for (int i = (race - 1) * horseOfOneRound; i < race * horseOfOneRound; i++) {
					if (i == 0) {
						timeStartRound = LocalTime.now();
						printlOutputFile("----------------------");
						System.out.println("Start vong " + round + ": " + timeStartRound);
						printlOutputFile("Start vong " + round + ": " + timeStartRound);
					}
					list.get(i).start();
				}
				for (int i = (race - 1) * horseOfOneRound; i < race * horseOfOneRound; i++) {
					list.get(i).join();
					if (i == (list.size() - 1)) {
						timeFinishRound = LocalTime.now();
						System.out.println("finish vong " + round + ": " + timeFinishRound);
						printlOutputFile("Finish vong " + round + ": " + timeFinishRound);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// tim va output ra con ngua chien thang cua 1 luot
			stepFinish = list.get((race - 1) * horseOfOneRound).getStepHorse();
			horserFinish = list.get((race - 1) * horseOfOneRound).getNameHorse();
			timeFinish = list.get((race - 1) * horseOfOneRound).getTimeRace();
			for (int i = (race - 1) * horseOfOneRound; i < race * horseOfOneRound; i++) {
				if (stepFinish > list.get(i).getStepHorse()) {
					horserFinish = list.get(i).getNameHorse();
					stepFinish = list.get(i).getStepHorse();
					timeFinish = list.get(i).getTimeRace();
				}
			}
			printlOutputFile("----------------------");
			String s1 = horserFinish + " Chien thang voi " + stepFinish + " buoc chay" + " voi thoi gian la : "
					+ timeFinish.toMillis() + " millis";
			printlOutputFile(s1);
			System.out.println(s1);

			// add con ngua chien thang vao list moi
			listnew.add(new ThreadHorse(horserFinish));
			race += 1;
		}
	}

	// method println 1 String vao output.txt
	public static void printlOutputFile(String s) {
		try {
			OutputStream output = new FileOutputStream("output.txt", true);
			prw = new PrintWriter(output);
			prw.println(s);
			prw.flush();
			prw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// method create output.txt
	public void createOutputFile() {
		try {
			File output = new File("output.txt");
			output.createNewFile();
			FileWriter fw = new FileWriter(output);
			prw = new PrintWriter(fw);
			prw.flush();
			prw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
