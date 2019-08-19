package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class DongSelect
 */
@WebServlet("/DongSelect")
public class DongSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DongSelect() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//입력한 dong을 전달받는다. 
		String dongSec = request.getParameter("dong");
		//service 객체 얻기 
		IMemberService service = MemberServiceImpl.getInstance();
		//메소드 호출 - 결과값 받기 - list
		List<ZipVO> list =  service.getSelectedDong(dongSec);
		
		//결과값을 request에 저장 
		request.setAttribute("list", list);
		
		//jsp(zipSearch.jsp)로 이동 
		request.getRequestDispatcher("member/zipSearch.jsp").forward(request, response);
		
		
	}

}
