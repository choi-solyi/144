<%@page import="java.net.URLEncoder"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<c:set var = "dto" value = "${requestScope.dto }"></c:set>
<table>
	<tbody>
		<tr><th><c:out value = "${dto.id }"></c:out></th>
			<th><c:out value = "${dto.bwritedate }"></c:out></th>
			<th><c:out value = "${dto.bhit }"></c:out></th>
			<th><c:out value = "${dto.bup }"></c:out></th>
		</tr>
	</tbody>
	<tbody>
		<tr><td><c:out value = "${dto.bcategory }"></c:out></td></tr>
		<tr><td><c:out value = "${dto.btitle }"></c:out></td></tr>
		<tr><td><c:out value = "${dto.bcontent }"></c:out></td></tr>
	</tbody>
</table>
<a href = "toplist.do">목록</a>
<a href = "topupdate.do?no=${dto.bno }">수정</a>
<a href = "topdelete.do?no=${dto.bno }">삭제</a>
<a href = "topdetail.do?no=${dto.bno }">추천</a>
</body>
</html>