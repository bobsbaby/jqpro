package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LProdVO;

public class LprodServiceImpl implements ILprodService {
	
	private ILprodDao dao;
	private static ILprodService service;
	
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getInstance();
	}
	
	public static ILprodService getInstance() {
		if(service==null) {
			service = new LprodServiceImpl();
		}
		return service;
	}

	@Override
	public List<LProdVO> selectAllLprod() {
		List<LProdVO> list = null;
		
		try {
			list = dao.selectAllLprod();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
