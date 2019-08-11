package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

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
	public List<BuyerVO> getInfo() throws SQLException {
	
		return client.queryForList("buyer.selectId");
	}

}
