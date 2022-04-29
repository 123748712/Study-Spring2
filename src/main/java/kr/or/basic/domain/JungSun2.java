package kr.or.basic.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component("jungsun2") // String MVC에서 제공해주는 어노테이션 Bean 생성
public class JungSun2 implements Mamamoo {
	private String name;
	private int age;
	
	@Autowired
	private Jamba jamba;
	
	public JungSun2() { // default 생성자
		System.out.println("스프링 자동 생성자"); // 스프링이 자동 생성해주는 생성자
	}
	
//	@PostConstruct // init-method에 해당하는 어노테이션
	public void initStart() {
		System.out.println("init-method");
	}
	
//	@PreDestroy // destroy-method에 해당하는 어노테이션
	public void destroyMethod() {
		System.out.println("destroy-method");
	}
	
	public JungSun2(Jamba jamba) {
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
