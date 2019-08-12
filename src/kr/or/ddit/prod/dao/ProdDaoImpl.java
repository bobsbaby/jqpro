package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVO;
/*
 *1. Mapper에 접근하기  위해서  SqlMapClient객체가 필요 - 직접 생성하지 않고 
 *      생성되어 있는 클래래에서 getter를 이용해서 가져온다  
 *2. 자신의 Dao객체를 다른 서비스에서 공유 하여 사용할 수 있도록  생성 
 *  자신의 객체를 return시켜주는 메소드 정의 
 * 
 */
public class ProdDaoImpl implements IProdDao {

	private SqlMapClient  client;
	private static IProdDao  dao;
	
	private ProdDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IProdDao getInstance(){
		if(dao == null) dao = new ProdDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<ProdVO> selectProdNames(String lprod_gu) throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("prod.selectProdNames", lprod_gu);
	}

	@Override
	public ProdVO prodDetail(String prod_id) throws SQLException {
		// TODO Auto-generated method stub
		return (ProdVO) client.queryForObject("prod.prodDetail", prod_id);
	}
}

