package kr.or.basic.domain;

public class Jamba {
	public String color;

	public Jamba() {
		this.color = "black";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		System.out.println("넘어온 값 : " + color);
		this.color = color;
	}

}
