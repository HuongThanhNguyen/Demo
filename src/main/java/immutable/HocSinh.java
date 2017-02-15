package immutable;

public class HocSinh {
private final String name;
private final int age;
public HocSinh(String nameHS, int ageHS){
	this.name=nameHS;
	this.age=ageHS;
}
public String getName() {
	return name;
}
public final int getAge() {
	return age;
}
}
