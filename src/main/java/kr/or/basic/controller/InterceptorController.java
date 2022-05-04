package kr.or.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class InterceptorController {

	@GetMapping("/form") // form.jsp에서 입력한 조건을 interceptor가 controller로 넘어가기전 확인 후
	public String ckForm() {
		return "formCk";
	}
	
	@RequestMapping("/login") 
	public String ckInterceptor() { // 통과하게 된다면 이 메소드로 넘어와 home.jsp가 보여짐
		log.info("체크");
		return "home";
	}
}
