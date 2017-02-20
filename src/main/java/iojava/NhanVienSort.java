package iojava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * nhap vao danh sach nhan vien
 * sap xep nhan vien theo ten, tuoi.
 */
public class NhanVienSort {
	static List<NhanVien> listNhanVien = new ArrayList<NhanVien>();

	public static void main(String[] args) {

		NhanVienSort nvs = new NhanVienSort();
		nvs.inputNhanVien();
		System.out.println("Danh sach nhan vien khi chua sap xep: ");
		nvs.displayDSNhanVien();
		nvs.nhanVienSortByComparable();
		nvs.nhanVienSortByComparator();
	}

	private void inputNhanVien() {

		listNhanVien.add(new NhanVien(null, null, 0, 0));
		listNhanVien.add(new NhanVien("nv002", "Hanh", 20, 2200000));
		listNhanVien.add(new NhanVien("nv003", "Trang", 29, 4500000));
		listNhanVien.add(new NhanVien("nv004", "Anh", 19, 1500000));
		listNhanVien.add(new NhanVien("nv005", "Tuan", 21, 3500000));
	}

	private void displayDSNhanVien() {
		for (int i = 0; i < listNhanVien.size(); i++) {
			System.out.println(listNhanVien.get(i));
		}
	}

	private void nhanVienSortByComparable() {
		System.out.println();
		System.out.println("Sap xep danh sach nhan vien theo ten su dung comparable: ");
		Collections.sort(listNhanVien);
		displayDSNhanVien();
	}

	private void nhanVienSortByComparator() {
		System.out.println();
		System.out.println(
				"Sap xep danh sach nhan vien theo tuoi, neu tuoi bang nhau thi sap xep theo ten. Su dung comparator: ");
		Collections.sort(listNhanVien, new NhanVienComparator());
		displayDSNhanVien();
	}
}
