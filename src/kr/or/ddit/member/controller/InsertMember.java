package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/InsertMember")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//입력한 모든 값을 가져온다. 
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String bir = request.getParameter("bir");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");
		String pwd = request.getParameter("pwd");
		String zip = request.getParameter("zip");
		String add1 = request.getParameter("add1");
		String add2 = request.getParameter("add2");
		
		//memberVo에 저장 
		MemberVO vo = new MemberVO();
		vo.setMem_id(id);
		vo.setMem_name(name);
		vo.setMem_bir(bir);
		vo.setMem_hp(tel);
		vo.setMem_mail(mail);
		vo.setMem_pass(pwd);
		vo.setMem_zip(zip);
		vo.setMem_add1(add1);
		vo.setMem_add2(add2);
		
		//위 내용을 beanutils를 이용하여 함축하기 
		MemberVO memVo = new MemberVO();
		
		//BeanUtils.populate(memVo, request.getParameterMap());
		
		//service 객체 얻기 
		IMemberService service = MemberServiceImpl.getInstance();
		
		//메소드 호출 - 파라미터 :vo, 결과 : string mem_id
		String mem_id =	service.insertMember(vo);
		
		
		//결과를 request에 저장 
		request.setAttribute("mem_id", mem_id);
		
		//jsp로 이동
		request.getRequestDispatcher("member/insert.jsp").forward(request, response);
	}

}
