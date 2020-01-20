<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
	img{
	width: 100%;
	}
</style>
</head>
<body>
	<div class="container">
	<ul class="list-group-item list-group-flush mt-3">
		<li class="list-group-item list-group-item-dark mb-3">${dto.id}, ${dto.bwritedate}, ${dto.bhit}, ${dto.bup}</li>
		<li class="list-group-item"><h2>[${dto.bcategory}] ${dto.btitle}</h2><br>
		<pre>${dto.bcontent}</pre>
		
		<c:if test="${dto.bimg ne null}">
		<div>
		<img alt="이미지" src="adboard/upload/${dto.bimg}">
		</div>
		</c:if>
		</li>
		<li class="list-group-item">
		<a class="btn btn-secondary" href="JWlist.do">목록</a>
		<c:if test="${id eq dto.id}">
		<a class="btn btn-secondary" href="JWupdate.do?bno=${dto.bno}">수정</a>
		<a class="btn btn-secondary" href="JWdelete.do?bno=${dto.bno}">삭제</a>
		</c:if>
		</li>
	</ul>
	</div>
</body>
</html>