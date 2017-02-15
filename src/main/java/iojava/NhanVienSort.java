package iojava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NhanVienSort {
	public static void main(String args[]) {
		
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();

		listNhanVien.add(new NhanVien(null, null, 2, 0));
		listNhanVien.add(new NhanVien("nv003", "Hanh", 20, 2200000));
		listNhanVien.add(new NhanVien("nv002", "Trang", 29, 4500000));
		listNhanVien.add(new NhanVien(null, null, 2, 0));
		listNhanVien.add(new NhanVien("nv001", null, 19, 1500000));
		listNhanVien.add(new NhanVien(null, "Anh", 19, 1500000));
		listNhanVien.add(new NhanVien("nv005", "Tuan", 21, 3500000));
		listNhanVien.add(new NhanVien(null, null, 0, 0));
		for (int i = 0; i < listNhanVien.size(); i++) {
			System.out.println(listNhanVien.get(i));
		}

		Collections.sort(listNhanVien);
		System.out.println("---------------");
		for(int i=0;i<listNhanVien.size();i++){
			System.out.println(listNhanVien.get(i));
		}
		
		Collections.sort(listNhanVien, new NhanVienComparator());
		
		System.out.println("---------------");
		for(int i=0;i<listNhanVien.size();i++){
			System.out.println(listNhanVien.get(i));
		}
	}
}
