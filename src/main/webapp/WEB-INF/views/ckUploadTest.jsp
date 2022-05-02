<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js"></script>
<script>
</script>
</head>
<body>
	<textarea name="nm_ta" id="id_ta"></textarea>
	<input type="button"value="CKEditor값가져오기" id="getCK">
	<div id="id_disp"></div>
<script>
	CKEDITOR.replace("nm_ta",{
		 enterMode : CKEDITOR.ENTER_BR,
		 filebrowserUploadMethod : "form",  // 필수 코드
		 filebrowserUploadUrl: "<%=request.getContextPath()%>/ckUpload"
	})
	const c_getCK = document.querySelector("#getCK");
	const c_disp = document.querySelector("#id_disp");
	const f_click = function() {
		const c_ifrm = document.querySelector("iframe");
		console.log(c_ifrm.contentWindow.document.body.innerHTML);
		console.log(c_ifrm.contentDocument.body.innerHTML);
		
		// 제공되는 API
		console.log(CKEDITOR.instances.id_ta.getData());
		CKEDITOR.instances.id_ta.setData('<h1>aaa</h1>');
	}
	
	c_getCK.onclick = f_click;
</script>
</body>
</html>