package timetable.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import timetable.Tablebean;

public class tableDAO {

	//1. DB���� ���� : �Ϻη� ��������� ������. �޼��忡�� ������� ȣ���ؼ� ����� ����	
	Connection con = null;
	String sql = "";
	PreparedStatement pstmt = null;
	ResultSet rs = null;

		// DB���� �޼��� ����
		private Connection getCon(){
			//2-1. ����̺�ε� & DB����
			final String DRIVER = "com.mysql.jdbc.Driver";
			final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
			final String DBID = "root";
			final String DBPW = "1234";
			
			//2-2. Class.forName(DRIVER);�� �����޼����� �ߴµ� �ű⼭ try catch������ �ذ����� ������
			System.out.println("����̺꿬�����");
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
			return con;
		}

		//�ڿ����� �޼��� ����
		public void closeDB(){
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		//���̺� �����ͻѷ��ִ� �޼���
		public Tablebean getData(){
			Tablebean tb = null;
		
			try {
				con= getCon();
				sql = "select * from timetable";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					tb = new Tablebean();
					tb.setMon_dd(rs.getDate("mon_dd"));
					tb.setSubam(rs.getString("subam"));
					tb.setSubpm(rs.getString("subpm"));
					tb.setWeekday(rs.getString("weekday"));
					System.out.println(tb);
				}
			} catch (SQLException e) {
				System.out.println("sql ����");
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return tb;	
		}
		
}
