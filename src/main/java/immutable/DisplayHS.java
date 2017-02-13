/*
 * create object immuable 
 */

package immutable;

public class DisplayHS {

	public static void main(String args[]) {
		HocSinh hs = new HocSinh("huong", 24);
		System.out.println("name: " + hs.getName() + " \t age: " + hs.getAge());
	}
}
