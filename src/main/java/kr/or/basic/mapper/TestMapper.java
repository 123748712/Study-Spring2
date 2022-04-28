package kr.or.basic.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


// Mybatis가 다 알아서 JDBCUtil class형식으로 만들어줌
@Mapper // 명시적으로 매퍼임을 표현해주는 게 좋음
public interface TestMapper {//인터페이스: 구현하는것의 표준(뭘 구현하던 표준만 지켜라) + 위에서 아래로(그대로 소스 줌)
	
//	@Select("select buyer_name from buyer where buyer_id = 'P10101'")
//	public String getBuyer();
	
//	@Select("select buyer_name from buyer where buyer_id = '${buyer_id}'") // 원하는 id 검색할 수 있는 기능 추가 / ${}로 매개변수 가져올 수 있음
	public String getBuyer(String buyer_id); // get 방식으로 mybatis?buyer_id= 를 이용해 가져올 수 있다. (쿼리스트링)
	
//	@Insert("insert into Simple values(1, 'name1')")
	public int insertSimple();
	
//	@Update("update Simple set sm_name='name2' where nm_id=1")
	public int updateSimple();
	
//	@Delete("delete from Simple")
	public int deleteSimple();
}
