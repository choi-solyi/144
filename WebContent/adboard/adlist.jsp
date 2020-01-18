<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<ul class="list-group-item list-group-flush mt-3">
		<li class="list-group-item list-group-item-dark">카테고리, 글번호, 글제목,
			글작성일, 글조회수, 추천수, 작성자</li>
		<c:forEach var="i" items="${arr}">
			<li class="list-group-item list-group-item-action">${i.bcategory},${i.bno},
				${i.btitle}, ${i.bwritedate}, ${i.bhit}, ${i.bup}, ${i.id}</li>
		</c:forEach>
		<li class="list-group-item"><a class="btn btn-secondary" href="JWinsert.do">글작성</a></li>
	</ul>
	</div>
</body>
</html>