<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#id_disp {
		width: 200px;
		height: 200px;
		border: 2px solid pink;
	}
</style>
</head>
<body>
	<div id="id_disp">div</div>
	<form id="id_form" action="<%=request.getContextPath() %>/remind/tst" method="post" enctype="application/x-www-form-urlencoded">
		first : <input type="text" name="nm_first" value="" required> <br>
		second : <input type="text" name="nm_second" value="" required> <br>
		calc <select name="nm_sel"> <!-- 선택한 option의 value 값을 넘겨준다. -->
			<option value="p">plus</option>
			<option value="m">minus</option>
			<option value="t">multi</option>
			<option value="d">divis</option>
		</select><br>
		<input type="file" name="files" value=""><br>
		<button id="id_submit">계산</button>
	</form>
<script>
	const v_form = document.querySelector("#id_form");
	const v_disp = document.querySelector("#id_disp");
	const f_DataString = () => {
		let retStr = "";
		for(let i = 0; i < v_form.elements.length; i++){
			retStr += v_form.elements[i].name + "=" + v_form.elements[i].value;
			retStr += "&";
		}
		return retStr.substring(0, retStr.length-3); // 마지막 & 지워주기
	}
	const f_submit = () => {
		event.preventDefault(); // ajax로 데이터를 전송할거기 때문에 이벤트 막기
		
		console.log(f_DataString());
		let sendData = f_DataString();
		
		const xhr = new XMLHttpRequest(); // 뒤로 통신
		xhr.open("post","<%=request.getContextPath() %>/remind/tst",true);
		
		// send 전에 추가적으로 세팅(get에서는 필요 없음)
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				v_disp.innerHTML = "서버 전송 값 : " + xhr.responseText; // 서버에서 받은 값을 div 에 넣어준다.
			}
		}
		xhr.send(sendData); // 실행 get방식은 ()안에 아무것도 적지 않지만, post는 넘겨줄 데이터를 넣어준다.
	}
	
	// 현재 아래와 같으면 Multipart parser가 없기 때문. (parser => 해석기)
	// FormData를 보낼때는 서버쪽에 Mutipart 설정이 되어 있어야 편하게 받을 수 있음
	const f_submit1 = () => {
		event.preventDefault(); // ajax로 데이터를 전송할거기 때문에 이벤트 막기
		// FormData 활용
		let formData = new FormData(v_form); // 매개변수로 form 데이터를 넘겨준다.
		
		// 파일을 보낼때는 파일 객체를 따로 담아줘야 함
// 		console.log(formData.values());
// 		// iterator는 for of 문을 사용
// 		for(let value of formData.values()) {
// 			console.log(value); // 문자열을 구분하지 않아도 FormData가 form 데이터를 알아서 담아준다.
// 		}
		
		let sendData = f_DataString();
		
		const xhr = new XMLHttpRequest(); // 뒤로 통신
		xhr.open("post","<%=request.getContextPath() %>/remind/tst",true);
		
		// send 전에 추가적으로 세팅(get에서는 필요 없음)
// 		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				v_disp.innerHTML = "서버 전송 값 : " + xhr.responseText; // 서버에서 받은 값을 div 에 넣어준다.
			}
		}
		xhr.send(formData); // 실행 get방식은 ()안에 아무것도 적지 않지만, post는 넘겨줄 데이터를 넣어준다.
	}
	// form은 전송되기 직전에 onsubmit 이벤트를 발생시킴
	v_form.addEventListener("submit", f_submit);
</script>
</body>
</html>