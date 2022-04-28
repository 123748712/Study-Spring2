<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>youtube</title>
</head>
<body>
<iframe id="id_utube" width="600" height="400" src="https://www.youtube.com/embed/bgQIzPnPI88?autoplay=1&mute=1"
		title="YouTube video player" frameborder="0"
		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
		allowfullscreen></iframe>
<input type="text" id="id_sch" value="">
<input type="button" value="검색" id="id_btn">
<div id="id_list"></div>
<script>
	const c_utube = document.querySelector("#id_utube");
	const c_list = document.querySelector("#id_list");
	const c_sch = document.querySelector("#id_sch");
	const c_btn = document.querySelector("#id_btn");
	const videoList = []; // code, title 담아줄 배열(전역변수)
	const preURL = "https://www.youtube.com/embed/";
	const postURL = "?autoplay=1&mute=1";
	
	const f_trClick = function(p_code) {
		c_utube.src = preURL + p_code + postURL;
		console.log(preURL + p_code + postURL);
	}
	
	const f_getTitle = function(p_code) {
		const xhr = new XMLHttpRequest();
		let schWord = c_sch.value.trim();
		let url = "<%=request.getContextPath()%>/bypass/utubeTitle?schCode=" + p_code;
		    xhr.open("get", url, false);
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
					videoList.push(videoVO);
					console.log(p_code, title);
		        }
	        }
	    xhr.send();
	}
	
	const f_btnClick = function() {
		videoList.splice(0, videoList.length); // 계속 push 되는것 방지하기 위해 초기화
		
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
					const codes = [];
					// indexOf("찾을 문자열", 찾기 시작 위치 지정)
					while((sIndex=readBody.indexOf("watch?", atIndex)) != -1) {
					let startIndex = sIndex+8;
					let endIndex = startIndex+11;
					atIndex = endIndex;
// 					console.log(readBody.substring(startIndex, endIndex));
					let code = readBody.substring(startIndex, endIndex);
					let isIn = false; // 없다고 가정
					for(let i = 0; i < codes.length; i++) {
						if(codes[i] == code) {
							isIn = true; // 없는데 있다면, (문법이 실행되었다면 있는 것)
							break; // 이미 가정이 틀렸음.
						}
					}
					if(!isIn) {
						codes.push(code);
						f_getTitle(code);
						if(codes.length == 5) { // 상위 5개만 잘라오기
							break;
						}
					}
					}
					let tblStr = "<table border=1>";
						tblStr += "<tr><th>순번</th><th>제목</th></tr>";
					for(let i = 0; i < videoList.length; i++) {
						tblStr += "<tr onclick=f_trClick('" + videoList[i].code + "')>";
						tblStr += "<td>" + (i+1) + "</td>";
						tblStr += "<td>" + videoList[i].title + "</td>";
						tblStr += "</tr>";
					}
					tblStr += "</table>";
					c_list.innerHTML = tblStr;
		        }
		    }
		    xhr.send();
	}
	c_btn.addEventListener("click", f_btnClick);
</script>
</body>
</html>