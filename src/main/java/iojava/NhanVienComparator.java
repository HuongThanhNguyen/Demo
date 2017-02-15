package iojava;

import java.util.Comparator;

public class NhanVienComparator implements Comparator<NhanVien> {

	public int compare(NhanVien o1, NhanVien o2) {
		if (o1 == null && o2 == null) {
			return 0;
		}
		if (o1 == null) {
			return -1;
		}
		if (o2 == null) {
			return 1;
		}
		int value = o1.tuoi - o2.tuoi;
		if (value != 0) {
			return value;
		}
		
		try {
			value = o1.getTen().compareTo(o2.getTen());
		} catch (NullPointerException e) {
			System.out.println("Loi 1: "+e);
		}
		
		return value;
	}
}
