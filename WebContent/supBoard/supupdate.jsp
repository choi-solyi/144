<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<c:set var="dto" value="${requestScope.dto }"/>
	
	<!-- Example single danger button -->
	<form method="post" action="sbupdateresult.do" name="frm" enctype="multipart/form-data" >
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
			<input type="hidden" name="bno" id="bno" value="${dto.bno}" readonly="readonly">
			<select class="custom-select custom-select-sm subin subin1" name="bcategory" id="bcategory" >
				<option value="카테고리" >카테고리</option>
				<option value="일반">일반</option>
				<option value="질문">질문</option>
				<option value="정보">정보</option>
			</select>

			<div class="input-group mb-3 subin" style="width: 600px;">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroup-sizing-default">제목</span>
					<input type="text" class="form-control"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-default" name="btitle" id="btitle" value="${dto.btitle}">
				</div>

			</div>

			<div class="input-group">

				<textarea class="form-control textwidth" aria-label="With textarea"
					 rows="15" name="bcontent" id="bcontent" >${dto.bcontent }</textarea>
			</div>
		

		<div class="form-group">
			<label for="bimg"></label> <input type="file"
				class="form-control-file" id="bimg" name="bimg" value="${dto.bimg }">
		</div>
		<div >
			<a class="btn btn-secondary btn-sm" href="sblist.do" role="button" style="padding: 5px 15px;">목록</a>
		</div>

		<div style="text-align: right; margin-right:30px;">
		<input type="submit" value="작성완료" class="btn btn-secondary btn-lg" style="padding:10px 30px;">
		</div>

		
		<div class="input-group" style="width:500px; margin: 0 auto;">
		
		<input type="text" class="form-control" placeholder="소환사명을 입력하세요">
		<div class="input-group-btn">
			<button class="btn btn-default" type="button">전적검색</button>
		</div>
		
	</div>
		<!-- /.col-lg-6 -->
			</div>
	</form>

	
	
</body>
</html>