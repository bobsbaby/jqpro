<%@page import="kr.or.ddit.board.vo.ReplyVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
[
	<%
		List<ReplyVo> list = (List<ReplyVo>) request.getAttribute("list");
		for(int i = 0; i < list.size(); i++){
		ReplyVo vo = list.get(i);	
		if(i >0) out.print(",");
	%>
	{
		"renum" : "<%=vo.getRenum() %>",
		"bonum" : "<%=vo.getBonum() %>",
		"name" : "<%=vo.getName() %>",
		"cont" : "<%=vo.getCont().replaceAll("\r", "").replaceAll("\n", "<br>") %>",
		"redate" : "<%=vo.getRedate() %>"	
	}

<%} %>

]
