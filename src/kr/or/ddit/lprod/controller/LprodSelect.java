package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LProdVO;

@WebServlet("/LprodSelect")
public class LprodSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LprodSelect() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ILprodService service = LprodServiceImpl.getInstance();
		List<LProdVO> list;
		list = service.selectAllLprod();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/0809/lprodList.jsp").forward(request, response);
		
	}

}
