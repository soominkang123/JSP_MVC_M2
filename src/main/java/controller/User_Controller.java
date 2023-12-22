package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.act")
public class User_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public User_Controller() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("act요청을 처리하는 control입니다");
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		System.out.println("================");
		
		
		if(path.equals("/insertUser.act")) {
			System.out.println("/insertUser.act 요청");
			
		}else if (path.equals("/updateUsers.act")) {
			System.out.println("/updateUsers.act 요청");
			
		}else if (path.equals("/deleteUsers.act")) {
			System.out.println("/deleteUsers.act 요청");
			
		}else if (path.equals("/getUsers.act")) {
			System.out.println("/getUsers.act 요청");
			
		}else if (path.equals("/deleteUsers.act")) {
			System.out.println("/deleteUsers.act 요청");
			
		}else if (path.equals("/getUsersList.act")) {
			System.out.println("/getUsersList.act 요청");
			
		}else if (path.equals("/login.act")) {
			System.out.println("/login.act 요청");
		}
		//http://localhost:8181/JSP_MVC_M2/*.act
		
		//if else if 문으로 각 조건에 맞는 요청을 처리하는 블락
		//"/insertUser.act"
		//"/updateUsers.act"
		//"/deleteUsers.act"
		//"/getUsers.act"
		//"/getUsersList.act"
		//"/login.act"
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
