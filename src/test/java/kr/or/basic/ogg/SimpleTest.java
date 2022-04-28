package kr.or.basic.ogg;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class) // junit5 사용설정
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
public class SimpleTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	public void myTest() throws Exception {
		assertNotNull(dataSource.getConnection()); // test 메소드 null이 아니면 성공, null이면 실패
												   // connection 객체 null 여부를 판단 (성공이면 파랑, 실패면 빨강)
		log.info("" + dataSource.getConnection());
	}
}
