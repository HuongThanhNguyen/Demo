/*Demo ve Constructor, Subclass, inner class, nested class
 * 
 * Class DisplayInformationStudent la 1 subclass ke thua tu class Student. Class nay chua 2 class con khac: 
 * 1 class inner class: DisplayName
 * 1 class nested class: DisplayAgeAddress
 * inner class co quyen truy cap toi cac thanh phan cua outclass ngay ca khi no dc khai bao la private
 * con nested class thi khong
 */

package objectAndClass;

public class DisplayInformationStudent extends Student {
	// tao 1 doi tuong st cua Student
	static Student st = new Student("Nguyen Thi Thanh Huong", 25, "Ha Noi", "25-10-1993");
	private String name = "Huong";

	class DisplayName {
		private String name = "Nguyen";

		void displayName(String name) {			

			System.out.println("name : " + name);
			System.out.println("this.name: " + this.name);
			System.out.println("DisplayInformationStudent.this.name: " + DisplayInformationStudent.this.name);
			System.out.println("---------------------");
		}
	}

	static class DisplayAgeAddressAndBirthday {

		void displayAgeAndBirthday() {
			
			System.out.println("age: " + st.getAgeStudent());
			System.out.println("Ngay sinh: " + st.getBirthdayStudent());
		}
		static void displayAddress(){

			System.out.println("Dia chi: " + st.getAddressStudent());
		}
	}

	public static void main(String args[]) {
		
		/*voi inner class thi can phai co instance cua outerclass sau do dua vao do tao instance cua inner class
		*sau do moi goi duoc method cua inner class nay
		*/
		DisplayInformationStudent ipsv = new DisplayInformationStudent();
		DisplayInformationStudent.DisplayName dht = ipsv.new DisplayName();
		dht.displayName(st.getNameStudent());
		
		//neu ben trong nested class co method khai bao static thi k can tao instance cua no ma van co the goi truc tiep method nay
		DisplayInformationStudent.DisplayAgeAddressAndBirthday.displayAddress();

		//truong hop ben trong nested class co method dc khai bao la non-static thi can tao instance cua no r moi goi duoc method nay
		DisplayInformationStudent.DisplayAgeAddressAndBirthday daa = new DisplayInformationStudent.DisplayAgeAddressAndBirthday();
		daa.displayAgeAndBirthday();
		
		
	}
}
