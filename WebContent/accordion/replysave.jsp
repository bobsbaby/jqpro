<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	int renum = (Integer) request.getAttribute("renum");
	if(renum>0) {
%>

	{
	
		"res" : "저장성공"
	}
	<% }else { %>
	
	
	{
	
		"res" : "저장실패"
	}
		
<%	} %>