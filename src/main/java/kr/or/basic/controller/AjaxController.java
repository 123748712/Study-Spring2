package kr.or.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	@ResponseBody // Hello.jsp를 찾지 않고 클라이언트로 리턴
	@RequestMapping("/ajax")
	public List<Map<String, String>> rawResponse() {
		List<Map<String, String>> myList = new ArrayList<>();
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("star1", "roze");
		myMap.put("star2", "jenni");
		myMap.put("star3", "risa");
		myMap.put("star4", "jisu");
		
		myList.add(myMap);
		return myList;
		
		// jackson 라이브러리를 통해 List, Map 형태들도 JSON 형태로 변환할 수 있다.
	}
	@GetMapping("/ajax/start")
	public String start() {
		return "readyForm";
	}
	
	@GetMapping("/ajax/get")
	@ResponseBody
	public String get() {
		return "get";
	}
	
	@PostMapping("/ajax/post")
	@ResponseBody
	public String post() {
		return "post";
	}
	
	@PutMapping("ajax/put")
	@ResponseBody
	public String put() {
		return "put";
	}
	
	@DeleteMapping("ajax/delete")
	@ResponseBody
	public String delete() {
		return "delete";
	}
}