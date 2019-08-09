package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

//web servlet 이름 

@WebServlet("/MemberSelect")
public class MemberSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MemberSelect() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /*
     *  전송하는 데이터가  없을 경우 get방식 사용 
     * 
     */
    /**
     * service 객체가 필요 - 직접 생성하지 않고 service 클래스에서 getter를 이용하여 가져온다. 
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 요청시 전송되는 데이터를 받아온다. 
    	//DB를 이용한s CRUD를 처리한다. 
    	//처리한 결과를 클라이언트로 응답한다. 
    	//응답타입은 json object 배열로 한다. 
    	
    	//service를 가져온다. 
    	IMemberService service = MemberServiceImpl.getInstance();
    	
    	List<MemberVO> list;
		
			list = service.selectAll();
		
    	
    	//service에서 수행한 결과값을 value에 준다. key는 memberlist.jsp에서 사용
    	request.setAttribute("list", list);
	
    	//db에 있는 파일을 jason 파일로 가져온다. 
    	//crud의 결과 list를 view 페이지로 보내야 한다. 
    	//보내는 방법  : redirect(페이지가 넘어갈때 데이터도 같이 넘겨 값이 사라진다), forward(페이지가 넘어갈때 데이터를 가지고 있어 데이터의 재사용이 가능)
    	//foward : 서버 내에서 페이지를 이동시켜, request 내에 있는 데이터를  controller에서 가지고 있던 데이터를 view페이지에서도 사용 가능하다. respons, request를 공유하여 (에 있는 데이터를 공유해서) 사용 가능 
    	//redirect : controller에서 요청 페이지로 이동 (응답이 1번 진행됨), 서버에서 view로 재 요청함 / 응답이 1번 빈행되어 controller에서 request와 response 에 저장한 데이터를 재 사용할 수 없게 된다. 
    	//view 페이지에서 response와 request를 재 생산한다.
    	
    	//결과값 list를 request에 저장 후 forward 시킨다. 
    	request.getRequestDispatcher("/0809/memberList.jsp").forward(request, response);
	}
}
