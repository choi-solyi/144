<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.subin {
	display: inline-block;
}



.subin1 {
	width: 120px;
}



</style>
<body>
	<!-- Example single danger button -->
	<form method="post" action="sbinsertresult.do" name="frm" > <!-- enctype="multipart/form-data" -->
		 <div class="container">
			<select class="custom-select custom-select-sm subin subin1" name="bcategory" id="bcategory" required="required">
				<option value="카테고리">카테고리</option>
				<option value="일반">일반</option>
				<option value="질문">질문</option>
				<option value="정보">정보</option>
			</select>

			<div class="input-group mb-3 subin" style="width: 600px;">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-default">제목</span>
					<input type="text" class="form-control"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-default" name="btitle" id="btitle" required="required">
				</div>

			</div>

			<div class="input-group">

				<textarea class="form-control textwidth" aria-label="With textarea"
					 rows="15" name="bcontent" id="bcontent" required="required"></textarea>
			</div>
		

		<div class="form-group">
			<label for="exampleFormControlFile1"></label> <input type="file"
				class="form-control-file" id="exampleFormControlFile1">
		</div>


		<input type="submit" value="작성" class="btn btn-primary">
		
		<p>
			전적이 궁금하신가요?<br> 소환사명을 입력하세요!
		</p>
		<div class="col-lg-6">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="소환사명을 입력하세요" >
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">전적검색</button>
				</span>
			</div>
			<!-- /input-group -->
			</div>
		<!-- /.col-lg-6 -->
		</div>
		</form>
	



</body>
</html>