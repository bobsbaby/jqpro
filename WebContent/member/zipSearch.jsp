<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


[
<%
	List<ZipVO> ziplist = (List<ZipVO>)request.getAttribute("list"); 
	for(int i = 0; i < ziplist.size(); i++) {
		ZipVO vo = ziplist.get(i);
		String bunji = vo.getBunji();
		if(bunji ==null) bunji = "";
		if(i>0) out.print(",");
%>	
	{
		"zipcod" : "<%=vo.getZipcode() %>",
		"addr" : "<%=vo.getSido() %> <%=vo.getGugun() %> <%=vo.getDong() %>",
		"bunji" : "<%=vo.getBunji() %>"
	}
		
<%} %>

]
