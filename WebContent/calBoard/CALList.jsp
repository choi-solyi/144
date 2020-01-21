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
	color: #404040;
}
</style>
</head>
<body>
	<div class="container mt-5 text-center">

		<div class="jumbotron">
			<h1>대회 일정</h1>
		</div>

		<dl class="row bg-primary">
			<dt class="col-md-2">번호</dt>
			<dt class="col-md-3">날짜</dt>
			<dt class="col-md-3">제목</dt>
			<dt class="col-md-2">조회수</dt>
			<dt class="col-md-2">추천</dt>
		</dl>

		<c:forEach items="${requestScope.list}" var="index">
			<dl class="row">
				<dt class="col-md-2">
					<a href="EBdetail.do?bno=${index.bno}">${index.bno}</a>
				</dt>
				<dt class="col-md-3">
					<a href="EBdetail.do?bno=${index.bno}">${index.bcaldate}</a>
				</dt>
				<dt class="col-md-3">
					<a href="EBdetail.do?bno=${index.bno}">${index.btitle}</a>
				</dt>
				<dt class="col-md-2">
					<a href="#">${index.bhit}</a>
				</dt>
				<dt class="col-md-2">
					<a href="#">${index.bup}</a>
				</dt>
			</dl>
		</c:forEach>

		<c:set var="master" value="b@b" />
		<c:if test="${sessionScope.id == master}">
			<div class="col-sm-12 text-left m-2">
				<a href="EBinsert.do" class="btn btn-primary">글 작성</a>
			</div>
		</c:if>


		<!-- 검색 -->
		<form method="post" action="EBlist.do">
			<select name="search">
				<option value="btitle">제목</option>
				<option value="bcontent">내용</option>
			</select> <input type="text" name="searchtxt"> <input type="submit"
				value="검색">
		</form>





		<!-- 페이징 -->

		<div class="justify-content-center row">
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
					<li class="page-item">
					<a class="page-link" href="EBlist.do?curr=${index}">${index}</a>
					</li>
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