package immutable;

public class HSChild extends HocSinh{
	private int ageEditable;
	public HSChild(String nameHS, int ageHS) {
		super(nameHS, ageHS);
		this.ageEditable = ageHS;
		// TODO Auto-generated constructor stub
	}
	public int getAgeEditable() {
		return ageEditable;
	}
	public void setAgeEditable(int ageEditable) {
		this.ageEditable = ageEditable;
	}

}
