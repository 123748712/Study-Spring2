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

@Slf4j
@WebFilter(urlPatterns = "/*") // 필터의 순서가 보이지 않아 사용하지 않는다.
public class MySecondFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("init 2");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("start 2");
		request.setAttribute("a2", "a2"); // filter가 url-pattern에 등록한 url이 실행되면 request에 Attribute로 담아주어 url 실행시 모든곳에서 사용할 수 있다.
		chain.doFilter(request, response); // Filter Chain의 핵심
		log.info("end 2");

	}
	
	@Override
	public void destroy() {
		log.info("destroy 2");
	}
}
