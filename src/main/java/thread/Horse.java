package thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/*
 * lam bai toan dua ngua:
 * co 10 con ngua cung xuat phat cung luc
 * cu sau nua giay, moi con se chay mot buoc la mot so int random tu 1 den 10
 * neu con ngua nao co quang duong bang tong cac buoc chay bang dung 100 thi con ngua do se ve dich va in ra
 * Con ngua thu xxx da ve dich voi yyy buoc chay.
 */
public class Horse {
	private File fileInput;
	private BufferedReader bfr;
	static List<ThreadHorse> list = new ArrayList<ThreadHorse>();
	List<ThreadHorse> listnew = new ArrayList<ThreadHorse>();
	int intTurn = 1;
	int intRound = 1;
	static PrintWriter prw;

	public static void main(String args[]) {

		Horse horse = new Horse();
		horse.inputFromFileToList();
		horse.createOutputFile();		
		
		while (list.size() > 1) {
			horse.threadHorse1();
		}
	}

	private void threadHorse1() {
		LocalTime timeStartRound;
		LocalTime timeFinishRound;
		String horserFinish;
		int stepFinish;
		Duration timeFinish = null;
		printlOutputFile("----------------------");
		String s4 = "Vong " + (intRound) + " - Luot " + (intTurn) + ":";
		System.out.println(s4);
		printlOutputFile(s4);
		// vong cuoi cung co so ngua khong du 10
		if (intTurn * 10 >= list.size()) {
			try {
				for (int i = (intTurn - 1) * 10; i <= list.size() - 1; i++) {
					if (i == 0) {
						timeStartRound = LocalTime.now();
						printlOutputFile("----------------------");
						System.out.println("Start vong " + intRound + ": " + timeStartRound);
						printlOutputFile("Start vong " + intRound + ": " + timeStartRound);
					}
					list.get(i).start();
				}
				for (int i = (intTurn - 1) * 10; i <= list.size() - 1; i++) {
					list.get(i).join();
					if (i == (list.size() - 1)) {
						timeFinishRound = LocalTime.now();
						System.out.println("finish vong " + intRound + ": " + timeFinishRound);
						printlOutputFile("Finish vong " + intRound + ": " + timeFinishRound);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// tim va output ra con ngua chien thang cua 1 luot
			stepFinish = list.get((intTurn - 1) * 10).getStepHorse();
			horserFinish = list.get((intTurn - 1) * 10).getNameHorse();
			timeFinish = list.get((intTurn - 1) * 10).getTimeRace();
			for (int i = (intTurn - 1) * 10; i <= list.size() - 1; i++) {
				if (stepFinish > list.get(i).getStepHorse()) {
					horserFinish = list.get(i).getNameHorse();
					stepFinish = list.get(i).getStepHorse();
					timeFinish = list.get(i).getTimeRace();
				}
			}
			printlOutputFile("----------------------");
			String s = horserFinish + " Chien thang voi " + stepFinish + " buoc chay" + " voi time:" + timeFinish;
			printlOutputFile(s);
			System.out.println(s);

			// add con ngua chien thang vao list moi
			listnew.add(new ThreadHorse(horserFinish));

			// do la vong cuoi cung, chuyen ds ngua tu list moi sang list de
			// thuc thi tiep chuong trinh
			list = new ArrayList<ThreadHorse>(listnew);

			// xoa list moi de thuc hien cho vong dua tiep theo
			listnew.clear();

			// tang so vong dua
			intRound += 1;
			intTurn = 1;

		} else { // xu ly voi cac vong co so ngua thi dau =10
			try {
				for (int i = (intTurn - 1) * 10; i < intTurn * 10; i++) {
					if (i == 0) {
						timeStartRound = LocalTime.now();
						printlOutputFile("----------------------");
						System.out.println("Start vong " + intRound + ": " + timeStartRound);
						printlOutputFile("Start vong " + intRound + ": " + timeStartRound);
					}
					list.get(i).start();
				}
				for (int i = (intTurn - 1) * 10; i < intTurn * 10; i++) {
					list.get(i).join();
					if (i == (list.size() - 1)) {
						timeFinishRound = LocalTime.now();
						System.out.println("finish vong " + intRound + ": " + timeFinishRound);
						printlOutputFile("Finish vong " + intRound + ": " + timeFinishRound);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// tim va output ra con ngua chien thang cua 1 luot
			stepFinish = list.get((intTurn - 1) * 10).getStepHorse();
			horserFinish = list.get((intTurn - 1) * 10).getNameHorse();
			timeFinish = list.get((intTurn - 1) * 10).getTimeRace();
			for (int i = (intTurn - 1) * 10; i < intTurn * 10; i++) {
				if (stepFinish > list.get(i).getStepHorse()) {
					horserFinish = list.get(i).getNameHorse();
					stepFinish = list.get(i).getStepHorse();
					timeFinish = list.get(i).getTimeRace();
				}
			}
			printlOutputFile("----------------------");
			String s1 = horserFinish + " Chien thang voi " + stepFinish + " buoc chay" + " voi time: " + timeFinish;
			printlOutputFile(s1);
			System.out.println(s1);

			// add con ngua chien thang vao list moi
			listnew.add(new ThreadHorse(horserFinish));
			intTurn += 1;
		}

	}

	// method input ds ngua vao list de xu ly
	private void inputFromFileToList() {
		try {
			fileInput = new File("input.txt");
			FileReader fr;
			fr = new FileReader(fileInput);
			bfr = new BufferedReader(fr);
			String data;
			while ((data = bfr.readLine()) != null) {
				list.add(new ThreadHorse(data));
			}
			bfr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
	private void createOutputFile() {
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
