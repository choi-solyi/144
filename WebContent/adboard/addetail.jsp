<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
	function send(){
		if(document.frm.rcontent.value!="")
			document.frm.submit();
	}
	
	function del(repno, bno){
		location.href="JWdelrep.do?repno="+repno+"&bno="+bno
	}
	var upcheck=0;
	
	function up(bno){
		upcheck=upcheck+1;
		if(upcheck>1)
			{
			alert('추천은 한번만 가능합니다.');
			return;
		}
		$.ajax({
			url : 'JWuprep.do'
			,data : {'bno' : bno}
			,method : 'post'
			,success : function(data) {
				$('#boardup').val('추천'+'+${dto.bup+1}');
			}
			,error : function(e) {
				console.log(e);
			}
		});
	} 
	
	function replist(){
		let bno = ${dto.bno}
		let id='${sessionScope.id}';
		$.ajax({
			url : 'JWreplist.do'
			,data : {'bno' : bno}
			,method : 'post'
			,dataType : 'json'
			,success : function(arr) {
				console.log(arr);
				console.log(id);
				 $.each(arr, function(index, repdto) {
					 let repboard ="";
					 repboard = "<li class='list-group-item list-group-item-action'" 
						 if(repdto.id==id)
							 {
							 repboard+="style='background-color : #f1f3f4; border-radius: 10px'"
							 }
					 repboard +=">"+repdto.nick+"<small class=''>("+repdto.rwritedate+")</small><br>"+repdto.rcontent+"<div class='text-right'>"
					 if(repdto.id==id)
						  {
						repboard+="<input class='btn btn-secondary' type='button' value='댓글삭제' onclick='del("+repdto.repno+","+repdto.bno+")'></div>"	 
						  }
					  repboard+="</li>"
					 $('#replist').append(repboard);
				}); 
				 console.log(arr.length);
			}
			,error : function(e) {
				console.log('error');
			}
			
		})
	};
	
	$(document).ready(function() {
		replist();
		$('#rcontent').keyup(function() {
			//alert($('#rcontent').val().length);
			let replength = $('#rcontent').val().length;
			$('#replength').empty();
			$('#replength').append(replength+"/100");
		});
	});
	
</script>
<style>
img {
	width: 100%;
}
#replength{
	color: gray; 
} 
</style>
</head>
<body>
	<div class="container">
		<ul class="list-group-item list-group-flush mt-3">
			<li class="list-group-item list-group-item-dark mb-3">${dto.bno}, ${dto.nick}
				</li>
			<li class="list-group-item">
			<div class="d-flex justify-content-between">
			<h2>[${dto.bcategory}] ${dto.btitle}</h2><span>${dto.bwritedate}, ${dto.bhit}</span>
			</div> 
			<pre>${dto.bcontent}</pre> 
					<c:if test="${dto.bimg ne null}">
					<div>
						<img alt="이미지" src="adboard/upload/${dto.bimg}">
					</div>
				</c:if>
				<div class="text-center">
				<input id="boardup"class="btn btn-secondary" type="button" value="추천+${dto.bup}" onclick="up(${dto.bno})">
				</div>
				</li>
			<li class="list-group-item pb-0">
				<form method="post" action="JWaddrep.do?bno=${dto.bno}">
				<div class="input-group">
									
					<textarea class="form-control" rows="3" autofocus="autofocus"
						maxlength="100" name="rcontent" id="rcontent" placeholder="저작권 등 다른 사람의 권리를 침해하거나 명예를 훼손하는 게시물은 이용약관 및 관련 법률에 의해 제재를 받을 수 있습니다. 건전한 토론문화와 양질의 댓글 문화를 위해, 타인에게 불쾌감을 주는 욕설 또는 특정 계층/민족, 종교 등을 비하하는 단어들은 표시가 제한됩니다."></textarea>
					<div class="input-group-append">
						<input type="submit" class="btn btn-secondary p-3" onclick="send()" value="댓글작성">
					</div>
					
				</div>
				</form>
				<span id="replength">0/100</span>
				<ul id="replist" class="list-group-item list-group-flush p-2 pl-4">
				</ul>
			</li>
			<li class="list-group-item"><a class="btn btn-secondary"
				href="JWlist.do">글목록</a> <c:if test="${id eq dto.id}">
					<a class="btn btn-secondary" href="JWupdate.do?bno=${dto.bno}">글수정</a>
					<a class="btn btn-secondary" href="JWdelete.do?bno=${dto.bno}">글삭제</a>
				</c:if></li>
		</ul>
	</div>
</body>
</html>