<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 사용자 입력폼에 name 속성을 빠트리면 전송 x -->
	<form action="<%=request.getContextPath() %>/remind/test" method="post">
		testA : <input type="text" name="nm_testA" value="" required="required"> <br>
		testB : <input type="text" name="nm_testB" value=""> <br>
		<button type="submit">전송</button>
		<!-- button은 form태그 안에 들어가면 자동으로 type="submit" -->
	</form>
</body>
</html>