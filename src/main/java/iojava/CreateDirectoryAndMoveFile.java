package iojava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CreateDirectoryAndMoveFile {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		CreateDirectoryAndMoveFile cdam = new CreateDirectoryAndMoveFile();
		System.out.println("----- tao Directory va move file -----");
		System.out.println("Nhap ten thu muc can lap: ");
		String s1 = sc.nextLine();
		File myDir = new File("D:/" + s1);
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
		Path source = Paths.get(s2);
		System.out.println("nhap path thu muc duoc nhan file: ");
		String s3 = sc.nextLine();
		Path target = Paths.get(s3);
		try {
			Files.move(source, target);
			System.out.println("Move file thanh cong ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
