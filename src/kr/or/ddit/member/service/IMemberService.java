package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	
	
	//1개의 데이터를 가져올 경우 member vo로 가져온다.
	//전체의 데이터를 가져올 경우 return 결과는 list로 가져온다. 
	
	public List<MemberVO> selectAll();
	
	//id 중복검사
	public String getSelectedId(String id);
	//우편번호 검색
	public List<ZipVO> getSelectedDong(String dong);
	//저장하기(가입하기)
	public String insertMember(MemberVO vo);
}
