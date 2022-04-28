package kr.or.basic.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.basic.domain.Nums;

@Controller // 컨트롤러 등록 어노테이션
@RequestMapping("/remind")
public class RemindController {
	// get방식 요청에 입력화면을 보여주고 post방식이 요청에 처리를 해주는 식으로 많이 진행
	
	@RequestMapping("/test") // url만 기입한다면 value="" 생략 가능
	public String getTest(Model model) { // servlet에서 jsp로 데이터를 전송하고 싶다면 파라미터로 Model 기입
//		List<String> tests = new ArrayList<>();
//		tests.add("testA");
//		tests.add("testB");
//		tests.add("testC");
//		model.addAttribute("name", "test"); // 단일 전송
//		model.addAttribute("tests", tests); // 2개 이상 데이터 묶어서 전송

		
		// servlet-context에서 view를 결정할 내부 소스를 제공해주어 /WEB-INF/views/.jsp 를 붙여준다.
		return "remindForm"; // /WEB-INF/views/remind.jsp
		// 입력화면을 보여주는 페이지
	}
	
//	@GetMapping("/test")
//	public void getTest(Model model) {
//		// return 타입이 void인 경우 요청 url 그대로 jsp를 찾는다.
//	}
	
	@PostMapping("/test") // url만 기입한다면 value="" 생략 가능 // @RequestParam => 변수명과 input name이 달라도 받아올 수 있는 어노테이션
	public String postTest(Model model, String nm_testA,   // required = boolean 값을 꼭 가져와야하는지, 가져오지 않아도 되는지 구분 / defaultValue => 값이 넘어오지 않았을때 가지는 기본 값 
							@RequestParam(value = "nm_testB", required = false, defaultValue = "default") String testB) { // servlet에서 jsp로 데이터를 전송하고 싶다면 파라미터로 Model 기입 
																	  		  // 파라미터 변수명이 form의 input name과 같으면 자동으로 받아와짐 value 생략 가능
		List<String> tests = new ArrayList<>();
		
		tests.add("testA");
		tests.add("testB");
		tests.add("testC");
		
		model.addAttribute("testA", nm_testA);
		model.addAttribute("testB", testB);
		
//		ModelAndView mav = new ModelAndView(); // ModelAndView 로도 가능하다.
//		mav.addObject("testA", nm_testA);
//		mav.addObject("name", testB);
//		mav.setViewName("remind");
//		return mav;
		
		return "remind"; // /WEB-INF/views/remind.jsp
		// servlet-context에서 view를 결정할 내부 소스를 제공해주어 /WEB-INF/views/.jsp 를 붙여준다.
	}
	
//	@GetMapping("/tst")
//	@ResponseBody // ajax 전용 어노테이션, .jsp를 찾지 않고 클라이언트(브라우저)로 바로 전송됨
//	public String ajaxTest(String aaa, String bbb) { // 주소창에 ?aaa=값&bbb=값을 입력해야함
//		return aaa + " " + bbb; // aaa + " " + bbb.jsp 를 찾지 않음.
//	}
	
	@GetMapping("/tst")
	public String ajaxForm() {
		return "tstForm";
	}
	
	@PostMapping("/tst")
	@ResponseBody 
	public String ajaxTest(String nm_first, String nm_second, String nm_sel, MultipartFile uploadFile) {
		System.out.println("ck1 : " + nm_first);
		System.out.println("ck2 : " + nm_second);
		System.out.println("calc : " + nm_sel);
		int result = 0;
		if(nm_sel.equals("p")) {
			result = Integer.parseInt(nm_first) + Integer.parseInt(nm_second);
		} else if(nm_sel.equals("m")) {
			result = Integer.parseInt(nm_first) - Integer.parseInt(nm_second);
		} else if(nm_sel.equals("t")) {
			result = Integer.parseInt(nm_first) * Integer.parseInt(nm_second);
		} else if(nm_sel.equals("d")) {
			result = Integer.parseInt(nm_first) / Integer.parseInt(nm_second);
		}
		System.out.println(result);
		
		 System.out.println(uploadFile.getOriginalFilename());
		 System.out.println(uploadFile.getSize());
		 System.out.println(uploadFile.getName());
	      
		return Integer.toString(result);
		}
	
		@PostMapping("/tst2")
		public String postHuk2(Nums nums,// VO클래스를 한번에 불러서 사용
							MultipartFile files) throws Exception {
		
		System.out.println("값확인: " + nums.toString());
		System.out.println("파일명: " + files.getOriginalFilename());
		System.out.println("사이즈: " + files.getSize());
		System.out.println(": " + files.getName());
		
		files.transferTo(new File("d:/upload/" + files.getOriginalFilename())); // transferto만 있으면 파일 전송 가능
		
		return "error";
	}
}
// .jsp만 변경한다면 서버를 다시 restart 하지 않아도 된다.
// but, .java를 변경한다면 서버를 다시 restart 해야한다.