<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mystyle.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/x2js/1.2.0/xml2json.min.js"></script>
<style>
#id_disp {
	border: 1px solid pink;
}
</style>
<!-- css 파일과 연결 -->
</head>
<body>
검색어 <input type="text" id="id_sch" value=""> <br>
<input type="button" id="id_search" value="검색">
<div id="id_disp"></div>
<P>  The time on the server is ${serverTime}. </P>
<form action="/basic/blackpink/jenni" method="post">
	이름<input type="text" name="nm_name" value="배트맨"><br>
	별명<input type="text" name="nm_alias" value="박쥐"><br>
	<input type="submit" value="전송">
</form>
<input type="button" value="서버우회" id="id_btn">
<input type="button" value="googleNews-xml" id="id_btn2">
<input type="button" value="button3" id="id_btn3">
<script>
	const c_btn3 = document.querySelector("#id_btn3");
	const f_btn3Click = function() {
		const xhr = new XMLHttpRequest();
		let schWord = c_sch.value;
		let url = "<%=request.getContextPath()%>/bypass/googleNews?schWord=" + schWord;
		    xhr.open("get", url, true);
		    xhr.onreadystatechange = function() {
		        if(xhr.readyState == 4 & xhr.status == 200) {
		        	// xml문자열을 JSON으로 변환
		        	// 서버쪽보다 클라이언트에서 하는 것이 유리
					var x2js = new X2JS();
		        	var jsonObj = x2js.xml_str2json( xmlText );
		        	console.log(jsonObj);
		        }
		    }
		    xhr.send();
	}
	
	c_btn3.addEventListener("click", f_btn3Click);

	const c_btn = document.querySelector("#id_btn");
	const f_btnClick = () => {
		 const xhr = new XMLHttpRequest();
		 let url = "<%=request.getContextPath()%>/bypass/googleNews";
		    xhr.open("get", url, true);
		    xhr.onreadystatechange = function() {
		        if(xhr.readyState == 4 & xhr.status == 200) {
		            console.log(xhr.responseText);
		        }
		    }
		    xhr.send();
	}
	c_btn.addEventListener("click", f_btnClick);
	
// 	const c_btn2 = document.querySelector("#id_btn2");
// 	const f_btnClick2 = () => {
// 		 const xhr = new XMLHttpRequest();
<%-- 		 let url = "<%=request.getContextPath()%>/bypass/google"; --%>
// 		    xhr.open("get", url, true);
// 		    xhr.onreadystatechange = function() {
// 		        if(xhr.readyState == 4 & xhr.status == 200) {
// 		            console.log(xhr.responseXML);
// 		        }
// 		    }
// 		    xhr.send();
// 	}
// 	c_btn2.addEventListener("click", f_btnClick2);
	
	const c_btn2 = document.querySelector("#id_btn2");
	const f_btnClick2 = () => {
		 const xhr = new XMLHttpRequest();
		 let url = "<%=request.getContextPath()%>/bypass/google2";
		    xhr.open("get", url, true);
		    xhr.onreadystatechange = function() {
		        if(xhr.readyState == 4 & xhr.status == 200) {
		            console.log(JSON.parse(xhr.responseText));
		        }
		    }
		    xhr.send();
	}
	c_btn2.addEventListener("click", f_btnClick2);
	
	const c_search = document.querySelector("#id_search");
	const c_sch = document.querySelector("#id_sch");
	const c_disp = document.querySelector("#id_disp");
	
	const f_search = () => {
	 	const xhr = new XMLHttpRequest();
	 	let schWord = c_sch.value;
	 	let url = "<%=request.getContextPath()%>/bypass/google2?schWord=" + schWord;
	    	xhr.open("get", url, true);
		    xhr.onreadystatechange = function() {
		        if(xhr.readyState == 4 & xhr.status == 200) {
		        	let recvDatas = JSON.parse(xhr.responseText).channel.item;
		       		let tblStr = "<table border=1>";
		       			tblStr += "<tr><th>순번</th><th>타이틀</th><th>링크</th><th>발생일</th></tr>"; 
		        	for(let i = 0; i < recvDatas.length; i++) {
		        		tblStr += "<tr>";
		        		tblStr += "<td>" + (i+1) + "</td>";
		        		tblStr += "<td>" + recvDatas[i].title + "</td>";
		        		tblStr += "<td>" + recvDatas[i].description + "</td>";
		        		tblStr += `<td><a href=/${recvDatas[i].link}>보기</a></td>`;
		        		tblStr += "<td>" + recvDatas[i].pubDate + "</td>";
		        		tblStr += "</tr>";
		        	}
		        	tblStr += "</table>";
		        	c_disp.innerHTML = tblStr;
		        }
		    }
		    xhr.send(); // get방식은 매개변수값 넣지 않음. 만약 넣겠다면 (null)
	}
	c_search.addEventListener("click", f_search);
</script>
</body>
</html>
