<%@page import="kr.or.ddit.lprod.vo.LProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
[

<%
	List<LProdVO> list = (List<LProdVO>)request.getAttribute("list");
	for(int i = 0; i < list.size(); i++){
		LProdVO vo = list.get(i);
		if(i>0) out.print(",");
%>
	{
		"Lprod_id" : "<%=vo.lprod_id %>",
		"Lprod_gu" : "<%=vo.lprod_gu %>",
		"Lprod_nm" : "<%=vo.lprod_nm %>"
	}

<%} %>
]