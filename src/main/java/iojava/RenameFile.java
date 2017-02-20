package iojava;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RenameFile {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("----- Thay doi ten file (mac dinh luu o D:/)-----");
		System.out.println("Nhap ten file can doi: ");
		String s1 = sc.nextLine();
		System.out.println("Nhap ten file can doi: ");
		String s2 = sc.nextLine();
		File file = new File("D:/"+s1);
		File file2 = new File("D:/"+s2);
		if (file.exists() == false) {
			System.err.println(file.getName() + " khong ton tai");
		}
		if (file.renameTo(file2)) {
			System.out.println("thay doi ten thanh cong");
		}
	}
}
