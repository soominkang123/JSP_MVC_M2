package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import board.BoardDAO;
import board.BoardDTO;

// http://localhost:8181/JSP_MVC_M2/*.do
@WebServlet("*.do")
public class Board_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Board_Controller() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// client 에서 보내는 get, post 요청 모두 처리도미
		// 한글이 깨어지지 않도록 처리
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("do요청을 처리하는 controller 입니다.");
		
		// URL : http://localhost:8181/JSP_MVC_M2/my.do  //전체 서버주소
		// URI : /JSP_MVC_M2/my.do
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		//
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		System.out.println("===================");
		
		
		if (path.equals("/insertBoard.do")) {
			System.out.println("/insertBoard.do 요청");
			//로직처리
			
			// 1. 클라이언트의 넘어오는 변수가 잘 들어 오는지 확인 
			String title = request.getParameter("title");
			String write = request.getParameter("write");
			String content = request.getParameter("content");
			
			/*
			System.out.println("title : " + title);
			System.out.println("write : " + write);
			System.out.println("content : " + content);
			*/
			
			// 2. 클라이언트에서 넘어오는 변수의 값으 DTO에 Setter 주입.
			BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setWrite(write);
			dto.setContent(content);
			
			// 3. DAO 에 insertBoard ( dto )
			BoardDAO dao = new BoardDAO();
			dao.insertBoard(dto);
			
			System.out.println("DB 저장 성공");
			
		}else if (path.equals("/getBoardList.do")) {
			System.out.println("/getBoardList.do 요청");
			//로직처리
			
		}else if (path.equals("/getBoard.do")) {
			System.out.println("/getBoard.do 요청");
			//로직처리
			
		}else if (path.equals("/updateBoard.do")) {
			System.out.println("/updateBoard.do 요청");
			//로직처리
			
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("/deleteBoard.do 요청");
			//로직처리
		}
		
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
