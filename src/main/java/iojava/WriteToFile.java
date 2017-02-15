package iojava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteToFile {
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws FileNotFoundException {

		int n;
		String maNV;
		String tenNV;
		int tuoiNV;
		float luongNV;

		OutputStream outputStream = new FileOutputStream("D:/nhanvien.txt", true);
		PrintWriter pw = new PrintWriter(outputStream);
		System.out.println("moi nhap so nhan vien can nhap vao: ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Scanner sc1 = new Scanner(System.in);
			NhanVien nv = new NhanVien();
			System.out.println("Nhan vien thu " + (i + 1));
			System.out.println("Ma nhan vien: ");
			maNV = sc1.nextLine();
			nv.setMaNV(maNV);
			System.out.println("Ten nhan vien: ");
			tenNV = sc1.nextLine();
			nv.setTen(tenNV);
			System.out.println("Tuoi nhan vien: ");
			tuoiNV = sc1.nextInt();
			nv.setTuoi(tuoiNV);
			System.out.println("Luong nhan vien: ");
			luongNV = sc1.nextFloat();
			nv.setLuong(luongNV);
			pw.println(nv.toString());
		}
		System.out.println("Xuat file thanh cong!");
		pw.flush();
		pw.close();
	}
}
