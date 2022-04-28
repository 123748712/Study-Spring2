package kr.or.basic.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Soo {
	private String nm_name;
	private String nm_special;
	private String nm_age;
	private List<MultipartFile> files; // file이 여러개 담겨야 하기 때문에 List에 담아준다.

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public String getNm_name() {
		System.out.println(nm_name);
		return nm_name;
	}

	public void setNm_name(String nm_name) {
		this.nm_name = nm_name;
	}

	public String getNm_special() {
		return nm_special;
	}

	public void setNm_special(String nm_special) {
		System.out.println(nm_special);
		this.nm_special = nm_special;
	}

	public String getNm_age() {
		return nm_age;
	}

	public void setNm_age(String nm_age) {
		System.out.println(nm_age);
		this.nm_age = nm_age;
	}

}
