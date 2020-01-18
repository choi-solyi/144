<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5">

		<div class="jumbotron">
			<h2>대회 일정</h2>
		</div>

		<form method="post" action="EBinsertresult.do">
			<div class="form-group">
				<label for="btitle" class="col-sm-2 control-label">제목</label>
				<div class="col-sm-12">
					<input type="text" name="btitle" class="form-control" id="btitle"
						placeholder="제목을 입력하세요" required="required">
				</div>
			</div>
			<div class="form-group">
				<label for="bcaldate" class="col-sm-2 control-label">날짜</label>
				<div class="col-sm-3">
					<input type="date" name="bcaldate" class="form-control"
						id="bcaldate" required="required">
				</div>
			</div>
			<!-- 			
			<li><label for="bimg">파일첨부</label>
				<input type="file" name="bimg" id="bimg"></li>
-->
			<div class="form-group">
				<label for="bcontent" class="col-sm-2 control-label">내용</label>
				<div class="col-sm-12">
					<textarea class="form-control" name="bcontent" id="bcontent"
						rows="10" cols="50"></textarea>
				</div>
			</div>

			<div class="col-sm-12 text-right mb-5">
				<input class="btn btn-primary" type="submit" value="확인"> <input
					class="btn btn-primary" type="reset" value="취소">
			</div>
		</form>
	</div>
</body>
</html>