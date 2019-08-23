package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVo;

public interface IBoardDao {
	
	public List<BoardVO> selectAll() throws SQLException; 
	
	public int insertBoard(BoardVO vo) throws SQLException;
	
	public int deleteBoard(int seq) throws SQLException;
	
	/**
	 * @param vo
	 * @return
	 * @throws SQLException
	 * 설명 : 댓글 등록
	 */
	public int insertReply(ReplyVo vo) throws SQLException;
	
	public List<ReplyVo> listReply(int seq) throws SQLException;
}
