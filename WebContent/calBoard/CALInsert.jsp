<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="EBinsertresult.do">
		<div>
			<div>
			<label for="btitle">제목</label>
			<input type="text" name="btitle" id="btitle" required="required">
			</div>
			<div>
			<label for="bcaldate">날짜</label>
			<input type="date" name="bcaldate" id="bcaldate" required="required">
			</div>
<!-- 			
			<li><label for="bimg">파일첨부</label>
				<input type="file" name="bimg" id="bimg"></li>
-->
			<div>
			<label>내용</label>
			<textarea name="bcontent" id="bcontent" rows="10" cols="50"></textarea>
			</div>
			<div>
			<input type="submit" value="입력">
			<input type="reset" value="취소">
			</div>
		</div>
	</form>
</body>
</html>