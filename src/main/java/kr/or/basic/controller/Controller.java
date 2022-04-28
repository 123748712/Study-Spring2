package kr.or.basic.controller;

// 컨트롤러의 갯수가 많기 때문에 통일성을 위해 interface 생성
public interface Controller {

	// 요청을 핸들하는 메소드
	public String handleRequest();
}
