<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	int seq = (Integer)request.getAttribute("seq");
	
	if(seq > 0) { %>
	
	{
	
		"res" : "저장성공"
	}
	<% }else { %>
	
	
	{
	
		"res" : "저장실패"
	}
		
<%	} %>