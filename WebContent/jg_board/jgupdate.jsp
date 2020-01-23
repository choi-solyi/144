<%@page import="com.sy.service.JGBoardService"%>
<%@page import="com.sy.dao.JGBoardDAO"%>
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
	background-image: url(http://choisolyi.dothome.co.kr/lol/img/jg1_2.jfif);
	background-repeat: no-repeat;
	background-position: right center;
}

#bgimg2 {
	padding: -3px;
	width: 33.6%;
	height: 400px;
	background-image:
		url('http://choisolyi.dothome.co.kr/lol/img/jg1_1.png');
	background-repeat: no-repeat;
	background-position: top;

	/* background-attachment: fixed;*/
}

#bgimg3 {
	padding: -3px;
	width: 33.6%;
	height: 400px;
	background-image:
		url("http://choisolyi.dothome.co.kr/lol/img/jg1_3.jfif");
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

/*  */
.formsize {
	width: 1200px;
	padding: 30px;
	margin: 0 auto;
}
</style>
</head>

<body>
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
	</article>
	<!-- 상단이미지 끝  -->
	<%
		int bno = Integer.parseInt(request.getParameter("bno"));
		JGBoardService service = JGBoardService.getService();
		JGBoardDTO dto = service.detail(bno);
	%>
	<c:set var="dto" value="${requestScope.dto }"/>
	<form action="jgupdateresult.do" method="post" class="formsize">
		<div class="form-group">
			<label for="nick">작성자</label> 
			<input type="text" class="form-control"	name="nick" id="nick" value="${dto.nick }" 	readonly="readonly">
			<input type="hidden" name="bno" id="bno" value="<%=bno %>">
		</div>

		<div class="form-group">
			<label for="bcategory">카테고리</label> 
			<select class="form-control" id="bcategory" name="bcategory">
				<option value="잡담">잡담</option>
				<option value="꿀팁">꿀팁</option>
				<option value="정보">정보</option>
				<option value="질문">질문</option>
				<option value="버그">버그</option>
			</select>
		</div>

		<div class="form-group">
			<label for="btitle">제목</label> 
			<input type="text" class="form-control" name="btitle" id="btitle" 
			required="required"	value="<%=dto.getBtitle()%>">
		</div>

		<div class="form-group">
			<label for="bcontent">내용</label>
			<textarea class="form-control" id="bcontent" name="bcontent"
				rows="15"><%=dto.getBcontent()%></textarea>
		</div>

		<div>

			<input type="submit" class="btn btn-success" value="수정"> 
			<input type="reset" class="btn btn-secondary" value="취소">
		</div>
	</form>



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