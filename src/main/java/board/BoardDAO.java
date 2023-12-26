package board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class BoardDAO {
	// DAO : DataBase 의 Board 접근 하는 객체 : SQL 쿼리
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	//sql 쿼리를 상수로 지정함.
	// insert 쿼리
	private final String BOARD_INSERT = 
			"insert into board (seq, title, write, content) "
	        + "values (( select nvl (max(seq),0) + 1 from board ) , ? , ? , ? )";
	
	// DB의 Board 테이블의 모든 레코드를 출력하는 쿼리
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	
	

	//insertBoard(BoardDTO dto) 메소드 : 
	public void insertBoard (BoardDTO dto) {
		System.out.println("insertBoard 기능 처리 =");
		
		try {
			//conn, pstmt 객체 활성화
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT); 
			
			//pstmt 객체의 ? 변수의 값 할당
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWrite());
			pstmt.setString(3, dto.getContent());
			
			// pstmt 를 실행해서 DB에 저장
			pstmt.executeUpdate();
			
			System.out.println("board 테이블에 값이 잘 insert 되었습니다.");
					
			
		}catch (Exception e) {
			System.out.println("board 테이블에 값이 insert에 실패 했습니다.");
			e.printStackTrace();
			

		} finally {
			//사용한 객체 제거
			JDBCUtil.close(pstmt, conn);
		}
		
		
		
	}
	
	// Board 테이블의 전체 레코드를 출력하는 메소드 --중요
	// DB의 레코드 하나를 BoardDTO에 담는다. 각각의 BoardDTO 를 ArrayList 에 담아서 리턴. 
	// rs , pstmt, conn
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		List<BoardDTO> boardList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();  // conn 객체 활성화 : Oracle , XE , HR12 , 1234
			pstmt = conn.prepareStatement(BOARD_LIST);
			
			// pstmt 를 실행후 rs 에 레코드를 저장 
			rs = pstmt.executeQuery();
			
			System.out.println("DB Select 성공");
			
			
		}catch (Exception e) {
			System.out.println("DB Select 실패");
			e.printStackTrace();   // 실패 할 경우 콘솔에 오류 정보 출력.
			
		}finally {
			// 사용한 객체 반납 : rs , pstmt, conn
			JDBCUtil.close(rs, pstmt, conn);
		  
			
		}
		
		
		
		return boardList ;		
		
	}
	
}
