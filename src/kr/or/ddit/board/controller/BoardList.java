package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//service 객체 얻기
		IBoardService  service = BoardServiceImpl.getInstance();
		
		//메소드 호출 - 결과 List<BoardVO>
		List<BoardVO>  list = service.selectAll();
		
		//request.에 결과 저장 
		request.setAttribute("list", list);
		
		//jsp로 forword
		RequestDispatcher  disp = 
				request.getRequestDispatcher("accordion/list.jsp");
		
		disp.forward(request, response);
		
		
		
	}

}
