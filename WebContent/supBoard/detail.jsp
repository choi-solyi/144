<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="dto" value="${requestScope.dto}"/> 
		
		
		<ul>
			<li>${dto.id}</li>
			<li>${dto.bwritedate}</li>
			<li>${dto.bhit}</li>
			<li>${dto.bcategory}</li>
			<li>${dto.btitle}</li>
			<li>${dto.bcontent}</li>
		</ul>
		
		<a href="sbdelete.do?bno=${dto.bno}">삭제하기</a>
		<a href="sbupdate.do?bno=${dto.bno}">수정하기</a>

</body>
</html>