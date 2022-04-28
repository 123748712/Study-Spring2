package kr.or.basic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ChatHandler extends TextWebSocketHandler implements WebSocketConfigurer {
	// 접속한 session을 저장하기 위해 static List 선언
	private static List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	
	@Override // 커넥션이 연결된 다음 실행될 메소드
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("## 누군가 접속");
		list.add(session); // 접속되면 list에 담음
	}

	@Override // 커넥션 연결된 다음 안에서 메세지를 주고받을때 실행될 메소드
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String uMsg = message.getPayload(); // 실제 메세지 내용
		for (WebSocketSession webSocketSession : list) { // 메세지가 오면 for문을 통해 접속한 session(list에 저장된 session)에 전부 보냄
			webSocketSession.sendMessage(new TextMessage(session.getAcceptedProtocol() + uMsg));
		}
	}
	
	@Override // 커넥션이 종료된 다음 실행될 메소드
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("## 누군가 떠남");
		list.remove(session); // 종료하면 list에서 삭제
	}
	
	// WebSocketConfigurer로 인해 설정해야함
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(this, "/ws-chat").setAllowedOrigins("*"); // path와 동일하게 설정
	}

}