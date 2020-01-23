<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/list.css" type="text/css">
<style type="text/css">
#dy_midboardwrap {
	width: 100%;
	height: 1500px;
}

#dy_bgimg {
	width: 100%;
	height: 40%;
	background-image: url(dyboard/img/main01.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center center;
	text-align: center;
	border: none;
	margin: 0px;
	padding: 0px;
}

#dy_bgimg p {
	padding-top: 30px;
	font-size: 40px;
	margin: 0px;
	color: white;
}

#dy_bgimg div {
	font-size: 250px;
	color: white;
	margin: 30px auto;
	position: relative;
	right: 25px;
}

#dy_champwords {
	text-align: center;
	font-size: 40px;
	margin: 10px auto;
	background-color: lightgrey;
	color: white;
	width: 80%;
}

#boardwrap {
	/* border: 1px solid black; */
}

#dy_boardheader {
	background-color: dodgerblue;
	color: white;
	width: 70%;
	margin: 0px auto;
	text-align: center;
}

#dy_boardheader ul {
	margin: 0px;
	padding: 0px;
}

#dy_boardheader ul li {
	list-style: none;
	display: inline-block;
	margin: 0px 45px;
	padding: 20px;
}

#dy_boardlist {
	color: black;
	width: 70%;
	margin: 0px auto;
	text-align: center;
}

#dy_boardlist ul {
	margin: 0px;
	padding: 0px;
}

#dy_boardlist ul li {
	list-style: none;
	margin : 0px;
}

#dy_boardlist ul li div {
	background-color: whitesmoke;
	list-style: none;
	display: inline-block;
	margin: 0px;
	padding: 20px;
	width: 15%;
}

#dy_eachlist {
	width: 70%;
	margin: 0px auto;
}

#pagingwrap {
	
	width: 100px;
	margin: 0px auto;
}
#searchwrap{
	
	width : 400px;
	margin : 0px auto;
	
}

</style>

</head>
<body>
	<c:set var="list" value="${requestScope.list }" />
	<c:set var="currpage" value="${requestScope.currpage }" />
	<c:set var="startblock" value="${requestScope.startblock }" />
	<c:set var="endblock" value="${requestScope.endblock }" />
	<c:set var="totalpage" value="${requestScope.totalpage }" />
	<c:set var="search" value="${requestScope.search }" />
	<c:set var="txtsearch" value="${requestScope.txtsearch }" />

	<!--게시판 헤더 이미지  -->
	<div id="dy_midboardwrap">
		<div id="dy_bgimg">
			<p>우리는 승패의 중심</p>
			<div>MID</div>
		</div>
		<p id="dy_champwords">"경외하라. 난 섬기는 이 없는 암살자다."</p>
		<!-- 게시판  -->
		<div id="boardwrap">

			<div id="dy_boardheader">
				<ul>
					<li class="dy_bno">번호</li>
					<li class="dy_bcategory">카테고리</li>
					<li class="dy_btitle">제목</li>
					<li class="dy_nick">작성자</li>
					<li class="dy_bwritedate">작성일</li>
					<li class="dy_bhit">조회</li>
				</ul>
			</div>
			<div id="dy_boardlist">
				<ul>
					<div id="eachlist">
						<c:forEach var="list" items="${list }">
							<li>
								<div class="dy_bno">
									<c:out value="${list.bno }" />
								</div>
								<div class="dy_bcategory">
									<c:out value="${list.bcategory }" />
								</div>
								<div class="dy_btitle">
									<a href="dydetail.do?bno=${list.bno}"><c:out
											value="${list.btitle }" /></a>
								</div>
								<div class="dy_nick">
									<c:out value="${list.nick }" />
								</div>
								<div class="dy_bwritedate">
									<c:out value="${list.bwritedate }" />
								</div>
								<div class="dy_bhit">
									<c:out value="${list.bhit }" />
								</div> <c:if test="${sessionScope.id == list.id }">
									<a href="dydelete.do?bno=${list.bno }"><input type="button" id="dy_delbtn" value="삭제"></a>
								</c:if>
							</li>
							<br>
						</c:forEach>
					</div>
				</ul>
			</div>
			<br> <br> <br>
			
			<!-- test -->
			
			

			<!-- 페이징 -->
			
			
			<div id="pagingwrap">
				<nav aria-label="Page navigation example">
				<ul class="pagination">
				
				<c:if test="${startblock>1}">
					<li class="page-item"><a class="page-link" href="dylist.do?curr=${startblock-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
				</c:if>	
				
				<c:forEach var="i" begin="${startblock}" end="${endblock }" step="1">
					<c:if test="${currpage==i }"><li class="page-item"><a class="page-link" href="#"><c:out value="${i }" /></a></li></c:if>
					<c:if test="${currpage!=i }"><li class="page-item"><a class="page-link" href="dylist.do?curr=${i}&search=${search}&txtsearch=${txtsearch}">${i} </a></li></c:if>
				</c:forEach>	
					
				<c:if test="${endblock < totalpage }">	
					<li class="page-item"><a class="page-link" href="dylist.do?curr=${endblock+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a></li>
				</c:if>
				</ul>
			</nav>
			</div>
		
		
				<!-- 검색 -->
			<div id="searchwrap">
				<form action="dylist.do" method="post">
					<select name="search">
						<option value="btitle">제목</option>
						<option value="bcontent">내용</option>
						<option value="nick">작성자</option>
					</select> 
					<input type="text" name="txtsearch" id="searchbar"> 
					<input type="submit" value="검색">
				<!-- 글쓰기 버튼 -->
				<a href="dyinsert.do"><input type="button" name="write"
					id="dy_write" value="글쓰기"></a>
				</form>
			</div>
			<!-- PAGINGWRAP -->
		</div><!-- BOARDWRAP -->
	</div><!--MIDBOARDWRAP  -->
</body>
</html>