<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


</head>

<style>
body {
	background-image:
		url('http://choisolyi.dothome.co.kr/lol/img/main_img2.jpg');
	background-attachment: fixed;
	background-size: cover;
	background-size: 100% 100%;
}

.login_form {
	width: 400px;
	height: 300px;
	background-color: rgb(48, 48, 48, 0.8);
	padding: 25px;
	border-radius: 14px;
	position: absolute;
	left: 65%;
	top: 50%;
	color: white;
}

.submit_align {
	text-align: center;
}

.btn-primary {
	width: 140px;
	background-color: #255ad4;
}
</style>


<body>
<body>
	<div style="font-size: 4em; color: #f5fe8d; padding: 100px 200px;"><img src="http://choisolyi.dothome.co.kr/lol/img/logo.png" style="width:300px; padding:0px; margin:0px;"></div>


	<div class="login_form">
		<form method="post" action="loginresult.do" class="">
			<div class="form-group">
				<label for="id">아이디</label> 
				<input type="text" class="form-control" id="id" name="id" aria-describedby="emailHelp">
				 <small id="emailHelp" class="form-text text-muted">We'll never
					share your email with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="pw">비밀번호</label>
				<input type="password" class="form-control" name="pw" id="pw">
			</div>
			<div class="submit_align">
				<button type="submit" class="btn btn-primary">로 그 인</button>

			</div>
			<!-- <div>

				<div
					style="width: 140px; height: 40px; background-color: limegreen; margin: 20px"></div>
				<div
					style="float: right; width: 140px; height: 40px; background-color: yellow; margin: 0px 20px; position: relative; bottom: 60px;"></div>

				카카오로그인이나 네이버 로그인
			</div> -->
			<div>
				<a href="join.jsp" style="color: white; font-size: 0.9em;">신규가입</a>
			</div>

		</form>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>