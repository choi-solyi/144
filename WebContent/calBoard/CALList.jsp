<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8">
<title>Insert title here</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style>
a {
	text-decoration: none;
	color: black;
}

.jumbotron {
margin-bottom: 20px;
background-image: url("calBoard/calupload/calboard.jpg");
background-position: 0% 0%;
background-size: cover;
background-repeat: no-repeat;
color: white;
text-shadow: white 2px 2px 2	px;

}

</style>
</head>
<body>
	<div class="container mt-5 text-center">
	
		<div class="jumbotron">
		<img src="">
		 <h1 class="display-4">대회 일정</h1>
		</div>
		
		<!-- 보더 -->
		<div class="row border bg-light py-2 px-lg-4 font-weight-bold m-0">
			<div class="col-md-2">번호</div>
			<div class="col-md-3">날짜</div>
			<div class="col-md-3">제목</div>
			<div class="col-md-2">조회수</div>
			<div class="col-md-2">추천</div>
		</div>

		<c:forEach items="${requestScope.list}" var="index">
			<div
				class="row border-bottom py-1 px-lg-4 list-group-item-action m-0">
				<div class="col-md-2">
					<a href="EBdetail.do?bno=${index.bno}">${index.bno}</a>
				</div>
				<div class="col-md-3">
					<a href="EBdetail.do?bno=${index.bno}">${index.bcaldate}</a>
				</div>
				<div class="col-md-3">
					<a href="EBdetail.do?bno=${index.bno}">${index.btitle}</a>
				</div>
				<div class="col-md-2">
					<a href="#">${index.bhit}</a>
				</div>
				<div class="col-md-2">
					<a href="#">${index.bup}</a>
				</div>
			</div>
		</c:forEach>
		
		<!-- 글작성 master(b@b)만 가능-->
		<c:set var="master" value="b@b" />
		<c:if test="${sessionScope.id == master}">
			<div class="col-sm-12 text-right mt-5">
				<a href="EBinsert.do" class="btn btn-primary">글 작성</a>
			</div>
		</c:if>

		<!-- 검색 -->
		<form method="post" action="EBlist.do">
			<div class="form-row justify-content-center m-3">
				<select class="custom-select col-1" name="search">
					<option selected>선택</ option>
					<option value="btitle">제목</option>
					<option value="bcontent">내용</option>
				</select>
				<div class="col-2">
					<input type="text" class="form-control" name="searchtxt">
				</div>
				<input type="submit" class="btn btn-primary mb-3" value="검색">
			</div>
		</form>
	
		<!-- 페이징 -->
		<div class="justify-content-center row mb-4">
			<ul class="pagination">
				<c:if test="${startblock>1}">
					<li class="page-item"><a class="page-link"
						href="EBlist.do?curr=${startblock-1}"><span aria-hidden="true">&laquo;</span></a>
					</li>
				</c:if>
				<c:if test="${startblock<5}">
					<li class="page-item disabled"><a class="page-link"
						href="EBlist.do?curr=${startblock-1}"><span aria-hidden="true">&laquo;</span></a>
					</li>
				</c:if>

				<c:forEach var="index" begin="${startblock}" end="${endblock}"
					step="1">
					<c:if test="${param.curr ne index}">
						<li class="page-item"><a class="page-link"
							href="EBlist.do?curr=${index}">${index}</a></li>
					</c:if>
					<c:if test="${param.curr eq index}">
						<li class="page-item active"><a class="page-link"
							href="EBlist.do?curr=${param.curr}">${param.curr}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${endblock<totalpage}">
					<li class="page-item"><a class="page-link"
						href="EBlist.do?curr=${endblock+1}" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>

</html>