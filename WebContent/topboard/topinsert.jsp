<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "topinsertresult.do">
<ul>
	<li>
	<label for = "title">제목</label>
	<input type = "text" name = "title" id = "title" required="required">
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
	<label for = "id">작성자</label>
	<input type = "text" name = "id" id = "id" required="required">
	</li>
	<li>
	<label for = "content">내용</label>
	<textarea rows="30" cols="100" name = "content" id = "content" required="required"></textarea>
	</li>
	<li>
	<input type = "submit" value = "전송">
	<input type = "reset" value = 취소>
	</li>
</ul>
</form>
</body>
</html>