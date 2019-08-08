<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//post방식 (get방식은 server.xml에 설정해 준 uriencording을 사용해서 별도로 설정 안해줘도 된다. )
		request.setCharacterEncoding("UTF-8");
		
	
		//tel과 name은 html에 작성한 name과 동일하게 작성해야 한다. 
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
	%>
	
	
	<%= name %>님! 환영합니다.<br>
	<%= tel %>번호로 연락드리겠습니다. <br>
	<h3>즐거운 하루 되세요~~~</h3>
	
	
</body>
</html>