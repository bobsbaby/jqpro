<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터가 있는 경우와 없는 경우 
	List<ProdVO> list = (List<ProdVO>) request.getAttribute("list");
	if(list !=null && list.size()>0) {
		//데이터가 있는 경우 jsonobj 배열을 생성  
%>		
	{
		"sw" : "OK",
		"data" : [
		<% 
			for(int i = 0; i < list.size(); i++ ){
				ProdVO vo = list.get(i);
				if(i>0) out.print(",");
		%>
			{
				"id" : "<%=vo.getProd_id() %>",
				"name" : "<%=vo.getProd_name() %>"
			}
		
			<%} %>		
				]
	}

<%	
	}else {

	//데이터가 없는 경우 

%>
{
	"sw" : "NO"
}


<%
	}
 
%>