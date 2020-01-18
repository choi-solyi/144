<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="list" value="${requestScope.list }"></c:set>
	<c:set var="currpage" value="${requestScope.currpage }"></c:set>
	<c:set var="startblock" value="${requestScope.startblock }"></c:set>
	<c:set var="endblock" value="${requestScope.endblock }"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage }"></c:set>
	<c:set var="search" value="${requestScope.search }"></c:set>
	<c:set var="txtsearch" value="${requestScope.txtsearch }"></c:set>
<table>
	<thead>
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th><th>추천수</th></tr>
	</thead>
		<c:forEach var="list" items="${list }">
			<tr>
			<td><a href = "detail.do?no=${list.bno }"><c:out value="${list.bno }"></c:out></a></td>
			<td><c:out value="${list.bcategory }"></c:out> <c:out value="${list.btitle }"></c:out></td>
			<td><c:out value="${list.id }"></c:out></td>
			<td><c:out value="${list.bwritedate }"></c:out></td>
			<td><c:out value="${list.bhit }"></c:out></td>
			<td><c:out value="${list.bup }"></c:out></td>
			</tr>
		</c:forEach>
</table><br>
<c:forEach var = "i" begin = "${startblock}" end = "${endblock }" step = "1">
		<c:if test = "${currpage==i }">
			<c:out value="${i }"></c:out>
		</c:if>
		<c:if test="${currpage!=i }">
			<a href = "list.do?curr=${i}&search=${search}&txtsearch=${txtsearch}">${i}</a>
		</c:if>
	
	</c:forEach>
<form method="post" action = "toplist.do">
		<select name = "search">
			<option value = "title">글제목</option>
			<option value = "content">내용</option>
			<option value = "wrietr">작성자</option>
		</select>
		<input type="text" name = "txtcearch">
		<input type="submit" value="검색">
	</form>
<a href = "topinsert.do">추가</a><br>
</body>
</html>