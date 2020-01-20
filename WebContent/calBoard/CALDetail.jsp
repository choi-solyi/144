<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 본문 detail -->
<div class="container mt-5">

		<div class="jumbotron">
			<h2>대회 일정</h2>
		</div>

	<!-- 글번호, 제목 -->
	<ul class="list-group list-group-horizontal mt-5">
	<li class="list-group-item col-1" >${dto.bno} </li>
    <li class="list-group-item col-11">${dto.btitle}</li>
	</ul>
	<!-- 날짜, 조회수, 추천 -->
	<ul class="list-group list-group-horizontal mt-1">
   <li class="list-group-item col-4">날짜 : ${dto.bcaldate} </li>
   <li class="list-group-item col-4">조회수 : ${dto.bhit}</li>
   <li class="list-group-item col-4">추천 : ${dto.bup}</li>
   </ul>
	
	<!-- 내용 이미지 첨부 -->
	<div class="col-sm-12">
	${dto.bcontent}
	<c:if test="${dto.bimg ne null}">
	<img alt="이미지" src="calBoard/calupload/${dto.bimg}">
	</c:if> 
	</div>
	
	<!-- 수정, 삭제 -->
	<div class="col-sm-12 text-right m-1">
	<a href="EBupdate.do?bno=${dto.bno}" class="btn btn-primary">수정</a>
	<a href="EBdelete.do?bno=${dto.bno}" class="btn btn-primary">삭제</a>
	</div>
	<!-- 목록으로 -->
	<div class="col-sm-12 text-left mb-5">
	<a href="EBlist.do" class="btn btn-primary">목록으로</a>
	</div>
	
	</div>
	
	<!-- 댓글 -->
	<form method="post" action="/rep">
	
	
	</form>
	

</body>
</html>