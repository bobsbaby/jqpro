package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVo;

/**
 * Servlet implementation class ReplyUpdate
 */
@WebServlet("/ReplyUpdate")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ReplyUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int rnum = Integer.parseInt(request.getParameter("renum"));
		String cont = request.getParameter("cont");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cont", cont);
		map.put("renum", rnum);
		
		IBoardService service = BoardServiceImpl.getInstance();
		int res = service.modifyReply(map);
		request.setAttribute("res", res);
		
		request.getRequestDispatcher("/accordion/update.jsp").forward(request, response);
	}

}
