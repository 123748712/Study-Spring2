package kr.or.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.basic.mapper.TestMapper;

		 // Service라는 명시적 의미와 더불어 스프링에게 객체생성을 의뢰해 Service객체가 생성됨
@Service // (Service interface는 객체가 생성되지 않기 때문에 interface에 적지 않도록 주의 !)
public class SimpleServiceImpl implements SimpleService {
	@Autowired
	private TestMapper testMapper;
	
	@Override
	public String select(String buyer_id) {
		// 서비스 로직 들어갈 자리 (서비스의 역할)
		return testMapper.getBuyer(buyer_id);
	}

	@Override
	public int insert() {
		return testMapper.insertSimple();
	}

	@Override
	public int update() {
		return testMapper.updateSimple();
	}

	@Override
	public int delete() {
		return testMapper.deleteSimple();
	}

}
