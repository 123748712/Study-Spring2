package kr.or.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import lombok.extern.slf4j.Slf4j;

// tomcat에서 Spring DispatcherServlet으로 넘어가는 중간에 실행되는게 Filter
// 보안관련, 접근로그, 특정 URL패턴에 공통적용이 필요한 기능 구현시 사용
// Spring Security가 필터, 인터셉터를 이용해 만들어짐
// 필터가 조금 넓은 영역에 적용, 인터셉터는 구체적인 좁은 영역에 적용
@Slf4j
//@WebFilter(urlPatterns = "/*") // web.xml에 등록하지 않아도 Filter 실행
public class MyFirstFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("init");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("start");
		request.setAttribute("a", "a"); // filter가 url-pattern에 등록한 url이 실행되면 request에 Attribute로 담아주어 url 실행시 모든곳에서 사용할 수 있다.
		chain.doFilter(request, response); // Filter Chain의 핵심. 필터가 필터를 호출함.
		log.info("end"); // 먼저 호출된 필터 안에 나중에 호출된 필터가 들어가게 되어 나중에 호출된 필터가 종료되어야 먼저 호출된 필터도 종료된다.

	}
	
	@Override
	public void destroy() {
		log.info("destroy");
	}
}
