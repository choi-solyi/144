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
		<ul>
			<li>
				<label for="btitle">제목</label>
				<input type="text" name="btitle" id="btitle" required="required">
			</li>
			<li>
				<label for="bcaldate">날짜</label> 
				<input type="date" name="bcaldate" id="bcaldate" required="required">
			</li>
<!-- 			
			<li>
				<label for="bimg">파일첨부</label>
				<input type="file" name="bimg" id="bimg">
			</li>
 -->
			<li>
				<label>내용</label>
				<textarea name="bcontent" id="bcontent" rows="10" cols="50"></textarea>
			</li>
			<li>
				<input type="submit" value="입력">
			    <input type="reset" value="취소">
			</li>
		</ul>
	</form>
</body>
</html>