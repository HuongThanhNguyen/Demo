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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class InputAndOutputFile {
	private static PrintWriter prw;
	public static List<Horse> inputToList() {

		Set<String> listStringNameHorse = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

		List<Horse> listHorse = new ArrayList<>();

		try {
			File fileInput = new File("input.txt");
			FileReader fr = new FileReader(fileInput);
			BufferedReader bfr = new BufferedReader(fr);

			String dataNameHorse;
			while ((dataNameHorse = bfr.readLine()) != null) {
				listStringNameHorse.add(dataNameHorse);
			}
			for (String oneNameHorse : listStringNameHorse) {
				listHorse.add(new Horse(oneNameHorse));
			}
			bfr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listHorse;
	}	

	public static void createFileOutput() {
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


	public static void printlFileOutput(String s) {
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
}
