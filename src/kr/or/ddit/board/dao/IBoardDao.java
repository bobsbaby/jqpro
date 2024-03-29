package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	
	/**
	 * @param renum
	 * @return
	 * 댓글 삭제 
	 */
	
	public int deleteReply(int renum) throws SQLException;
	
	
	/**
	 * @param map
	 * @return
	 * content와 renum을 받아온다 
	 * 댓글 수정
	 */
	public int modifyReply(Map<String, Object> map) throws SQLException;
}
