<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form method="post" action="JWinsertresult.do">  <!-- enctype="multipart/form-data" -->
			<ul class="list-group-item list-group-flush mt-3">
				<li class="list-group-item">
					<div class="input-group mb-2">
						<div class="input-group-prepend">
					    	<span class="input-group-text" id="btitle">제 목</span>
						</div>
						<input type="text" class="form-control" placeholder="제목을 입력하세요" name="btitle" id="btitle">
					</div>
					<div class="input-group mb-2">
					<div class="input-group-prepend">
						<label class="input-group-text" for="bcategory">카테고리</label>
					</div>
						<select class="custom-select" name="bcategory" id="bcategory">
							<option selected>Choose category</option>
							<option value="정보">정보</option>
							<option value="잡담">잡담</option>
							<option value="도움">도움</option>
						</select>
					</div>
					<!-- <div class="input-group mb-3"> 
						<div class="custom-file">
							<input type="file" class="custom-file-input" name="bimg" id="bimg">
							<label class="custom-file-label" for="bimg">Choose file</label>
						</div>
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="button" id="bimgbtn">Button</button>
						</div>
					</div> -->
					<div class="input-group-prepend"></div> 
					<textarea class="form-control" rows="20" name="bcontent" id="bcontent"></textarea>
				</li>
				<li class="list-group-item">
					<input class="btn btn-secondary" type="submit" value="작성"> 
					<a class="btn btn-secondary" href="JWlist.do">취소</a>
				</li>
			</ul>
		</form>
	</div>
</body>
</html>