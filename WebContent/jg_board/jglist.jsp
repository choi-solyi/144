<%@page import="java.util.List"%>
<%@page import="com.sy.dto.JGBoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>롤 링</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<style>
.articlesoly {
	margin: 0;
	padding:;
}

#bgimg {
	padding: 0;
	margin: -5px;
}

/* ul li */
#bgimg1, #bgimg2, #bgimg3 {
	padding: -5px;
	margin: -5px;
	display: inline-block;
}

#bgimg1 {
	padding: -3px;
	width: 33.6%;
	height: 400px;
	background-image:url(http://choisolyi.dothome.co.kr/lol/img/jg1_1.png);
	background-repeat: no-repeat;
	background-position: center top;
}

#bgimg2 {
	padding: -3px;
	width: 33.6%;
	height: 400px;
	
	background-image: url(http://choisolyi.dothome.co.kr/lol/img/jg1_4.jpg);
	background-repeat: no-repeat;
	background-position: top;

	/* background-attachment: fixed;*/
}

#bgimg3 {
	padding: -3px;
	width: 33.6%;
	height: 400px;
	background-image:url(http://choisolyi.dothome.co.kr/lol/img/jg1_3.jfif);
	background-repeat: no-repeat;
	background-position: top;
}

.imglinetop {
	color: white;
	width: 60%;
	height: 60px;
	margin: 0 auto;
	text-align: center;
	font-size: 2.3em;
	position: relative;
	bottom: 240px;
	border-radius: 10px;
	padding: 1px 0px 0px 0px;
	font-size: 6em;
	font-weight: 900;
}

.imglines {
	width: 60%;
	height: 60px;
	margin: 0 auto;
	text-align: center;
	font-size: 2.3em;
	background-color: rgb(255, 255, 255, 0.88);
	position: relative;
	bottom: 150px;
	border-radius: 10px;
	padding: 1px 0px 0px 0px;
}

.gesipan {
	width: 1400px;
	height: 600px;
	border: 1px solid black;
	margin: 30px auto;
	padding: 20px;
}

.gesipantitle {
	width: 1400px;
	border: 1px solid black;
	margin: 0px auto 30px;
	padding: 20px;
	border-radius: 20px;
	font-size: 2.2em;
	font-weight: 600;
}

.titles {
	text-align: 0 auto;
}

.jgboarddiv {
	margin: 30px auto;
	width: 1400px;
}

.jgboardTitle {
	margin: 0 auto;
	list-style: none;
	border-radius: 3px;
}

.jgboardTitle li {
	display: inline-block;
	padding: 20px 0px;
	background-color: cornflowerblue;
	font-size: 1.1em;
	color: white;
}

.jgboardContent {
	margin: 0 auto;
	list-style: none;
}

.jgboardContent li {
	display: inline-block;
	/* border: 1px solid cornflowerblue; */
	padding: 15px 0px;
}

.bno, .bcategory, .brepcount {
	width: 110px;
	text-align: center;
	border-radius: 3px;
}

.jgnick, .bwritedate, .bhit {
	width: 150px;
	text-align: center;
	border-radius: 3px;
}

.btitle {
	width: 500px;
	text-align: center;
}

.botpage {
	margin: 10px 600px;
}

.botwrite {
	float: left;
}

.botsearch {
	float: right;
}

.changebgcolor {
	background-color: black;
}

.jgboardContent:hover {
	background-color: rgb(240, 240, 240, 0.5);
	width: 1400px;
}


.pagingbtn{
	display:inline-block;
	width: 35px;
	height : 35px;
	padding:2px;
	border : 1px solid silver;
	border-radius: 5px;
	font-size: 1.2em;
	}

.pagingbtnw{
	width:60px;
	
}
	


.allpaging{
	width: 300px;
	margin : 10px auto;
	text-align: center;
}

</style>

</head>
<body>

<%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
System.out.println("abcabc");
String abc = (String)session.getAttribute("id");
System.out.println("세션아이디: " + 	abc);

if (session.getAttribute("id") == null) {
    response.sendRedirect("../index.jsp");
}
%>
	<!-- 상단이미지 -->

	<article id="articlesoly">
		<ul id="bgimg">
			<li id="bgimg1"></li>
			<li id="bgimg2"></li>
			<li id="bgimg3"></li>
		</ul>

		<p class="imglinetop">J U N G L E</p>
		<p class="imglines">
			<I> "이제 고통을 안겨줄 새로운 녀석을 찾아야겠군."</I>
		</p>

		<div class="gesipantitle">
			<p class="titles">정글 게시판</p>
		</div>

		<!-- 상단이미지 끝  -->
		<!-- 글번호-카테-제목[count]-닉네임-작성일-조회수 -->

		<div class="jgboarddiv">
			<ul class="jgboardTitle ">
				<li class="bno">글번호</li>
				<li class="bcategory">카테고리</li>
				<li class="btitle">제목</li>
				<li class="bwritedate">작성일</li>
				<li class="bhit">조회수</li>
			</ul>
			<c:set var="list" value="${requestScope.list}" />
			<c:set var="currPage" value="${requestScope.currPage}"></c:set>
			<c:set var="startBlock" value="${requestScope.startBlock}"></c:set>
			<c:set var="endBlock" value="${requestScope.endBlock}"></c:set>
			<c:set var="totalPage" value="${requestScope.totalPage}"></c:set>
			<c:set var="search" value="${requestScope.search}"></c:set>

			<c:forEach var="item" items="${list}">
				<ul class="jgboardContent">
					<li class="bno"><c:out value="${item.bno }" /></li>
					<li class="bcategory"><c:out value="${item.bcategory }" /></li>


					<li class="btitle"><a href="jgdetail.do?bno=${item.bno}"><c:out
								value="${item.btitle }" /></a></li>


					<%-- <li class="jgnick"><c:out value="${item.nick }" /></li> --%>
					<li class="bwritedate"><c:out value="${item.bwritedate }" /></li>
					<li class="bhit"><c:out value="${item.bhit }" /></li>
				</ul>
			</c:forEach>



<div class="allpaging">
<!-- 이전페이지 -->
<c:if test="${startBlock>1}">
					<div class="pagingbtn pagingbtnw">

					<a href="jglist.do?curr=${startBlock-1}">이전</a>
</div>
</c:if>


<!-- 숫자부분 -->
			<c:forEach var="i" begin="${startBlock}" end="${endBlock }" step="1">
				<c:if test="${currPage==i}">
					<div class="pagingbtn">
					
					<c:out value="${i}" />
					</div>
				</c:if>
				<c:if test="${currPage!=i}">
					<%-- <a href="main.jsp?page=jg_board/jglist.jsp?curr=${i}">${i} </a> --%>
						<div class="pagingbtn">
					<a href="jglist.do?curr=${i}&search=${search}">${i}</a>
					</div>
				</c:if>
			</c:forEach>
			
			

<!-- 다음페이지 -->			
<c:if test="${endBlock < totalPage}">
					<div class="pagingbtn pagingbtnw">

	<a href="jglist.do?curr=${endBlock+1}">다음</a>
</div>
</c:if>


</div>

			<!-- 글쓰기 버튼 -->
			<div class="botwrite">
				<div class="bottomMenu">
					<a href="jginsert.do">
						<button type="button" class="btn btn-success">글쓰기</button>
					</a>
				</div>

			</div>


			<!-- 검색 창 -->

			<div class="botsearch">
				<form method="post" action="jglist.do" class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search" name="search" id="search"
						placeholder="게시글 검색" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>

		</div>

	</article>


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