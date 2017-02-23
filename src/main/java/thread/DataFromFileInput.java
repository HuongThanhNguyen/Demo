package thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DataFromFileInput {

	public List<Horse> inputToList() {
		
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
			for(String oneNameHorse: listStringNameHorse){
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
}
