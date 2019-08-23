package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class BoardDelete
 */
@WebServlet("/BoardDelete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//삭제할 번호를 전송 받는다.
		int delseq =  Integer.parseInt(request.getParameter("seq"));
		
		IBoardService service = BoardServiceImpl.getInstance();
		int res = service.deleteBoard(delseq);
		
		request.setAttribute("res", res);
		request.getRequestDispatcher("accordion/delete.jsp").forward(request, response);
		
		
	}

	

}
