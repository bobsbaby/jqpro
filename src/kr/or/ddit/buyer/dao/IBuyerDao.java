package kr.or.ddit.buyer.dao;

import java.sql.SQLException;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IBuyerDao {
	
	public BuyerVO getInfo(String bName) throws SQLException;
	
}
