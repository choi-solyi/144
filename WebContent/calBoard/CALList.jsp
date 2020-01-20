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

</head>
<body>
	<div class="container mt-5">

		<div class="jumbotron">
			<h2>대회 일정</h2>
		</div>

		<div class="row">
			<div class="col">번호</div>
			<div class="col">날짜</div>
			<div class="col">제목</div>
			<div class="col">조회수</div>
			<div class="col">추천</div>
		</div>

		<div>
			<c:forEach items="${requestScope.list}" var="index">
				<div>
					<a href="EBdetail.do?bno=${index.bno}">${index.bno}</a> <a
						href="EBdetail.do?bno=${index.bno}">${index.bcaldate}</a> <a
						href="EBdetail.do?bno=${index.bno}">${index.btitle}</a>
					${index.bhit} ${index.bup}
				</div>
			</c:forEach>
		</div>

		<div class="col-sm-12 text-left m-2">
			<a href="EBinsert.do" class="btn btn-primary">글 작성</a>
		</div>

		<c:if test="${startblock>1}">
			<a href="EBlist.do?curr=${startblock-1}">이전</a>
		</c:if>

		<c:forEach var="index" begin="${startblock}" end="${endblock}"
			step="1">
			<a href="EBlist.do?curr=${index}">${index}</a>
		</c:forEach>

		<c:if test="${endblock<totalpage}">
			<a href="EBlist.do?curr=${endblock+1}">다음</a>
		</c:if>
		<form method="post" action="EBlist.do">
		<select name="search">
			<option value="btitle">제목</option>
			<option value="bcontent">내용</option>
		</select> <input type="text" name="searchtxt"> <input type="submit" value="검색">
		</form>

	</div>
</body>

</html>