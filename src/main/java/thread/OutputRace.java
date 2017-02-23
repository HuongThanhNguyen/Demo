package thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputRace {
	static PrintWriter prw;

	public void printlOutputFile(String s) {
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
