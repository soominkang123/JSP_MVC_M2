<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- java util.* : List, ArrayList -->
<%@ page import="java.util.*"%>
<%@ page import="board.BoardDTO"%>

<%
// Session 변수에 저장된 ArrayList를 가지고 온다.
List<BoardDTO> boardList = new ArrayList<>();

// 세션에서 가져온 값은 Object 타입이어서 ( List 타입으로 변환 )
try {
	boardList = (List) session.getAttribute("boardList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>글 목록</h1>
		<hr>

		<table border="1" width="700px">
			<tr>
				<th bgcolor="orange" width="100px">번호</th>
				<th bgcolor="orange" width="100px">제목</th>
				<th bgcolor="orange" width="100px">작성자</th>
				<th bgcolor="orange" width="100px">등록일</th>
				<th bgcolor="orange" width="100px">조회수</th>
			</tr>

			<!-- ArrayList의 BoardDTO를 끄집어내서 출력 : loop 돌리면서 출력 -->
			<%
			for (BoardDTO k : boardList) {
			%>
			<tr>
				<td align="center"><%=k.getSeq()%></td>
				<!-- 제목에 링크를 건다 : 글 상세 내용을 볼수 있도록 -->

				<td><a href="getBoard.do?seq=<%=k.getSeq()%>"><%=k.getTitle()%>
				</a></td>

				<td><%=k.getWrite()%></td>
				<td><%=k.getRegdate()%></td>
				<td><%=k.getCnt()%></td>
			</tr>


			<%
			}
			// 모두 사용됨 : boardList
			// 세년 변수의 값을 제거 : 서버의 메모리에서 세션 변수 boardList에 저장한 값을 제거
			//session.removeAttribute("boardList");

			} catch (Exception e) {
			response.sendRedirect("getBoardList.do");
			}
			%>

			<!-- http://localhost:8181/JSP_MVC_M2/getBoardList.do ==> .jsp 로변경 로 출력
         바로입력시 오류발생     -->
		</table>

		<br> <a href="http://localhost:8181/JSP_MVC_M2"> 홈으로 </a>
		<p /> <a href= "insertBoard.jsp"> 새 글쓰기</a>
		
	</center>

</body>
</html>