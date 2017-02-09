/*
 * Class Student chua cac bien ten sinh vien, tuoi sinh vien, dia chi sinh vien, ngay sinh cua sinh vien.
 * co 2 constructor: constructor mac dinh va constructor chua tham so
 */

package objectAndClass;

public class Student {
	private String nameStudent;
	private int ageStudent;
	private String addressStudent;
	private String birthdayStudent;

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setAgeStudent(int ageStudent) {
		this.ageStudent = ageStudent;
	}

	public int getAgeStudent() {
		return ageStudent;
	}

	public void setAddressStudent(String addressStudent) {
		this.addressStudent = addressStudent;
	}

	public String getAddressStudent() {
		return addressStudent;
	}

	public void setBirthdayStudent(String birthdayStudent) {
		this.birthdayStudent = birthdayStudent;
	}

	public String getBirthdayStudent() {
		return birthdayStudent;
	}

	// Constructor mac dinh

	public Student() {
	}

	//Constructor co tham so
	public Student(String name, int age, String address, String born) {
		this.nameStudent = name;
		this.ageStudent = age;
		this.addressStudent = address;
		this.birthdayStudent = born;
	}

}
