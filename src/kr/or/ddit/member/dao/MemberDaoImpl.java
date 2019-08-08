package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sun.security.ntlm.Client;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import sun.security.jca.GetInstance;

/*
 	Mapper에 접근하기 위해서 SqlMapClient 객체가 필요 - 직접 생성하지 않고 생성되어있는 클래스에서 getter를 이용하여 가져온다. 
 	자신의 dao 객체를 다른 서비스에서 공유하여 사용할 수 있도록 생성 
 	자식의 객체를 return시켜주는 메서드 정의
 	
 */

public class MemberDaoImpl implements IMemberDao {
	private SqlMapClient client;
	private static IMemberDao dao;
	
	private MemberDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	//singleton
	public static IMemberDao getInstance() {
		if(dao==null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public List<MemberVO> selectAll() throws SQLException {
		
		return client.queryForList("member.selectAll");
	}

}
