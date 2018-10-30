package model;

public class value {
private String name;
private int value;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public value(String name, int value) {

	this.name = name;
	this.value = value;
}
public value() {

}
@Override
public String toString() {
	return name;
}
}
