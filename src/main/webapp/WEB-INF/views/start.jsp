<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- WEB-INF 폴더는 브라우져에서 다이렉트로 접속 불가능 -->
<!-- webapp/resources 폴더는 사용자에게 열려있음 (css, js, image 와 같은 보안상 중요하지 않은 것들을 넣음)-->

<!-- servlet-context.xml => web 관련 -->
<!-- <resources mapping="/css/**" location="/resources/css/" /> servlet-context.xml 파일에서 mapping 주소를 location 주소로 자동 인식한다. -->

<!-- root-context => 전반적 관련 -->

<!--
웹프로젝트 구조

사용자 요청 =>
presentation(MVC) => service => persistent(DB, 저장소)
사용자 응답 <=

  -->
<% for(int i = 0; i <= 5; i++) { %>
<h1> !!! </h1>
<% } %>
</body>
</html>