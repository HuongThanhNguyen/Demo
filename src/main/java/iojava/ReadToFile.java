package iojava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadToFile {
	private static BufferedReader bf;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			System.out.println("----- Doc file (mac dinh luu o D:/)-----");
			System.out.println("Nhap ten file can doc");
			String s = sc.nextLine();
			File inputStream = new File("Desktop"+s);
			FileReader fr = new FileReader(inputStream);
			bf = new BufferedReader(fr);
			String data;
			while ((data = bf.readLine()) != null) {
				System.out.println(data);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.err.println("khong tim thay file: " + e);
		} catch (IOException e) {
			System.err.println("Loi IO File: " + e);
		}
	}
}
