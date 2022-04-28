package kr.or.basic.controller;

import java.util.HashMap;
import java.util.Map;

// path => controller를 연결시킬 키워드
public class HandlersMapping {
	// String => controller를 맵핑시킬 Map 생성
	Map<String, Controller> mappings;
	
	public HandlersMapping() {
		this.mappings = new HashMap<String, Controller>();
	}

	// 생성자에서 setter 했기 때문에 getter만 생성
	public Map<String, Controller> getMappings() {
		return mappings;
	}
}
