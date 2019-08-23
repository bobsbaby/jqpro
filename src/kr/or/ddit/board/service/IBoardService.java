package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVo;

public interface IBoardService {
	
	public List<BoardVO> selectAll(); 
	public int insertBoard(BoardVO vo);
	public int deleteBoard(int seq);
	
	
	public int insertReply(ReplyVo vo);
	
	public List<ReplyVo> listReply(int seq);
}
