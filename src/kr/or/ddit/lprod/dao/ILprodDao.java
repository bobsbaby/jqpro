package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.vo.LProdVO;

public interface ILprodDao {
	public List<LProdVO> selectAllLprod() throws SQLException;
}
