package common;

import java.sql.*;

public class JDBCUtil {

	 // DataBase 연결 ( Connection ) 객체 : Oracle
	
		// 기본 생성자
		public JDBCUtil () {
			System.out.println(" JDBC 호출 성공 ");
		}
		
		// static 메소드 : 객체 생성 없이 클래스 이름으로 호출
		public static Connection getConnection () {
			Connection conn = null;
			
			//오라클 DB : XE , C##HR, 1234, <== 연결하는 구문 생성
			String driver = "oracle.jdbc.driver.OracleDriver"; 
		    String url = "jdbc:oracle:thin:@localhost:1521:XE";
		     
		     
		     try{
		    	
		    	 Class.forName(driver);  
		         conn = DriverManager.getConnection(url,"C##HR", "1234");
		    	// System.out.println("DB 연결이 성공 했습니다.");			 
		    	 
		     }catch (Exception e) {
		    	 // catch 블락 : try 블락의 오류가 있을때 만 작동됨
		    	 
		    	 System.out.println("DB 연결이 실패 했습니다. ");
		    	
		         // DB연결이 실패시 오류난 정보를 콘솔에 출력
		         e.printStackTrace();    	 
		     }
			return conn;
		}
		
		// 객체 반납 메소드
		public static void close(PreparedStatement pstmt, Connection conn) {
			if (pstmt != null) {
				try {
					pstmt.close();
					System.out.println(" pstmt 가 잘 제거 되었습니다. ");
				}catch(Exception e) {
					System.out.println(" pstmt 가 잘 제거중 오류 발생 했습니다. ");
				}
			}
			if (conn != null) {
				try {
					conn.close();
					System.out.println( "conn이 잘 제거되었습니다.");
				}catch (Exception e) {
					System.out.println( "conn 제거중 오류 발생됨. ");
				}
			}
		}
		
}
