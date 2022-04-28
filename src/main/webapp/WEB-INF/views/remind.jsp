<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${ testA }</h1> <%-- ${ model.key값 } => value값 출력 --%>
<h1>${ testB }</h1>

<%-- <p>${ tests.toString() }</p> 묶음 데이터 --%>
<%-- <!-- ${} --> 불가능한 주석(HTML주석)--%> 
<%-- ${} 가능한 주석(JSP주석) --%>
</body>
</html>