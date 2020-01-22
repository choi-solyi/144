<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form method="post" action="EBupdateresult.do">

			<div class="form-group">
				<label for="bno" class="col-sm-2 control-label">글번호</label>
				<div class="col-sm-12">
					<input type="text" name="bno" id="bno" class="form-control"
						value="${dto.bno}" readonly="readonly">
				</div>
			</div>

			<div class="form-group">
				<label for="btitle" class="col-sm-2 control-label">제목</label>
				<div class="col-sm-12">
					<input type="text" name="btitle" id="btitle" class="form-control"
						value="${dto.btitle}">
				</div>
			</div>
			<div class="form-group">
				<label for="bcaldate" class="col-sm-2 control-label">날짜</label>
				<div class="col-sm-12">
					<input type="date" name="bcaldate" id="bcaldate"
						class="form-control" value="${dto.bcaldate}">
				</div>
			</div>

			<div class="form-group">
				<label for="bcontent" class="col-sm-2 control-label">내용</label>
				<div class="col-sm-12">
					<textarea class="form-control" name="bcontent" id="bcontent"
						rows="10" cols="50">${dto.bcontent}</textarea>
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