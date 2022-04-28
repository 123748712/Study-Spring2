<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chat</title>
<style>
	#id_chatwin {
		width:300px;
		height:300px;
		background-color:black;
		border:1px solid pink;
		color:yellow;
		text-align: right;
	}
</style>
</head>
<body>
	<h1>채팅</h1>
	<div>
		<div id="id_chatwin"></div>
		<input type="text" id="id_message" /> 
		<input type="button" id="id_send" value="전송"> <br> 
		<input type="text" id="id_my" value="" placeholder="닉네임" /> 
		<input type="button" id="id_con" value="연결">
		<input type="button" id="id_exit" value="나가기">
	</div>
</body>
<script>
	// 클라이언트쪽 기본 틀, 고급 API도 많지만 온전히 제대로 하려면 message 서버도 추가적으로 필요함
//     const c_alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
// 	const f_ranID=()=>{
// 		let ranID ="";
// 		for(let i=1; i< (Math.ceil(Math.random()*5)+4); i++){
// 			ranID += c_alpha[Math.floor(Math.random()*c_alpha.length)];
// 		}	
// 		return ranID;
// 	}

// 	let myId = f_ranID();
	let myId = "";
	let webSocket = null;
	const c_chatWin = document.querySelector("#id_chatwin");
	const c_message = document.querySelector("#id_message");		
	const c_send = document.querySelector("#id_send");
	const c_exit = document.querySelector("#id_exit");
	const c_nickName = document.querySelector("#id_my");
	const c_join = document.querySelector("#id_con");
	
	c_join.addEventListener("click", () => {
		if(c_nickName.value == "") {
			alert("닉네임 미작성");
		} else {
			connect();
		}
	})

	c_send.addEventListener("click", ()=>{
		send();
	});
	// 연결 끊깅
	c_exit.addEventListener("click", function () {
		disconnect();
	});

	//연결
// 	connect();
	
	function connect() {
		myId = c_nickName.value;
		if(!webSocket) {
		webSocket = new WebSocket("ws://localhost:8405/basic/ws-chat"); // End Point (localhost 에 IP주소를 넣으면 다른 컴퓨터와 채팅 가능)
		//이벤트에 이벤트핸들러 등록
		webSocket.onopen = onOpen; // 소켓이 연결될때
		webSocket.onmessage = onMessage; // 서버에서 메세지가 올 때
		}
	}

	//연결 시
	function onOpen() {
		webSocket.send(myId + "님 입장.");
	} 
	function send() {
		let msg = c_message.value;
		webSocket.send(myId + ":" + msg);
		
		c_message.value = "";
	}
	function onMessage() {
		let data = event.data; // 서버에서 보내준 데이터는 event.data에 담겨옴
		c_chatWin.setAttribute('style', 'text-align: left');
		c_chatWin.innerHTML = c_chatWin.innerHTML + "<br/>" + data;
	}
	function disconnect() {
		webSocket.send(myId + "님 퇴장");
		webSocket.close();
		webSocket = null;
	}
</script>
</body>
</html>