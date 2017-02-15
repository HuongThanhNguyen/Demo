package iojava;

public class NhanVien implements Comparable<NhanVien> {
	private String maNV;
	private String ten;
	private int tuoi;
	private float luong;
	static int value;

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTen() {
		return ten;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public float getLuong() {
		return luong;
	}

	public NhanVien() {
	}

	public NhanVien(String maNv, String tenNv, int tuoiNv, float luongNv) {
		this.maNV = maNv;
		this.ten = tenNv;
		this.tuoi = tuoiNv;
		this.luong = luongNv;
	}

	public String toString() {
		return getMaNV() + "\t " + getTen() + "\t " + getTuoi() + "\t " + getLuong();
	}

	public int compareTo(NhanVien arg0) {
		if(arg0.getTen()==null&&this.ten==null){
			return 0;
		}
		if(arg0.getTen()==null){
			return 1;
		}
		if(this.ten==null){
			return -1;
		}
		try {
			value = this.ten.compareTo(arg0.getTen());
		} catch (NullPointerException e) {
			System.out.println("Loi: " + e);
		}
		return value;
	}
}
