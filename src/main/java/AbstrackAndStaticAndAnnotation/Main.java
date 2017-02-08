/*
 * cho 1 class pen co 2 thuoc tinh la price va type
 * co 2 abstrack Price va Type
 * 1 class Pencil extent Pen Override 2 method cua Pen va setup gia tri price va type
 * Class Main chua ham main chuong trinh chinh goi ham va hien thi.
 */

package AbstrackAndStaticAndAnnotation;

public class Main {
	public static void main(String args[]) {
		Pencil pc = new Pencil();
		pc.Type();
		pc.Price();

	}
}
