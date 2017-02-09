/*
 * class Pencil extent Pen Override 2 method cua Pen va setup gia tri price va type
 */

package modifier;

public class Pencil extends Pen {

	public Pencil(int price, String type) {
		super(price, type);
		this.price = price;
		this.type = type;
	}

	@Override
	void displayPrice(int price) {
		setPrice(price);
		System.out.println("int Price: " + getPrice());
	}

	@Override
	void displayType(String type) {
		setType(type);
		System.out.println("name: " + getType());
	}

}
