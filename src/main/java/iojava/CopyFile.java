package iojava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyFile {
	static BufferedReader bf;
	static PrintWriter pw;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("----- copy file (mac dinh luu o D:/)-----");
		System.out.println("Nhap ten file nguon: ");
		String s1 = sc.nextLine();
		System.out.println("Nhap ten file dich");
		String s2 = sc.nextLine();
		File file1 = new File("D:/"+s1);
		File file2 = new File("D:/"+s2);

		try {
			FileReader fr = new FileReader(file1);
			pw = new PrintWriter(file2);
			bf = new BufferedReader(fr);
			String data;
			while ((data = bf.readLine()) != null) {
				pw.println(data);
			}
			System.out.println("copy file thanh cong");
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("File khong ton tai: " + e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
