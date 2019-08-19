package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberIdCheck
 */
@WebServlet("/MemberIdCheck")
public class MemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberIdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력받은 id값을 전달 받는다. 
		
		
		String inputId = request.getParameter("id");
		
		//service 객체
		IMemberService service = MemberServiceImpl.getInstance();
		
		//method 호출 (입력받은 id를 파라미터로 받아서 db에 해당 아이디가 있는지 검사) - 결과값 : null이거나 기존의 id값이다. 
		String resId = service.getSelectedId(inputId);
		
		//jsp로 보내서 json데이터 생성 (보내야할 데이터가 여러개일 경우에는 map에 저장해서 map을 보내면 된다. 
//		request.setAttribute("inputId",inputId);
//		request.setAttribute("resId",resId);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("inputId", inputId);
		map.put("resId",resId);
		
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("member/checkId.jsp").forward(request, response);
		
		
	}


}
