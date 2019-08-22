package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private static IBoardService  service;
	private IBoardDao  dao;
	
	private BoardServiceImpl(){
		dao = BoardDaoImpl.getInstance();
	}
	public static IBoardService  getInstance(){
		if(service == null) service = new BoardServiceImpl();
		
		return service;
	}
	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO>  list = null;
		
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int insertBoard(BoardVO vo) {
		int seq = 0;
		try {
			seq = dao.insertBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seq;
	}

}
