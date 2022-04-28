<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/soo/inputForm6" method="post" enctype="multipart/form-data">
	이름 : <input type="text" name="nm_name" id="id_name" value="이름"> <br>
	특기 : <input type="text" name="nm_special" id="id_special" value="특기"> <br>
	나이 : <input type="text" name="nm_age" id="id_age" value="나이">
	이미지 : <input type="file" name="files" id="id_files" value="" multiple accept=".jpg, .png, .gif">
	<input type="submit" value="click">
	<input type="button" value="click2" id="id_btn">
	<input type="button" value="click3" id="id_btn2">
</form>
<script>
	const c_btn = document.querySelector("#id_btn");
	const c_btn2 = document.querySelector("#id_btn2");
	const c_name = document.querySelector("#id_name");
	const c_special = document.querySelector("#nm_special");
	const c_age = document.querySelector("#id_age");
	
	const c_btnClick = () => {
		const c_xhr = new XMLHttpRequest();
		c_xhr.open("post", "<%=request.getContextPath()%>/soo/inputForm4", true);
		c_xhr.onreadystatechange = function() {
			if(c_xhr.readyState == 4 && c_xhr.status == 200) {
				alert(c_xhr.responseText);
			}
		}
		let l_data = {
				nm_name : c_name.value,
				nm_special : c_special.value,
				nm_age : c_name.value,
		}
		// Header 세팅은 항상 send 전에 해야함
		// 문자열화 했지만, 형식이 기본 URL Encoding 방식(name=value)이 아니고, JSON문법임을 알려줘야 함
		c_xhr.setRequestHeader("Content-Type", "application/json");
		c_xhr.send(JSON.stringify(l_data));
	}
	c_btn.addEventListener("click", c_btnClick);
	
	const c_btnClick2 = () => {
		const c_xhr = new XMLHttpRequest();
		c_xhr.open("post", "<%=request.getContextPath()%>/soo/inputForm5", true);
		c_xhr.onreadystatechange = function() {
			if(c_xhr.readyState == 4 && c_xhr.status == 200) {
				console.log(JSON.parse(c_xhr.responseText));
			}
		}
		let l_data = {
				nm_name : ["a", "b", "c"],
				nm_special : ["aa", "bb", "cc"],
				nm_age : ["1", "2", "3"]
		}
		// Header 세팅은 항상 send 전에 해야함
		// 문자열화 했지만, 형식이 기본 URL Encoding 방식(name=value)이 아니고, JSON문법임을 알려줘야 함
		c_xhr.setRequestHeader("Content-Type", "application/json");
		c_xhr.send(JSON.stringify(l_data));
	}
	c_btn2.addEventListener("click", c_btnClick2);
</script>
</body>
</html>