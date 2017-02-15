/*
 * create object immuable 
 */

package immutable;

public class DisplayHS {

	public static void main(String args[]) {
		HSChild hsC = new HSChild("huong", 24);
		HocSinh hs = (HocSinh) hsC;
		
		System.out.println("name: " + hs.getName() + " \t age: " + hs.getAge());
		hsC.setAgeEditable(14);
		System.out.println("name: " + hs.getName() + " \t age: " + hs.getAge());
	}
}
