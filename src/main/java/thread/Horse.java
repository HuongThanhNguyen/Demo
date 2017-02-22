package thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	static List<ThreadHorse> list = new ArrayList<ThreadHorse>();

	public static void main(String args[]) {
		RaceHorse raceHorse = new RaceHorse();
		List<String> listString = new ArrayList<>();
		// input ma ngua tu file input.txt vao listString
		try {
			File fileInput = new File("input.txt");
			FileReader fr = new FileReader(fileInput);
			BufferedReader bfr = new BufferedReader(fr);
			String data;
			while ((data = bfr.readLine()) != null) {
				listString.add(data);
			}
			bfr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// xoa bo nhung ma so ngua giong nhau
		for (int i = 0; i < listString.size(); i++) {
			for (int j = i + 1; j < listString.size(); j++) {
				if (listString.get(i).equalsIgnoreCase(listString.get(j)) == true) {
					listString.remove(j);
				}
			}
		}
		// dua ds ma ngua tu listString vao trong list<ThreadHorse>
		for (int i = 0; i < listString.size(); i++) {
			list.add(new ThreadHorse(listString.get(i)));
		}
		// xu ly bai toan
		while (list.size() > 1) {
			raceHorse.threadHorse1(list);
		}
	}

}
