package kr.or.basic.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.basic.domain.JungSun;
import kr.or.basic.domain.JustClass;
import kr.or.basic.domain.Mamamoo;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j // log4j 를 확장시킨 어노테이션
@PropertySource("classpath:config/properties/db.properties") // properties 파일 읽어오기
// @PropertySources({"classpath:config/properties/db.properties", "aaa"}) 배열로 가져올 수 있다.
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	@Qualifier("jungsun") // Mamamoo interface를 구현한게 jungsun, jungsun2 두개가 있기 때문에 지정을 해주어야 한다.
	private Mamamoo aaa; // 변수명이 id와 같으면 자동으로 연결됨
	
	@Value("${db.driverClassName}") // db.properties 값을 가져올 수 있다.
	private String driverName;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @Value("bbb") String aaa) { // 매개변수 값을 줄때도 사용, @Value(123) int aaa
		
		log.info("driverClassName >> " + driverName);
		log.info("확인 >> " + aaa);
		
		// logger 필드를 만들지 않아도 slf4j 를 사용해 log 키워드를 사용할 수 있다.
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error"); // log4j.xml level을 변경하면 그 이상부터 메세지 출력
		
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "ckUploadTest";
	}
	
}
