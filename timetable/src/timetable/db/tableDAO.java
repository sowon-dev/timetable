package timetable.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tableDAO {

	//1. DB���� ���� : �Ϻη� ��������� ������. �޼��忡�� ������� ȣ���ؼ� ����� ����	
		Connection con = null;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//2. DB���� �޼��� ����: �����ص��ǰ� ���ص� �� 
		private Connection getCon(){
			//2-1. ����̺�ε� & DB����
			final String DRIVER = "com.mysql.jdbc.Driver";
			final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
			final String DBID = "root";
			final String DBPW = "1234";
			
			//2-2. Class.forName(DRIVER);�� �����޼����� �ߴµ� �ű⼭ try catch������ �ذ����� ������
			try {
				Class.forName(DRIVER);
				System.out.println("����̹� �ε� ����!");
				con = DriverManager.getConnection(DBURL, DBID, DBPW);
				//getConnection() �����޼����� �ߴµ� �ű⼭ try catch������ �ذ����� ������
				System.out.println("DB ���� ����!" + con);
			} catch (ClassNotFoundException e) {
				System.out.println("����̹� �ε� ����!");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DB ���� ����!");
				e.printStackTrace();
			}
			System.out.println(con);
			return con;
			
		}

		//4. �ڿ����� �޼��� ����
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
