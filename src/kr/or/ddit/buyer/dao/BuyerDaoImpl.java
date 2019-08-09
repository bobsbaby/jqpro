package kr.or.ddit.buyer.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BuyerDaoImpl implements IBuyerDao {
	private SqlMapClient client;
	private static IBuyerDao dao;
	
	private BuyerDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IBuyerDao getInstance() {
		if(dao == null) {
			dao = new BuyerDaoImpl();
		}
		return dao;
	}
	
	@Override
	public BuyerVO getInfo(String bName) throws SQLException {
		BuyerVO buyerVO = null;
		buyerVO = (BuyerVO) client.queryForObject("buyer.selectId", bName);
		
		return buyerVO;
	}

}
