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
.bg{
		display: inline-block;
		
	}

	.bg1{
		width:470px;		
		
	}


</style>

<body>
	
	<!-- Example single danger button -->
	<form method="post" action="sbinsertresult.do" name="frm" enctype="multipart/form-data"  > <!-- enctype="multipart/form-data" -->
		<div class="bg">
			<img src=supBoard/img/sup1.jpg class="bg1">
	</div>
	<div class="bg">
			<img src=supBoard/img/sup2.jpg class="bg1">
	</div>
	<div class="bg">
			<img src=supBoard/img/sup3.jpg class="bg1">
	</div>
	<div class="bg">
			<img src=supBoard/img/sup4.jpg class="bg1">
	</div>
		 <div class="container">
		 	
		<div style="text-align: center; margin-bottom: 50px; margin-top:50px;">
		<h1>S U P P O R T E R</h1>
		</div>
			<select class="custom-select custom-select-sm subin subin1" name="bcategory" id="bcategory" required="required">
				<option value="일반">일반</option>
				<option value="질문">질문</option>
				<option value="정보">정보</option>
				<option value="인증">인증</option>
			</select>
			<input type="hidden" name="id" value="${sessionScope.id}">

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
		

		<div class="form-group"  >
			<label for="bimg"></label> <input type="file"
				class="form-control-file" id="bimg" name="bimg">
			
		</div>
		<div >
			<a class="btn btn-secondary btn-sm" href="sblist.do" role="button" style="padding: 5px 15px;">목록</a>
		</div>
		
		<div style="text-align: right; margin-right:30px; margin-bottom:150px;">
		<input type="submit" value="작성완료" class="btn btn-secondary btn-lg" style="padding:10px 30px;">
		</div>
		
		
	
			<!-- /input-group -->
			
		<!-- /.col-lg-6 -->
		</div>
		</form>
	



</body>
</html>