package kr.or.basic.domain;

@SuppressWarnings("unused")
public class JungSun {
	private String name;
	private int age;
	
	private Jamba jamba;
	
	public JungSun() { // default 생성자
		System.out.println("스프링 자동 생성자"); // 스프링이 자동 생성해주는 생성자
	}
	
	public JungSun(Jamba jamba) {
		System.out.println("beans:constructor-arg 를 통한 자동 호출");
		this.jamba = jamba;
	}
	
	public String getName() {
		return name;
	}

	public Jamba getJamba() {
		return jamba;
	}

	public void setJamba(Jamba jamba) {
		System.out.println("beans:property 를 통한 자동 호출");
		this.jamba = jamba;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
