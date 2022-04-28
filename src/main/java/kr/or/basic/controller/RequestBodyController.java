package kr.or.basic.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.basic.domain.Soo;

@Controller
@RequestMapping("/soo")
public class RequestBodyController {

	// GetMapping, PostMapping url이 같아도 처리항 방식에 맞춰 실행된다.
	
	
	@GetMapping("/inputForm")
	public String inputForm() { // 사용자에게 입력폼을 보여주려 할때에는 보통 get방식으로 받는다.
		return "inputForm";
	}
	
	@PostMapping(value = "/inputForm1", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String postForm(String nm_name, String nm_special, String nm_age) {
		return nm_name + nm_special + nm_age;
	}
	
	@PostMapping(value = "/inputForm2", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Soo postForm2(Soo soo) {
		return soo;
	}
	
	@PostMapping(value = "/inputForm3", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String postForm3(@RequestBody String query) throws Exception {
		return URLDecoder.decode(query, "UTF-8");
	}
	
	@PostMapping(value = "/inputForm4", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> postForm4(@RequestBody Map<String, String> map) { // @RequestBody 는 post방식에만 사용
		System.out.println(map.toString());										 // value 데이터타입이 섞여있을 때는 Object를 사용, but 일관성있게 타입 통일
		return map;
	}
	
	@PostMapping(value = "/inputForm5", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, List<String>> postForm5(@RequestBody Map<String, List<String>> map) { // @RequestBody 는 post방식에만 사용
//		System.out.println(map.get("nm_name").get(0));										 // value 데이터타입이 섞여있을 때는 Object를 사용, but 일관성있게 타입 통일
		List<String> myList = map.get("nm_name");
		for(String myval : myList) {
			System.out.println(myval);
		}
		return map;
	}
	
	@PostMapping(value = "/inputForm6", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String postForm6(Soo soo) {
		List<MultipartFile> files = soo.getFiles();
		
		// file 넘어온지 확인
		for(MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
		}
		return "ok"; // return에 파일이 포함되면 안된다. (JSON 형식으로 바꿀 수 없는 객체)
	}
}
