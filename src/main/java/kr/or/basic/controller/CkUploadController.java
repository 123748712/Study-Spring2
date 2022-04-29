package kr.or.basic.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CkUploadController {

	@Autowired
	private String uploadPath; // servlet-context.xml bean과 연결
	
	@PostMapping(value="/ckUpload",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String ckUpload2(HttpServletRequest req, HttpServletResponse res, MultipartFile upload) throws Exception {
		
		log.info(upload.getOriginalFilename());
		
		UUID uid = UUID.randomUUID();
				
		String fileName = upload.getOriginalFilename();
		log.info("filename >> " + fileName);
		
		String ckUploadPath = uploadPath + "/" + uid + "_" + fileName;
		log.info("ckUploadPath >> " + ckUploadPath);
		
		// 이 구간에서 시간이 지체되어 업로드가 정상적으로 이루어지지 않음. 이클립스 버퍼링도 문제
	    upload.transferTo(new File(ckUploadPath)); // 파일 업로드 끝
		
	    // ckeditor에 파일 경로 알림
		String callback = req.getParameter("CKEditorFuncNum"); // filebrowserUploadMethod가 없으면 null return
		log.info("callback >> " + callback);
		String fileUrl = req.getContextPath() + "/ckUpload/" + uid + "_" + fileName;
		log.info("fileUrl >> " + fileUrl);
        /* CKEditor가 원하는 스크립트 문자열을 리턴(아님말공)  */
		String scriptStr = "<script type='text/javascript'>"
				+ "window.parent.CKEDITOR.tools.callFunction("
				+ callback + ",'" + fileUrl+"','이미지 업')"
				+ "</script>";
		
		return scriptStr;
	}
}