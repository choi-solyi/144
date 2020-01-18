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
<c:set var = "dto" value = "${requestScope.dto }"></c:set>
<form method = "post" action = "topupdateresult.do">
<c:set var = "no" value = "${requsetScope.dto.lbno }"></c:set>
<ul>
	<li>
	<label for = "title">제목</label>
	<input type = "text" name = "title" id = "title" value = '<c:out value="${dto.btitle }"></c:out>' required="required">
	</li>
	<li>
	<label>분류</label>
	<select name = "category">
		<option value = "">분류</option>
		<option value = "일반">일반</option>
		<option value = "정보">정보</option>
		<option value = "질문">질문</option>
		<option value = "인증">인증</option>
		<option value = "토론">토론</option>
		<option value = "공지">공지</option>
	</select>
	<li>
	<label for = "nick">작성자</label>
	<input type = "text" name = "nick" id = "nick" value = '<c:out value="${dto.id }"></c:out>' required="required">
	</li>
	<li>
	<label for = "content">내용</label>
	<textarea rows="30" cols="100" name = "content" id = "content" required="required"><c:out value="${dto.bcontent }"></c:out></textarea>
	</li>
	<li>
	<input type = "submit" value = "수정">
	<input type = "reset" value = 취소>
	</li>
</ul>
</form>
</body>
</html>