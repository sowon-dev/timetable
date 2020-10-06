package member201006;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MemberControllerTest {

	public static void main(String[] args) {
		System.out.println("C: 주소맵핑");
		//모델2방식
		//Action action = new SelectMemberAction();
		
		//의존주입(DI)
		BeanFactory fac = new XmlBeanFactory(new FileSystemResource("member.xml"));
		//SelectMemberAction action = (SelectMemberAction) fac.getBean("action");
		//업캐스팅통한 표현이 약한 결합을 띄고있다는 것을 표현하는 것이기때문에 위 방법보다 아래 방법을 더 많이 사용한다
		Action action = (Action) fac.getBean("action"); //업캐스팅
		
		try {
			action.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("C: 페이지이동(Redirect/forward)");
		
	}//end of main()

}
