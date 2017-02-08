/*
 * class Pencil extent Pen Override 2 method cua Pen va setup gia tri price va type
 */

package AbstrackAndStaticAndAnnotation;

public class Pencil extends Pen {

	@Override
	void Price() {
		setPrice(1000);
		System.out.println(getPrice());
	}

	@Override
	void Type() {
		setType("Pencil");
		System.out.println(getType());

	}
}
