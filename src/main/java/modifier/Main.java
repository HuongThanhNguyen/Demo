/*
 * cho 1 class pen co 2 thuoc tinh la price va type
 * co 2 abstrack Price va Type
 * 1 class Pencil extent Pen Override 2 method cua Pen va setup gia tri price va type
 * Class Main chua ham main chuong trinh chinh goi ham va hien thi.
 */

package modifier;

public class Main {
	public static void main(String args[]) {
		Main main = new Main();
		Pencil pc1 = new Pencil(3000, "Pencil 2B");
		Pencil pc2 = new Pencil(5000, "Pencil 4B");

		pc1.displayType(pc1.getType());
		pc1.displayPrice(pc1.getPrice());
		pc2.displayType(pc2.getType());
		pc2.displayPrice(pc2.getPrice());
		main.display(pc1.getType(), pc2.getType());
		main.display(pc1.getPrice(), pc2.getPrice());

	}

	//cung ten method nhung khac parameter
	void display(int price1, int price2) {
		System.out.print(" tong tien là: " + (price1 + price2));
	}

	void display(String type1, String type2) {
		System.out.print(type1 + " và " + type2 + " co ");
	}
}
