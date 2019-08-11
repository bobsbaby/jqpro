<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[

	<%
		List<BuyerVO> list = (List<BuyerVO>)request.getAttribute("list");
		for(int i = 0; i < list.size(); i++) {
			BuyerVO vo = list.get(i);
			if(i>0) out.print(",");
	%>
	
	{
		"Buyer_id" 		: "<%=vo.getBuyer_id() %>",
		"Buyer_Name" 	: "<%=vo.getBuyer_name() %>",
		"Buyer_Bank" 	: "<%=vo.getBuyer_bank() %>",
		"Buyer_BankNo"  : "<%=vo.getBuyer_bankno() %>",
		"Buyer_BankName": "<%=vo.getBuyer_name() %>",
		"Buyer_Zip" 	: "<%=vo.getBuyer_zip() %>",
		"Buyer_Addr" 	: "<%=vo.getBuyer_add1() %> <%=vo.getBuyer_add2() %>",
		"Buyer_ConTel"	: "<%=vo.getBuyer_comtel()%>",
		"Buyer_Fax" 	: "<%=vo.getBuyer_fax()%>",
		"Buyer_Mail" 	: "<%=vo.getBuyer_mail()%>",
		"Buyer_Changer" : "<%=vo.getBuyer_charger() %>",
		"Buyer_Telex" 	: "<%=vo.getBuyer_telext() %>"
	}

	<%} %>

]