package kr.or.basic.useless;

// Adapter패턴 예시 구현
// 구현 해도 안해도 상관 없는 메소드들이 많을수록 Adapter 효율이 좋아짐
public class InterceptorAdapter implements InterceptorInterface {
	// 내용은 없지만 상속받은 인터페이스의 메소드는 구현
	@Override
	public void init() {
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void destroy() {
	}

	@Override
	public void destroy2() {
	}

}
