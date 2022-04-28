package kr.or.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter // lombok.jar 를 사용해 자동으로 필드값의 setter를 만들어줌
@Getter // getter을 만들어줌
@ToString // toString를 만들어줌
@NoArgsConstructor // 아무것도 없는 생성자
//@AllArgsConstructor // 모든 필드값을 갖고 있는 생성자
//@Data
// 그러나 Setter, Getter는 필수로 사용하면 좋고, ToString, @NoArgsConstructor는 선택사항, AllArgsConstructor, Data는 사용을 권장하지 않음.
public class JustClass {
	private String a;
	private String b;
	private String c;
	private String d;
}
