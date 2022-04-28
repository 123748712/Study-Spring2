package kr.or.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 컨트롤러(URL 핸들러) 등록 (Model 객체를 만들어 view를 반환하기 위한 어노테이션)
@RequestMapping("/blackpink") // 특정 URL로 요청을 보내면 들어온 요청을 특정 메소드, 클래스와 매핑하기 위한 어노테이션
// class 에 RequestMapping 하면 URL에 /blackpink 를 포함해야 연결된다.
public class MyFirstController {

//	@RequestMapping(value = "/roze")
//	public String myRoze(String name, String age) {
//		System.out.println("myRoze 함수 실행");
//		System.out.println("name : " + name + ", age : " + age);
//		return "roze";
//	}

	@RequestMapping(value = "/roze") // blackpink/roze
	public String myRoze(@RequestParam("name") String myName, @RequestParam("age") String Myage) {
						// get방식에서 name으로 넘어온 값을 myName에 넣는다. 변수명과 get에서 넘어온 값이 같다면 사용 x
		System.out.println("myRoze 함수 실행");
		System.out.println("name : " + myName + ", age : " + Myage);
		return "roze"; // jsp 파일명과 동일해야 한다.
	}

	@RequestMapping("/roze/kgb") // URL만 기입하면 value 생략 가능
	public String myRoze1() {
		System.out.println("myRoze 함수 실행");
		System.out.println("/kgb");
		return "roze";
	}
	
	@RequestMapping(value = "/jenni", method = RequestMethod.POST) // 두개 이상의 값이 들어오면 생략 불가능
	public String myJenni(String nm_name, String nm_alias) {
		System.out.println("post 방식");
		System.out.println(nm_name + " : " + nm_alias);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		return "roze";
	}
}