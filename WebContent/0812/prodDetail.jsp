<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    ProdVO  vo =    (ProdVO)request.getAttribute("vo");
   if(vo !=null){
%>

{
   "id"      : "<%= vo.getProd_id() %>",
   "name"    : "<%= vo.getProd_name() %>",
   "lgu"     : "<%= vo.getProd_lgu() %>",
   "sale"    : "<%= vo.getProd_sale() %>",
   "price"   : "<%= vo.getProd_price() %>",
   "outline" : "<%= vo.getProd_outline() %>",
   "detail"  : "<%= vo.getProd_detail() %>"
}

<%} %>

