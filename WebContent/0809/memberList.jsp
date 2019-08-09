<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%-- for문을 돌면서 list에 있는 값을 가지고 온다. --%>
[


<% 
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
	 for(int i = 0; i < list.size(); i++){		//for(MemberVO vo : list)
		 MemberVO vo = list.get(i);
	 //java 안에서 출력을 요청하는 석은 out.print
	 if(i>0) out.print(",");
%>		
	<%-- for실행시마다 jsonobj를 생성 --%>
	{
		"name" : "<%=vo.getMem_name() %>",
		"id" : "<%=vo.getMem_id() %>",
		"addr" : "<%=vo.getMem_add1() %> <%=vo.getMem_add2() %>",
		"zip" : "<%=vo.getMem_zip() %>",
		"hp" : "<%=vo.getMem_hp() %>",
		"mail" : "<%=vo.getMem_mail() %>",
		"bir" : "<%=vo.getMem_bir() %>"
	}

	<%} %>

]
