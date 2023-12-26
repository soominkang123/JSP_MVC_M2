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
	
	// DB의 Board 테이블의 모든 레코드를 출력하는 쿼리 : 레코드가 여러개 : dto ==> ArrayList 리턴
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	// DB의 Board 테이블의 글 상세 조회 : 레코드 1개 <== dto
	private final String BOARD_GET = "select * from board where seq = ?" ;
	
	
	

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
		// 중요 : ArrayList 는 While 블락 밖에서 선언
		//       ArrayList에 저장되는 Board 선언은 BoardDTO 를 While 블락 내부에서 선언
		
		try {
			conn = JDBCUtil.getConnection();  // conn 객체 활성화 : Oracle , XE , HR12 , 1234
			pstmt = conn.prepareStatement(BOARD_LIST);
			
			// pstmt 를 실행후 rs 에 레코드를 저장 
			rs = pstmt.executeQuery();
			
			// System.out.println("DB Select 성공");
			
			// rs의 각 레코드를 BoardDTO에 저장 ==> 각 각의 DTO를 ArrayList 에 저장
			  // if , do ~ while <==> while
			  // rs.next() : 다음 레코드가 존재하면 true , 커서가 다음 레코드로 이동
			
			
			while (rs.next()) {
				// BoardDTO 객체 생성 
				
				BoardDTO board = new BoardDTO();   // 루프 블락 내에 선언 
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWrite(rs.getString("WRITE"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("cnt"));
				
				//boardList : ArrayList의 add 메소드를 사용해서 boardDTO를 저장함.
				boardList.add(board);
										
			}
			
			
		}catch (Exception e) {
			System.out.println("DB Select 실패");
			e.printStackTrace();   // 실패 할 경우 콘솔에 오류 정보 출력.
			
		}finally {
			// 사용한 객체 반납 : rs , pstmt, conn
			JDBCUtil.close(rs, pstmt, conn);
		  			
		}
					
		return boardList ;		
		
	}
	
	// 글 상세 조회 : getBoard(dto) 
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("getBoard 메소드 호출 성공");
		BoardDTO board = new BoardDTO();
		
		try {
			conn = JDBCUtil.getConnection();
			//BOARD_GET = "select * from board where seq = ?"
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, dto.getSeq());
			
			// rs : 레코드 1개
			rs = pstmt.executeQuery();
			
			//rs의 값이 존재할때
			while ( rs.next()) {
				
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWrite(rs.getString("WRITE"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
				System.out.println("RS 의 레코드를 dto 저장 성공");
												
			}
			
		}catch(Exception e) {
			    System.out.println("글 상세 조회 실패");
			    e.printStackTrace();
			    
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
			
		}
		
		
		return board;
	}
	
	
	
	
	
	
}
