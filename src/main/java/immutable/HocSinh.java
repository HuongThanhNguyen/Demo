package immutable;

public final class HocSinh {
private String name;
private int age;
public HocSinh(String nameHS, int ageHS){
	this.name=nameHS;
	this.age=ageHS;
}
public final String getName() {
	return name;
}
public final int getAge() {
	return age;
}
}
