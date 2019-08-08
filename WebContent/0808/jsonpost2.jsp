<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String vname = request.getParameter("name");
	String vtel = request.getParameter("tel");

%>

{

	"name " : "<%=vname %>",
	"tel"  : "<%=vtel %>"

}