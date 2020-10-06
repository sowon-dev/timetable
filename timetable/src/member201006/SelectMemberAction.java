package member201006;

import java.util.List;

public class SelectMemberAction implements Action{
	
	//new XmlBeanFactory()의 이중호출을 막기 위해 setter를 통해 xml주입
	private MemberDAO mdao2;
	
	public void setMdao2(MemberDAO mdao) {
		this.mdao2 = mdao;
		System.out.println("M : xml 파일을 사용한 주입(setter)");
	}
	
	@Override
	public void execute() throws Exception {
		// Action 인퍼테이스를 사용하여 다형성구현
		System.out.println("M: SelectMemberAction 클래스의 execute메서드실행");
		
		/* 예를 들어
		 * 1.파라미터 저장하기
		 * 2.세션아이디체크
		*/
		
		//모델2방식
		//3.DB접근 -> DAO객체 생성 
		//MemberDAO mdao = new MemberDAOImpl();
		//List list = mdao.getMemberList();
		//System.out.println("M: List데이터저장 ["+ list+"]");
		
		//의존주입(DI)방식
		//3.DB접근 -> DAO객체 생성 
		//BeanFactory fac = new XmlBeanFactory(new FileSystemResource("member.xml"));
		//MemberDAO mdao = (MemberDAO) fac.getBean("mdao");
		//List list = mdao.getMemberList();
		//System.out.println("M: List데이터저장 ["+ list+"]");
		
		//3. 생성자이용한 DI방식
		List list = mdao2.getMemberList();
		System.out.println("M: List데이터저장 ["+ list+"]");

		//4.페이지이동
		System.out.println("M: 페이지이동(View)");
	}
}
