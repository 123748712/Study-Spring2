package kr.or.basic.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

// 실제 소스를 확인하니 HandlerInterceptor 인터페이스에도 default를 이용
// 둘중 무엇을 써도 상관 없음
@Slf4j
public class MyFirstInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) // 컨트롤러로 가기 전 실행
			throws Exception {
		log.info("값 : " + request.getParameter("nm_admin"));
		
		if(request.getParameter("nm_admin").equalsIgnoreCase("admin")) {
			log.info("admin ok");
			return true; // 조건이 맞으면 통과
		}
		response.sendRedirect("/basic/user/form"); // 통과하지 못하면 다시 통과할 수 있도록 다시 로그인하는 form url 쏴주기
		return false; // 조건에 맞지 않으면 통과x
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("postHandle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion");
	}	
}
