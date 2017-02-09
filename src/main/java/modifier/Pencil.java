/*
 * class Pencil extent Pen Override 2 method cua Pen va setup gia tri price va type
 */

package modifier;

public class Pencil extends Pen {

	@Override
	void displayPrice() {
		setPrice(2000);
		System.out.println("Price: " + getPrice());
	}

	@Override
	void displayType() {
		setType("Pencil");
		System.out.println("name: " + getType());
	}

}
