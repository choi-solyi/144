<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8">
<title>Insert title here</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body>
	<ul>
	 <c:forEach items="${requestScope.list}" var="index"> 
		<li>
		<a href="EBdetail.do?bno=${index.bno}">${index.bno}</a>
		<a href="EBdetail.do?bno=${index.bno}">${index.bcaldate}</a>
		<a href="EBdetail.do?bno=${index.bno}">${index.btitle}</a>
		${index.bhit}
		${index.bup}
		</li>
	 </c:forEach>
	</ul>
	<a href="EBinsert.do">글 작성</a>
</body>

</html>