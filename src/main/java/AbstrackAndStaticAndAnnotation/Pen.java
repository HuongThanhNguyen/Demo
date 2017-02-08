/*
 * cho 1 class pen co 2 thuoc tinh la price va type
 * co 2 abstrack Price va Type
 */

package AbstrackAndStaticAndAnnotation;

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

	abstract void Price();

	abstract void Type();
}
