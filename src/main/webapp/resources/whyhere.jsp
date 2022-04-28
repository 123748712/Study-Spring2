<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--WEB-INF 폴더는 브라우저에서 다이렉트로 접속이 안됨(접속x) /
	webapp/resoueces 폴더는 사용자에게 열려있음(접속o)
	:보안상 중요하지 않는 것들 보관(css,js,img등)
-->
<% for(int i=1; i<=5; i++){ %>
<h1>405호</h1>
<% } %>
</body>
</html>