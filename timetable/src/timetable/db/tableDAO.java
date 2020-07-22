package timetable.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tableDAO {

	//1. DB변수 생성 : 일부러 멤버변수로 선언함. 메서드에서 멤버변수 호출해서 사용할 예정	
		Connection con = null;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//2. DB연결 메서드 생성: 리턴해도되고 안해도 됨 
		private Connection getCon(){
			//2-1. 드라이브로드 & DB연결
			final String DRIVER = "com.mysql.jdbc.Driver";
			final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
			final String DBID = "root";
			final String DBPW = "1234";
			
			//2-2. Class.forName(DRIVER);면 에러메세지가 뜨는데 거기서 try catch구문의 해결방법을 누른다
			try {
				Class.forName(DRIVER);
				System.out.println("드라이버 로드 성공!");
				con = DriverManager.getConnection(DBURL, DBID, DBPW);
				//getConnection() 에러메세지가 뜨는데 거기서 try catch구문의 해결방법을 누른다
				System.out.println("DB 연결 성공!" + con);
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로드 실패!");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DB 연결 실패!");
				e.printStackTrace();
			}
			System.out.println(con);
			return con;
			
		}

		//4. 자원해제 메서드 구현
		public void closeDB(){
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
}
