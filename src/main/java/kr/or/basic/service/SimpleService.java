package kr.or.basic.service;

// interface 사용은 결합도를 낮춰준다.
// 상황적으로 DAO와 서비스의 메소드는 같은 메소드 이름을 가지는 경우가 굉장히 많다.

// @Service 어노테이션 적지 않도록 주의 ! (interface는 객체가 생성되지 않기 때문)
public interface SimpleService {
	public String select(String buyer_id);
	public int insert();
	public int update();
	public int delete();
}
