package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdServlet
 */
@WebServlet("/ProdServlet")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//option에 들어갈 prod의 id와 name가져오기 
		//lprod_gu값을 가져온다
		
		String lpgu = request.getParameter("lprod_gu");
		
		IProdService  service = ProdServiceImpl.getInstance();
		
		List<ProdVO>  list = service.selectProdNames(lpgu);
		
		request.setAttribute("list", list);
		
		RequestDispatcher  disp = 
				request.getRequestDispatcher("0812/prodNames.jsp");
		
		disp.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String  prid =  request.getParameter("prod_id");
		
		IProdService  service  = ProdServiceImpl.getInstance();
		
		ProdVO  vo = service.prodDetail(prid);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher  disp =
				request.getRequestDispatcher("0812/prodDetail.jsp");
		
		disp.forward(request, response);
		
	}

}










