<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel = "stylesheet" href = "../css/board.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src = "../js/board.js"></script>
  
  <style>
  	#top {
  		margin-left : 20px;
  	}
  </style>
<title>Insert title here</title>
<script>
	//전역변수로 만들어서 board.js에서 사용할 수 있도록 한다
	reply = {};
	$(function(){
		
		readServer();
		
		//myModal이 감춰질때 이 클래스에 있는 내용을 지워라 
		$('.modal').on('hidden.bs.modal', function(){
			$('.text', this).val("");
		})
		//버튼의 class == action -> 수정, 삭제,댓글 등록 
		//delegate 방식으로 -> body tag에 미리 만들어 놓은 것이 아니라 실행 후 나중에 만들어 진 것이므로  bind 방식이 아니라 delegate 방식으로 해야 한다. 
		//
		$('#accordionList').on('click','.action',function(){
			bname = $(this).attr('name');
			bidx = $(this).attr('idx');
			if(bname == "delete"){
				deleteServer(bidx);
			}else if(bname == "modify"){
				
			}else if (bname == "reply"){	//댓글 등록 버튼 클릭
				//[] -> 배열      {} --> 객체(동적으로 필드나 메서드를 추가할 수 있다.)
				
				//댓글 등록, 입력한 내용을 가져온다. (자식찾기 content, find, childred)->parent.find('.area').val
				text = $(this).parent().find('.area').val();
				name = "korea";
				reply.name = name;
				reply.cont = text;
				reply.bonum = bidx;
				
				//this는 누른 등록버튼 this를 기준으로 하기 위하여 this를 넘겨줌 
				//replysaveserver와 replylistserver는 비동기이므로 replysaveserver가 실행되기 전에 replylistserver가 실행될 수 있어, replysaveserver가 동기처리해주어야 한다. 
				// 동기 처리 -> async : false,
				replySaveServer();				//비동기처리를 동기처리로 변환
				ReplyListServer(bidx, this);
			//제목을 클릭하면	
			}else if(bname == "list"){
				ReplyListServer(bidx, this);
			}else if(bname =="r_delete"){
				replyDeleteServer(bidx,this);
			}else if (bname =="r_modify") {
				
				if($('#modifyForm').css('display') != "none") {
					//댓글수정 클릭할때 이미 다른곳에서 댓글 수정을 완료하지 않은 상태로 modifyForm이 현재 열려 있는 상태를 닽으려고 한다. 
				replyReset();
				}
				rnum = bidx;
				modifycont = $(this).parents('.rep').find('.cont').html().replace(/<br>/g, "\n");
				$('#modifyForm>#test').val(modifycont);
				$(this).parents('.rep').find('.cont').empty().append($('#modifyForm'));
				$('#modifyForm').show();
				//replyModifyServer(bidx, this);
				
			}
		})
		
		function replyReset(){
			
		 spanTag = $('#modifyForm').parent();
		 $('body').append($('#modifyForm'));
		 
		 $('#modifyForm').hide();
		 
		 spanTag.html(modifycont.replace(/\n/g, "<br>"));
		}
		
		$('#w_submit').on('click', function(){
			writeServer();
		})
		
		$('#btnreset').click(function(){
			replyReset();
		})
		
		$('#btnok').click(function(){
			modifycont = $('#modifyForm>#test').val();
			spanTag = $('#modifyForm').parent();
			reply.renum = rnum;
			reply.cont = modifycont;
			replyUpdateServer();
			
			$('body').append($('modifyForm'));
			$('#modifyForm').hide();
			
			spanTag.html(modifycont.replace(/\n/g,"<br>"));
		})

	})
	
</script>
</head>
<body>
<div id = "modifyForm" style = "display:none;">
	<textarea id = "test" rows="5" cols="50"></textarea>
	<input type = "button" value = "확인" id = "btnok">
	<input type = "button" value = "취소" id = "btnreset">
</div>
 <h2>  ༼๑⁰⊖⁰๑༽❤  게시판❤ (^◔ᴥ◔^) </h2>
 
 <button id = "top" type="button" class="btn btn-warning btn-sm" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-"></span>글쓰기</button>
 <br><br>
 
 <!-- 게시판 목록 출력  -->
 <div id=accordionList> 
 </div>
 <br>
 
 <!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
      <form id="writeForm">
						<div>
							<label for="subject" class="header">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목&nbsp;</label>
							<input type="text"  id="w_subject" name="subject"
								class="text ui-widget-content ui-corner-all" />
						</div>
						<div>
							<label for="writer" class="header">이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름&nbsp;</label>
							<input type="text"  id="w_writer" name="writer"
								class="text ui-widget-content ui-corner-all" />
						</div>
						<div>
							<label for="mail" class="header">메&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;일&nbsp;</label>
							<input type="text"   id="w_mail" name="mail"
								class="text ui-widget-content ui-corner-all" />
						</div>
						<div>
							<label for="password" class="header">비밀번호&nbsp;</label>
							<input 	type="password"   id="w_password" name="password"
								class="text ui-widget-content ui-corner-all" />
						</div>
						<div>
							<label for="content" class="w_header">본&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;문</label>
							<br />
							<textarea rows="10" name="content" cols="50" id="w_content" class="text ui-widget-content ui-corner-all"></textarea>
						</div>
						<button id="w_submit" type="button" data-dismiss="modal" class="btn btn-default btn-success">
							<span class="glyphicon glyphicon-off"></span> 확인
						</button>
					</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
  
 
<!-- collapse -> accordion이 접혀진 채로 나타남 / collapse in -> accordion이 펼쳐진 채로 나타남 -->
</body>
</html>