<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<ul class="list-group-item list-group-flush mt-3">
		<li class="list-group-item list-group-item-dark mb-3">${dto.id}, ${dto.bwritedate}, ${dto.bhit}, ${dto.bhit}</li>
		<li class="list-group-item"><h2>${dto.bcategory}, ${dto.btitle}</h2><br>
		<pre>${dto.bcontent}</pre>
		</li>
		<li class="list-group-item">
		<a class="btn btn-secondary" href="JWlist.do">목록</a>
		<a class="btn btn-secondary" href="JWupdate.do?bno=${dto.bno}">수정</a>
		<a class="btn btn-secondary" href="JWdelete.do?bno=${dto.bno}">삭제</a>
		</li>
	</ul>
	</div>
</body>
</html>