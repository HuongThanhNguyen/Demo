/*
 * cho 1 class pen co 2 thuoc tinh la price va type
 * co 2 abstrack Price va Type
 */

package modifier;

public abstract class Pen {
	public String type;
	public int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Pen(int price, String type) {
		this.price = price;
		this.type = type;
	}

	abstract void displayPrice(int price);

	abstract void displayType(String type);

}
