package kr.or.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyDispatcher
 */
// @Controller, @RequestMapping
// classpath에 같은 이름의 설정파일이 있다면 내용 일치해야함
@WebServlet("*.do") // web.xml 에 등록하는 절차 생략, .do로 끝나는 모든 url에 연결됨
public class MyDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HandlersMapping handlersMapping = new HandlersMapping();
	private ViewResolver viewResolver = new ViewResolver();
	
    public MyDispatcher() {
        super();
    }
    
    // init 메소드 객체가 생성되고 바로 실행되는 초기화 블락
    @Override
    public void init() throws ServletException {
    	handlersMapping.getMappings().put("/aaa.do", new MyController());
    	viewResolver.setPrefix("/WEB-INF/views/");
    	viewResolver.setPostfix(".jsp");
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response); // 메소드 호출
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		process(request, response); // 메소드 호출
	}
	
	// get, post 강제로 묶어주기
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqURI = request.getRequestURI();
		String path = reqURI.substring(reqURI.lastIndexOf("/")); // 마지막 / 뒤의 것만 추출
		System.out.println(path); // *.do 문자열 추출
		
		Controller ctr1 = handlersMapping.getMappings().get(path); // HashMap에 넣어놓은 key, value 꺼내기 (value = controller)
		System.out.println("controller : " + ctr1);
		String viewName = ctr1.handleRequest();
		System.out.println("viewName : " + viewName);
		String viewPath = viewResolver.getView(viewName); // init 으로 set해준 /WEB-INF/views/viewName.jsp 경로 추출
		System.out.println("viewPath : " + viewPath);

		// 데이터 담아서 보내기
		request.setAttribute("aaa", "a ! a ! a !");
		
		request.getRequestDispatcher(viewPath).forward(request, response);
	}
}