package Member2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;

public class Member2DAO {
       
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertMember2(Member2DTO dto) {
		System.out.println("insertMember2 가능처리");
		
	} 
		
	

}
