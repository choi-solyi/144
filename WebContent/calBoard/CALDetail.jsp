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
	<div>
	<div>글번호</div>
	<div>${dto.bno}</div>
	<div>날짜</div>
	<div>${dto.bcaldate}</div>
	<div>제목</div>
	<div>${dto.btitle}</div>
	<div>조회수</div>
	<div>${dto.bhit}</div>
	<div>추천</div>
	<div>${dto.bup}</div>
	<div>내용</div>
	<div>${dto.bcontent}</div>
	</div>
	<a href="EBinsert.do">새 글 작성</a>
	<a href="EBupdate.do?bno=${dto.bno}">수정</a>
	<a href="EBdelete.do?bno=${dto.bno}">삭제</a>
</body>
</html>