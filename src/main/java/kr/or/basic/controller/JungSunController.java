package kr.or.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.basic.domain.JungSun;

@Controller
public class JungSunController {
	
	@Autowired // Servlet-context에서 만든것 연결
	public JungSun jungSun; // D.I Dependency Injection, IOC
	
//	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping("/jungsun")
	public void getJungsun(Model model) { // void type => url mapping value와 동일한 jsp를 찾는다.
		jungSun.setName("jungsun");
		model.addAttribute("jungsun", jungSun.getName() + "1"); // model에 attribute를 담아준다.
		System.out.println(jungSun.getName());
	}
}
