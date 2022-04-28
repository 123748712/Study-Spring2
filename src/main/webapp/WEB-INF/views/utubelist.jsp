<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>youtube</title>
</head>
<body>
<input type="text" id="id_sch" value="">
<input type="button" value="검색" id="id_btn">
<script>
	const c_sch = document.querySelector("#id_sch");
	const c_btn = document.querySelector("#id_btn");
	const codes = [];
	const listArr = [];
	const f_getTitle = function(p_code) {
		const xhr = new XMLHttpRequest();
		let schWord = c_sch.value;
		let url = "<%=request.getContextPath()%>/bypass/utubeTitle?schCode=" + p_code;
		    xhr.open("get", url, true);
		    xhr.onreadystatechange = function() {
		        if(xhr.readyState == 4 & xhr.status == 200) {
		        	// 슨번, 타이틀 / 타이틀 클릭하면 해당 영상 열리도록
		        	// 1. 제목1 ...
					const readBody = xhr.responseText;
					let startIndex = readBody.indexOf("<title>")+7;
					let endIndex = readBody.indexOf("</title>");
					let title = readBody.substring(startIndex, endIndex);
					let videoVO = {};
					videoVO.code = p_code;
					videoVO.title = title;
					listArr.push(videoVO);
// 					console.log(title);

console.log(p_code, title);
		        }
	        }
	    xhr.send();
	}
	
	const f_btnClick = function() {
		const xhr = new XMLHttpRequest();
		let schWord = c_sch.value.trim();
		let url = "<%=request.getContextPath()%>/bypass/utube?schWord=" + schWord;
		    xhr.open("get", url, true);
		    xhr.onreadystatechange = function() {
		        if(xhr.readyState == 4 & xhr.status == 200) {
// 		        	console.log(xhr.responseText);
					const readBody = xhr.responseText;
					
					let atIndex = 0; // 찾기 시작하는 위치
					let sIndex; // 찾은 위치
					// indexOf("찾을 문자열", 찾기 시작 위치 지정)
					while((sIndex=readBody.indexOf("watch?", atIndex)) != -1) {
					let startIndex = sIndex+8;
					let endIndex = startIndex+11;
					atIndex = endIndex;
// 					console.log(readBody.substring(startIndex, endIndex));
					let code = readBody.substring(startIndex, endIndex);
					f_getTitle(code);
					}
					console.log(codes);
		        }
		    }
		    xhr.send();
	}
	c_btn.addEventListener("click", f_btnClick);
</script>
</body>
</html>