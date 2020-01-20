<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<style>
#left {
	background-image:
		url('http://choisolyi.dothome.co.kr/lol/img/main_img.jpg');
	background-attachment: fixed;
	background-size: cover;
	min-height: 160px;
	flex-direction: column;
	justify-content: center;
	display: flex;
	color: white;
}

#left h1 {
	font-size: 4.5em;
	font-weight: 400;
	font-stretch: ultra-condensed;
}

#right {
	min-height: 160px;
	flex-direction: column;
	justify-content: center;
	display: flex;
}

.or {
	margin: 3.2rem 0px;
}

#ordiv {
	width: 100%;
	height: 1px;
	position: relative;
	top: 1rem;
	background: rgb(221, 221, 221);
}

#orspan {
	line-height: 1.4;
	background-color: white;
	color: rgb(187, 187, 187);
	font-size: 1.4rem;
	font-weight: 200;
	position: relative;
	top: -0.2rem;
	padding: 0px 1rem;
}

.btn {
	width: 30%;
}

.row {
	margin: 0px;
}
</style>
</head>
<body>
	<div class="row">
		<div id="left" class="col-6 vh-100 vw-100 text-center">
			<h1>
				To continue, <br>sing in to LoLing
			</h1>
		</div>
		<div id="right" class="col-6 vh-100 vw-100 text-center">
			<img class="btn" alt="네이로이미지" src="img/네이버 아이디로 로그인_완성형_White.PNG"
				style="margin: 0px auto">
			<div class="or">
				<div id="ordiv"></div>
				<span id="orspan">or</span>
			</div>

			<form method="post" action="join.do">

				<h3 class="mb-3">Enter your info</h3>
				<div class="row justify-content-center">
					<div class="col-5 text-left">
						<p class="mb-0">Email address</p>
					</div>
				</div>
				<div class="input-group row justify-content-center mt-0 mb-2">
					<div class="col-5">
						<input class="form-control" type="email" name="id"
							required="required" autofocus="autofocus">
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-5 text-left">
						<p class="mb-0">password</p>
					</div>
				</div>
				<div class="input-group row justify-content-center mt-0 mb-2">
					<div class="col-5">
						<input class="form-control" type="password" name="pw"
							required="required">
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-5 text-left">
						<p class="mb-0">nick</p>
					</div>
				</div>
				<div class="input-group row justify-content-center mt-0 mb-2">
					<div class="col-5">
						<input class="form-control" type="text" name="nick"
							required="required">
					</div>
				</div>


				<div class="row justify-content-center">
					<div class="col-5 text-left">
						<p class="mb-0">name</p>
					</div>
				</div>
				<div class="input-group row justify-content-center mt-0 mb-2">
					<div class="col-5">
						<input class="form-control" type="text" name="name"
							required="required">
					</div>
				</div>
				
				<div class="row justify-content-center">
					<div class="col-5 text-left">
						<p class="mb-0">tel</p>
					</div>
				</div>
				<div class="input-group row justify-content-center mt-0 mb-2">
					<div class="col-5">
						<input class="form-control" type="tel" name="tel"
							required="required">
					</div>
				</div>

				<div class="row justify-content-center">
					<div class="col-5 text-left">
						<p class="mb-0">line</p>
					</div>
				</div>
				<div class="input-group row justify-content-center mt-0 mb-5">
					<div class="col-5">
						<select class="custom-select" name="line">
							<!--<option selected disabled="disabled">Choose...</option>-->
							<option value="top">top</option>
							<option value="mid">mid</option>
							<option value="jg">jg</option>
							<option value="ad">ad</option>
							<option value="sup">sup</option>
						</select>
					</div>
				</div>
				<input class="btn btn-secondary" type="submit" value="continue">
			</form>
		</div>
	</div>
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
