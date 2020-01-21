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
	
	$(document).ready(function() {
		let bno = ${dto.bno}
		$.ajax({
			url : 'JWreplist.do'
			,data : {'bno' : bno}
			,method : 'post'
			,dataType : 'json'
			,success : function(arr) {
				console.log(arr);
				$.each(arr, function(index, dto) {
					let repboard = "<li>"+dto.rcontent+"<c:if test='${id eq dto.id}'>"
					repboard += "<input type='button' value='삭제' onclick='del("+dto.rep+")'></c:if></li>"
					$('#replist').append(repboard);
				});
			}
			,error : function(e) {
				console.log('error');
			}
		})
	});
</script>
<style>
img {
	width: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<ul class="list-group-item list-group-flush mt-3">
			<li class="list-group-item list-group-item-dark mb-3">${dto.id},
				${dto.bwritedate}, ${dto.bhit}, ${dto.bup}</li>
			<li class="list-group-item"><h2>[${dto.bcategory}]
					${dto.btitle}</h2> <br> <pre>${dto.bcontent}</pre> 
					<c:if test="${dto.bimg ne null}">
					<div>
						<img alt="이미지" src="adboard/upload/${dto.bimg}">
					</div>
				</c:if></li>
			<li class="list-group-item">
				<form method="post" action="JWaddrep.do?bno=${dto.bno}">
				<div class="input-group">
				
					<textarea class="form-control" rows="2" autofocus="autofocus"
						maxlength="100" name="rcontent"></textarea>
					<div class="input-group-append">
						<input type="submit" class="btn btn-secondary p-3" onclick="send()" value="댓글작성">
					</div>
				</div>
				</form>
				<ul id="replist" class="list-group-item list-group-flush p-0 pl-4">
				</ul>
			</li>
			<li class="list-group-item"><a class="btn btn-secondary"
				href="JWlist.do">목록</a> <c:if test="${id eq dto.id}">
					<a class="btn btn-secondary" href="JWupdate.do?bno=${dto.bno}">수정</a>
					<a class="btn btn-secondary" href="JWdelete.do?bno=${dto.bno}">삭제</a>
				</c:if></li>
		</ul>
	</div>
</body>
</html>