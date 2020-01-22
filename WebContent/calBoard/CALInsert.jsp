<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
.jumbotron {
margin-bottom: 20px;
background-image: url("calBoard/calupload/calboard.jpg");
background-size: cover;
background-repeat: no-repeat;
color: white;
}
</style>
</head>
<body>
	<div class="container mt-5 text-center">

		<div class="jumbotron">
		 <h1 class="display-4">대회 일정</h1>
		</div>

		<form method="post" action="EBinsertresult.do" enctype="multipart/form-data">
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
			
			<div class="form-group ">			
			<label for="uploadfile" class="col-sm-2 control-label">이미지</label>
			<div class="col-sm-3">
				<input type="file" name="uploadfile" id="uploadfile">
			</div>
			</div>
			

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