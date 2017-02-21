package iojava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteToFile {
	static Scanner sc = new Scanner(System.in);
	private static List<NhanVien> list = new ArrayList<>();
	private Scanner sc1;

	public static void main(String[] name) throws FileNotFoundException {

		System.out.println("----- Tao va ghi file -----");
		System.out.println("Nhap ten file muon tao: ");
		String s = sc.nextLine();
		OutputStream outputStream = new FileOutputStream(s, false);
		PrintWriter pw = new PrintWriter(outputStream);
		WriteToFile w1 = new WriteToFile();
		w1.inputNhanVien();
		for (NhanVien nhanVien : list) {
			pw.println(nhanVien.toString());
		}
		System.out.println("Xuat file thanh cong!");
		pw.flush();
		pw.close();
	}

	private void inputNhanVien() {
		String maNV;
		String tenNV;
		int tuoiNV;
		float luongNV;
		System.out.println("moi nhap so nhan vien can nhap vao: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			sc1 = new Scanner(System.in);
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
			list.add(nv);
		}
	}
}
