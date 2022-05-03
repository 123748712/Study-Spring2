package kr.or.basic.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

// 예외 처리 컨트롤러
@ControllerAdvice
public class CommonExceptionController {
	// 예외 처리
	@ExceptionHandler(NullPointerException.class) // 해당하는 에러 발생시 return에 작성한 jsp로 이동
	public String nullHandler(NullPointerException ne, Model model) {
		model.addAttribute("exception", "Null" + ne.getMessage() + "error"); // jsp에 데이터를 넘겨주기 위해 model 객체 활용
		return "error/error"; // 폴더명/파일명 (error/error.jsp)
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String notFoundHandler(NoHandlerFoundException nhf, Model model) {
		model.addAttribute("exception", "nfh" + nhf.getMessage() + "error"); 
		return "error/error"; 
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex, Model model) {
		model.addAttribute("exception", "exception" + ex.getMessage() + "error");
		return "error/error";
	}
}