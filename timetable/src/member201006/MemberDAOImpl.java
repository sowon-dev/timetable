package member201006;

import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO{
	
	//디비연결메서드
	//자원해제메서드
	
	@Override
	public List getMemberList() {
		System.out.println("DAO: 디비연결");
		System.out.println("DAO: sql작성 & pstmt객체생성 & ?입력 & sql쿼리구문실행 & rs에 가져온 정보를 List저장");
		System.out.println("DAO: 자원해제");
		List list = new ArrayList<>();
		list.add("빽다방");
		list.add("더벤티");
		list.add("스타벅스");
		return list;
	}

}
