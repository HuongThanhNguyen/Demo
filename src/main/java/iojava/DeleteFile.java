package iojava;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("----- Xoa File -----");
		System.out.println("Nhap ten file can xoa: ");
		String s = sc.nextLine();
		File file = new File(s);
		if (file.exists() == false) {
			System.err.println(file.getName() + " khong ton tai");
		} else {

			if (file.delete()) {
				System.out.println(file.getName() + " xoa thanh cong");
			} else {
				System.err.println(file.getName() + " xoa khong thanh cong");
			}
		}
	}
}
