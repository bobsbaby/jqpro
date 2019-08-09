<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 

//클라이언트 요청시 전송되는 데이터를 받아온다. 
//db를 이용하는 crud처리를 한다. 
//처리한 결과를 클라이언트로 응답합낟. 
//응답타입은 json onject로 한다. 
%>
    <%--
    
    	jsonobj 주석은 html 주석으로 불 가능하고 jsp 주석문을 이용해야 한다. 
    
     --%>
   {
   
    "name" : "홍길동",
    "addr" : "대전 중구 ",
    "tel" : "010-1234-5678"
   
   }