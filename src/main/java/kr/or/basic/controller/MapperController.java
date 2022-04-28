package kr.or.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.basic.mapper.TestMapper;
import kr.or.basic.service.SimpleService;
import lombok.extern.slf4j.Slf4j;

@Controller
public class MapperController {
	@Autowired
	private SimpleService simpleService; // Service가 TestMapper와 연결되어있기 때문에 Service를 불러옴.
//	public TestMapper testMapper; //인터페이스 TestMapper을 연결. Service를 불러왔기 때문에 직접적으로 Mapper(DAO)를 불러오지 않아도 됨
	
//	@GetMapping(value = "/mybatis", produces = "application/json;charset=UTF-8")
	@GetMapping(value = "/mybatis", produces = MediaType.APPLICATION_JSON_VALUE) //한글이 나옴
	@ResponseBody //브라우저에 바로 출력
	public String test(String buyer_id) { // 매개변수로 buyer_id 를 받아와 내가 원하는 id를 검색할 수 있게 한다.
		return simpleService.select(buyer_id); //인터페이스의 getBuyer메소드를 실행시키면서 그에따른 sql문도 실행
//		return testMapper.getBuyer(buyer_id); //인터페이스의 getBuyer메소드를 실행시키면서 그에따른 sql문도 실행
	}
	
	@GetMapping(value = "/mybatis/insert", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int insert() {
		return simpleService.insert();
//		return testMapper.insertSimple();
	}
	@GetMapping(value = "/mybatis/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int update() {
		return simpleService.update();
//		return testMapper.updateSimple();
	}
	@GetMapping(value = "/mybatis/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int delete() {
		return simpleService.delete();
//		return testMapper.deleteSimple();
	}
}
