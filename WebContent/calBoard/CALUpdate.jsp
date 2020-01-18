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
<form method="post" action="EBupdateresult.do">
		<div>
			<div>
			<label for="bno">글번호</label>
			<input type="text" name="bno" id="bno" value="${dto.bno}" readonly="readonly"></div>
			<div>
			<label for="btitle">제목</label>
			<input type="text" name="btitle" id="btitle" value="${dto.btitle}"></div>
			<div>
			<label for="bcaldate">날짜</label>
			<input type="date" name="bcaldate" id="bcaldate" value="${dto.bcaldate}"></div>
<!-- 			
			<li><label for="bimg">파일첨부</label>
				<input type="file" name="bimg" id="bimg"></li>
-->
			<div>
			<label>내용</label>
			<textarea name="bcontent" id="bcontent" rows="10" cols="50">${dto.bcontent}</textarea>
			</div>
			<input type="submit" value="확인">
			<input type="reset" value="취소">
			</div>
		</div>
	</form>

</body>
</html>