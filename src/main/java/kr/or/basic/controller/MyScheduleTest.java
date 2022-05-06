package kr.or.basic.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyScheduleTest {

	// 리눅스 cron과 달리 초단위 설정 가능
	// 외우지 않고 구글 검색으로 빠르게 정보 찾기 가능
	// 실제로는 이미 많은 것들이 스케줄링 되어있어 현업에서 그리 활용도가 높지 않음
	@Scheduled(cron = "0/10 * * * * *")
	public void checkTask() {
		log.warn("10초마다 실행");
	}
}