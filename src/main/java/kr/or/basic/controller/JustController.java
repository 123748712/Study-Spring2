package kr.or.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JustController {

	@RequestMapping(value = "/just")
	public String getJust(Model model) {
		// Controller가 jsp에 값을 넘겨야 할 때, Model 사용
		// Model에 담기만 하면 jsp에서 사용 가능
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("bts1", "지민");
		myMap.put("bts2", "RM");
		myMap.put("bts3", "정국");
		
		model.addAttribute("bts", myMap); // Map을 넘김
		model.addAttribute("myName", "Roze");
		return "test/just";
		// "WEB-INT/views" + "test/just" + ".jsp"
	}
}
