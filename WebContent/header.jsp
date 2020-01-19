<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
<title>롤 링</title>



<!--solyi-->
<style>
@charset "UTF-8";

/*nav 링크 간격*/
.nav-item {
	padding: 0px 5px;
}

/*HOME 버튼 색상*/
.navbar-light .navbar-brand {
	color: #f6ff8e;
}

/* menu 버튼 색상*/
.navbar-light .navbar-nav .nav-link {
	color: white;
}

/* dropdown버튼 눌렀을때 나오는 컬러*/
.navbar-light .navbar-nav .active>.nav-link, .navbar-light .navbar-nav .nav-link.active,
	.navbar-light .navbar-nav .nav-link.show, .navbar-light .navbar-nav .show>.nav-link
	{
	color: white;
}

/* search 버튼 */
.btn-outline-success {
	color: white;
	border-color: white;
}
/* search hover color*/
.btn-outline-success:hover {
	background-color: #f6ff8e;
	color: black;
}

/* menu hover color*/
.navcolor a:hover {
	color: #f6ff8e !important;
	font-weight: 700;
}

.navcolor a:link, .navcolor a:active {
	color: white !important;
}

.navcolor a {
	font-weight: 500;
}

.navlink a {
	color: white !important;
}
</style>


</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light navcolor"
		style="background-color: #255ad4;">
		<a class="navbar-brand" href="#"><b style="font-size: 1.2em;">롤
				링</b></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false" style="color: white;"> POSITION </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						
						
						<a class="dropdown-item" href="toplist.do">TOP</a> 
						
						<a class="dropdown-item" href="jglist.do">JUNGLE</a> 
							
							<a class="dropdown-item" href="dylist.do">MID</a> <a
							class="dropdown-item" href="JWlist.do">AD</a> 
							
							<a class="dropdown-item" href="sblist.do">SUP</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="logout.jsp">로그아웃</a>
					</div></li>
				<!--  
                <li class="nav-item">
                    <a class="nav-link" href="#">Link1</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link2</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link3</a>
                </li>
               
              <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>-->
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="EBlist.do"
					style="color: white;"> 대회 일정</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					style="color: white;">쇼핑</a></li>
				<!--    <li class="nav-item">
                    <a class="nav-link" href="#">Link3</a>
                </li>-->

				<li class="nav-item">
					<form method="post" action="search.do" class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search"
							placeholder="소환사명 입력" aria-label="Search" name="summoner" id="summoner">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
				</li>


			</ul>
		</div>
	</nav>
</body>

</html>