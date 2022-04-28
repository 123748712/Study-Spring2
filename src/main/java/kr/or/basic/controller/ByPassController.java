package kr.or.basic.controller;


import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Controller
@RequestMapping("/bypass")
public class ByPassController {
	
	// 서버 우회, 받은대로 문자열 되돌려줌
	@GetMapping("/googleNews")
	@ResponseBody
	public String getGoogleNews(String schWord) throws Exception {
//		String url = "https://www.flickr.com/services/feeds/photos_public.gne?tags=blackpink&format=json";
		String url = "https://news.google.com/rss/search?q=" + schWord + "&hl=ko&gl=KR&ceid=KR:ko";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet getRequest = new HttpGet(url);
		
		CloseableHttpResponse response = httpClient.execute(getRequest);
		
		String json = EntityUtils.toString(response.getEntity(),StandardCharsets.UTF_8);
				
        httpClient.close();
		return json;
	}
	
	@GetMapping(value="/google",produces = "application/xml;charset=utf-8")
	@ResponseBody
	public Document getGoogleNews1() throws Exception {
		String url = "https://news.google.com/rss/search?q=blackpink&hl=en-US&gl=US&ceid=US:en";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(url);
		
		CloseableHttpResponse response = httpClient.execute(getRequest);
		//response.setHeader("Content-Type", "application/xml");
		
		Document doc = null;
		DocumentBuilderFactory docBuilder = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = docBuilder.newDocumentBuilder();
		
		doc = builder.parse(response.getEntity().getContent());
		

		return doc;
	}
	
	// xml을 JSON으로 서버쪽에서 변환(JACKSON 라이브러리)
	@GetMapping(value="/google2",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getGoogleNews2(String schWord) throws Exception { // url로 넘어온 값의 변수명만 같으면 자동으로 받아와짐
		String url = "https://news.google.com/rss/search?q=" + schWord + "&hl=ko&gl=KR&ceid=KR:ko";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(url);
		
		CloseableHttpResponse response = httpClient.execute(getRequest);
		//response.setHeader("Content-Type", "application/xml");
		
		XmlMapper xmlMapper = new XmlMapper();
		JsonNode node = xmlMapper.readTree(response.getEntity().getContent());
		

		ObjectMapper jsonMapper = new ObjectMapper();
		
		httpClient.close();
		return jsonMapper.writeValueAsString(node);  
	}
	
	@GetMapping("/utube")
	@ResponseBody
	public String getUtube(String schWord) throws Exception {
		String url = "https://www.youtube.com/results?search_query=" + schWord;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet getRequest = new HttpGet(url);
		
		CloseableHttpResponse response = httpClient.execute(getRequest);
		
		String json = EntityUtils.toString(response.getEntity(),StandardCharsets.UTF_8);
				
        httpClient.close();
		return json;
	}
	
	@GetMapping(value="/utubeTitle",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getUtubeTitle(String schCode) throws Exception {
		String url = "https://www.youtube.com/watch?v=" + schCode;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet getRequest = new HttpGet(url);
		
		CloseableHttpResponse response = httpClient.execute(getRequest);
		
		String json = EntityUtils.toString(response.getEntity(),StandardCharsets.UTF_8);
		
		httpClient.close();
		return json;
	}
}
