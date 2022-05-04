<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- src가 cross origin 영향을 받지 않는다. (오직 AJAX에서 croos origin 영향을 받음. 조작이 가능하기 때문에 영향을 받게끔) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>																     
	<form id="id_form" action="<%= request.getContextPath() %>/gUpload"> <!-- enctype="" 전송 방식 구분 -->
		<input type="file" id="id_file" value="" accept=".jsp, .jpeg, .png, .gif"> <br>
		<input type="text" name="nm_aaa" value="aaa"> <br>
		<input type="submit" value="바닐라js전송"> <br>
		<input type="submit" value="jQuery전송">
	</form>
<script>
	// form태그는 여러개 들어갈 수 있기 때문에 document에서 forms배열을 생성해 넣어준다.
	// but, form안에 form은 사용 불가능
	const c_form = document.forms[0];
	const c_file = document.querySelector("#id_file");
// 	const c_form = document.querySelector("#id_form"); 아이디로 받아오기
	
	const f_submit = () => {
		event.preventDefault();
		
// 		console.log(c_file.value); // 파일이름만 담겨옴. 객체가 아님.
		console.log(c_file.files); // 파일 객체 넘어오는지 확인
		
		// jQuery 사용 파일 업로드
		let formData = new FormData(c_form); // 전송방식 multipart/form-data로 변경 매개변수로 form을 보낼시 input.value가 자동으로 들어감(파일 제외 파일.value = 파일 이름)
		formData.append("upload", c_file.files[0]) // (name, 파일객체) name은 컨트롤러에서 Multipartfile 변수명과 동일하게 하는게 좋다.

		// 바닐라JS (파일 전송에 한해서 더 쉽고 편함)
		const c_xhr = new XMLHttpRequest();
		c_xhr.open("post", "<%=request.getContextPath()%>/gUpload", true);
		c_xhr.onreadystatechange = function() {
			if(c_xhr.readyState == 4 && c_xhr.status == 200) {
				console.log(c_xhr.responseText);
				let fileName = c_xhr.responseText.split("_")[1];
				let l_a = document.createElement("a");
				l_a.href = c_xhr.responseText;
				l_a.download = fileName; // 클릭시 다운로드
// 				l_a.onclick = function() {
// 					event.preventDefault();
// 					window.open(c_xhr.responseText, "", "width=200, height=200,left=50,top=50")
// 				}
// 				l_a.target = "_blank"; // a태크 클릭시 새창
				
				let l_img = document.createElement("img");
				l_img.width = 50;
				l_img.height = 50;
				l_img.src = c_xhr.responseText;
				
				l_a.appendChild(l_img);
				
				document.body.appendChild(l_a);
			}
		}
		c_xhr.send(formData);

		/*
		// jQuery
		$.ajax({
			type : "post",
			url : "<%=request.getContextPath()%>/gUpload",
			contentType : false, // false로 변환되는걸 막는다. formData 전송방식이 multipart인데 적지 않으면 default값인 appliation/x-www...으로 변환된다.
			processData : false, // 처리방식도 default인 application/x-www...으로 변환되는걸 막는다.
			data : formData, // 파일을 저장한 formData를 넘김
			success : function(p_rslt) {
				console.log(p_rslt);
			},
			error : function() {
				alert("error");
			}
		})
		*/
	}

	c_form.addEventListener("submit", f_submit);
	
	
</script>
</body>
</html>