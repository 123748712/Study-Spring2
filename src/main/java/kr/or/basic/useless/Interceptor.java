package kr.or.basic.useless;

public class Interceptor extends InterceptorAdapter {
	// 필요한 메소드만 오버라이딩
	
	@Override
	public String getName() {
		return "인터셉터";
	}
}
