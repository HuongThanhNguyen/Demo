package iojava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * nhap vao danh sach nhan vien
 * sap xep nhan vien theo ten, tuoi.
 */
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
		
		//hien thi danh sach nhan vien dc them vao
		for (int i = 0; i < listNhanVien.size(); i++) {
			System.out.println(listNhanVien.get(i));
		}

		//sap xep danh sach nhan vien theo ten. hien thi danh sach nhan vien ra man hinh
		Collections.sort(listNhanVien);
		System.out.println("---------------");
		for(int i=0;i<listNhanVien.size();i++){
			System.out.println(listNhanVien.get(i));
		}
		
		//sap xep danh sach nhan vien theo tuoi, neu 2 nhan vien bang tuoi thi sap xep tiep theo ten nhan vien. 
		// hien thi danh sach nhan vien ra man hinh
		Collections.sort(listNhanVien, new NhanVienComparator());		
		System.out.println("---------------");
		for(int i=0;i<listNhanVien.size();i++){
			System.out.println(listNhanVien.get(i));
		}
	}
}
