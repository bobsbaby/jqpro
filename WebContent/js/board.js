/**

 * 
 */

var replyUpdateServer = function() {
	$.ajax({
		url : '/jqpro/ReplyUpdate',
		type : 'post',
		data : reply,
		dataType : 'json',
		success : function(datas){
			alert(datas.sw);
			readServer();
		},
		error : function(xhr){
			alert(xhr.status);
		}
	})
}


var replyDeleteServer = function(renum, but){
	$.ajax({
		url : '/jqpro/ReplyDelete',
		data : {'renum' : renum},
		dataType : 'json',
		success : function(datas){
			//readServer();
			$(but).parents('.rep').remove();
			$(but).parents('.rep').parents('.panel').find('.area').empty();
		},
		error : function(xhr){
			alert(xhr.status);
		}
	})
}


var ReplyListServer = function(seq, but){
	//but는 등록버튼임당F
	$.ajax({
		url : '/jqpro/ReplyList',
		type : 'get',
		data : {'seq' : seq},
		dataType : 'json',
		success : function(datas){
			$(but).parents('.panel').find('.pbody').find('.rep').remove();
			code = "";
			$.each(datas, function(i, v){
				code += '   <div class="panel-body rep">';
				code += '   	<p style = "width : 80%; float : left; ">';
				code += '			<span>'+v.name+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '' +v.redate +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '</span><br><br>';
				code += '<span class = "cont">'+v.cont+'</span>';
				code += '   	</p>';
				code += '   	<p style = "float : right;">';
				code += '   		<button idx = "'+v.renum+'" type = "button" name = "r_modify" class = "action">댓글수정</button>';
				code += '   		<button idx = "'+v.renum+'" type = "button" name = "r_delete" class = "action">댓글삭제</button>';
				code += '</p></div>';
			})
			$(but).parents('.panel').find('.pbody').append(code);
			
			//append는 계속 추가되는 문제가 있어 remove를 해 줘야 한다. 
		},
		error : function(xhr){
			alert(xhr.status);
		}
	})
}


var replySaveServer = function(but){
	$.ajax({
		url : '/jqpro/ReplySave',
		type : 'post',
		data : reply,	//reply 객체를 보내준다. 
		async : false,	//동기처리로 변환 
		dataType : 'json',
		success : function(datas){
			//alert(datas.res);+
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		}
	})
}

var deleteServer = function(bidx){
	
	$.ajax({
		url : '/jqpro/BoardDelete',
		type : 'get',
		data : {"seq" : bidx},
		dataType : 'json',
		success : function(datas) {
			//alert(datas.sw);
			//db 내용을 다시 받아오는 것 
			readServer();
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		}
	})
}


var writeServer = function(){
	$.ajax({
		url : '/jqpro/BoardWrite',
		type : 'post',
		data : $('#writeForm').serializeArray(),
		dataType : 'json',
		success : function(datas) {
			//저장 성공, 실패 
			$('#myModal').modal('hide');
			//alert(datas.res);
			readServer();
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		}
	})
}

var readServer = function(){
	$.ajax({
//		url : '<%=request.getContextPath()%>/BoardList',
//		url : '${pageContext.request.contextPath}/BoardList',
		url : '/jqpro/BoardList',
		type : 'get',
		dataType : 'json',
		success : function(datas){
			code = '<div class="panel-group" id="parent">';
			
			$.each(datas, function(i, v){
				code += '<div class="panel panel-default">' ;
				code += ' <div class="panel-heading">';
				code += '   <h4 class="panel-title">';
				code += '     <a class = "action" name = "list" idx = "'+ v.seq +'" data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.seq + '">' + v.subject + '</a>';
				code += '   </h4>';
				code += ' </div>';
				code += ' <div id="collapse'+v.seq+'" class="panel-collapse collapse">';
				code += '   <div class="panel-body pbody">';
				code += '   	<p style = "width : 80%; float : left; ">';
				code += '   	      작성자 :'+v.writer+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '   	      이메일 :'+v.mail +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '   	      작성일 :'+v.day +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '   	      조회수 :'+v.hit+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '   	</p>';
				code += '   	<p style = "float : right;">';
				code += '   		<button idx = "'+v.seq+'" type = "button" name = "modify" class = "action">수정</button>';
				code += '   		<button idx = "'+v.seq+'" type = "button" name = "delete" class = "action">삭제</button>';
				code += '   	</p>';
				code += '   	<hr>';
				code += '   	<p style = "width : 80%; float : left;">';
				code += v.cont;
				code += '   	</p> ';
				code += '   	<p>';
				code += '<textarea class ="area" cols = "100">댓글작성</textarea> ';
				code += '<button style = "height : 45px; vertical-align : top; float : right; " type = "button" idx = "'+v.seq+'" name = "reply" class = "action">등록</button> ';
				code += '   	</p> ';
				code += '   </div>';
				code += ' </div>';
				code += ' </div>';
			})
			code += '</div>';
			$('#accordionList').html(code);
		}

	})


}