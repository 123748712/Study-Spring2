package kr.or.basic.service;

import org.springframework.stereotype.Service;

//@Service 어노테이션으로도 Service 객체를 쉽게 변경할 수 있다.
public class SimpleServiceimpl2 implements SimpleService {

	@Override
	public String select(String buyer_id) {
		return "aa";
	}

	@Override
	public int insert() {
		return 10;
	}

	@Override
	public int update() {
		return 20;
	}

	@Override
	public int delete() {
		return 30;
	}
}
