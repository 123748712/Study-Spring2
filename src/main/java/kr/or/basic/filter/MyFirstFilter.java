package kr.or.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

// tomcat에서 Spring DispatcherServlet으로 넘어가는 중간에 실행되는게 Filter
@Slf4j
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
		chain.doFilter(request, response); // Filter Chain의 핵심
		log.info("end");

	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
