package AbstrackAndStaticAndAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflactionClassPen {
	public static void main(String args[]) {
		Class<Pen> c = Pen.class;
		try {
			// get name package and class
			String cClassPackage = c.getName();
			System.out.println("Class name is: " + cClassPackage);

			// get name class
			String cClassNoPackage = c.getSimpleName();
			System.out.println("Class name without package is: " + cClassNoPackage);

			// get name package
			Package cPackage = c.getPackage();
			System.out.println("Package name is: " + cPackage);

			// get name constructor
			Constructor[] constructors = c.getConstructors();
			System.out.println("Constructors are: " + Arrays.toString(constructors));

			// get name public field
			Field[] fields = c.getFields();

			System.out.println("Public Fields are: ");
			if (fields.length == 0) {
				System.out.println("No ");
			}
			for (Field oneField : fields) {
				Field field = c.getField(oneField.getName());
				String fieldname = field.getName();
				System.out.println("Fieldname is: " + fieldname);
			}

			// get name DeclaredField field
			Field[] fields1 = c.getDeclaredFields();

			System.out.println("DeclaredField Fields are: ");
			for (Field oneField : fields1) {
				Field field = c.getField(oneField.getName());
				String fieldname = field.getName();
				System.out.println("Fieldname is: " + fieldname);
			}

			// get name public method
			Method[] declaredMethods = c.getDeclaredMethods();
			System.out.println("Declared Methods are: " + Arrays.toString(declaredMethods));
			for (Method dmethod : declaredMethods) {
				System.out.println("method = " + dmethod.getName());
			}

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
