package iojava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CreateDirectoryAndMoveFile {
	static Scanner sc = new Scanner(System.in);
	static File myDir;
	public static void main(String[] args) {
		CreateDirectoryAndMoveFile cdam = new CreateDirectoryAndMoveFile();
		System.out.println("----- tao Directory va move file -----");
		System.out.println("Nhap ten thu muc(se chua file di chuyen, chua co se tao moi): ");
		String s1 = sc.nextLine();
		myDir = new File(s1);
		if (myDir.exists() == true) {
			cdam.inputInformationDirectory();
		} else {
			myDir.mkdir();
			cdam.inputInformationDirectory();
		}
	}

	private void inputInformationDirectory() {
		System.out.println("nhap path file can di chuyen: ");
		String s2 = sc.nextLine();
		File file=new File(s2);
		System.out.println(file.getAbsolutePath());
		System.out.println(myDir.getAbsolutePath());
		try {
			Files.move(Paths.get(file.getAbsolutePath()), Paths.get(myDir.getAbsolutePath()+"/"+s2));
			System.out.println("Move file thanh cong ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
