package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVo;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDaoImpl  implements IBoardDao{
    private SqlMapClient  client;
    private static IBoardDao  dao;
    
    private BoardDaoImpl(){
    	client = SqlMapClientFactory.getSqlMapClient();
    }
	public static IBoardDao  getInstance(){
		if(dao == null) dao = new BoardDaoImpl();
		
		return dao;
	}
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		return client.queryForList("board.selectAll");
	}
	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		return (int) client.insert("board.insertBoard", vo);
	}
	@Override
	public int deleteBoard(int seq) throws SQLException {
		
		return client.delete("board.deleteBoard", seq);
	}
	@Override
	public int insertReply(ReplyVo vo) throws SQLException {
		return (int) client.insert("board.insertReply", vo);
	}
	@Override
	public List<ReplyVo> listReply(int seq) throws SQLException {
		return client.queryForList("board.listReply", seq);
	}
	@Override
	public int deleteReply(int renum) throws SQLException {
		return client.delete("board.deleteReply", renum);
	}
	@Override
	public int modifyReply(Map<String, Object> map) throws SQLException {
		return client.update("board.modifyReply", map);
	}
}
