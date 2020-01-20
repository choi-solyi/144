<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
a {
	color: black;
}

.list-group-item-dark {
	font-weight: bolder;
}
</style>
</head>
<body>

	<div class="container">
		<ul class="list-group-item list-group-flush mt-3">
			<li class="list-group-item list-group-item-dark"><h5>[카테고리]
					글번호, 글제목, 글작성일, 글조회수, 추천수, 작성자</h5></li>
			<c:forEach var="i" items="${list}">
				<li class="list-group-item list-group-item-action"><a
					href="JWdetail.do?bno=${i.bno}">[${i.bcategory}] ${i.bno},
						${i.btitle}, ${i.bwritedate}, ${i.bhit}, ${i.bup}, ${i.nick}</a></li>
			</c:forEach>


			<li class="list-group-item">

				<div class="row justify-content-center mb-3">
					<ul class="pagination">

						<c:if test="${startpage>pageblock}">
							<li class="page-item"><a class="page-link"
								href="JWlist.do?curr=${startpage-pageblock}&search=${search}&searchtxt=${searchtxt}">&laquo;</a></li>
						</c:if>
						<c:if test="${startpage<pageblock}">
							<li class="page-item disabled"><a class="page-link"
								href="JWlist.do?curr=${startpage-pageblock}&search=${search}&searchtxt=${searchtxt}">&laquo;</a></li>
						</c:if>

						<c:forEach var="index" begin="${startpage}" end="${endpage}"
							step="${1}">
							<c:if test="${param.curr ne index}">
								<li class="page-item"><a class="page-link"
									href="JWlist.do?curr=${index}&search=${search}&searchtxt=${searchtxt}">${index}</a></li>
							</c:if>
							<c:if test="${param.curr eq index}">
								<li class="page-item active"><a class="page-link"
									href="JWlist.do?curr=${index}&search=${search}&searchtxt=${searchtxt}">${index}</a></li>
							</c:if>
						</c:forEach>

						<c:if test="${endpage>=pagecount}">
							<li class="page-item disabled"><a class="page-link"
								href="JWlist.do?curr=${endpage+1}&search=${search}&searchtxt=${searchtxt}">&raquo;</a></li>
						</c:if>
						<c:if test="${endpage<pagecount}">
							<li class="page-item"><a class="page-link"
								href="JWlist.do?curr=${endpage+1}&search=${search}&searchtxt=${searchtxt}">&raquo;</a></li>
						</c:if>

					</ul>
				</div>

				<form method="post" action="JWlist.do">
					<div class="form-group row ">
						<div class="input-group col-sm-12">
							<div class="input-group-prepend">
								<select class="form-control" name="search">
									<option value="btitle">제목</option>
									<option value="bcontent">내용</option>
									<option value="id">작성자</option>
								</select>
							</div>
							<input type="text" class="form-control"
								aria-label="Text input with dropdown button">
							<div class="input-group-append">
								<input class="btn btn-secondary" type="submit" value="검색">
							</div>
						</div>
					</div>
				</form> 
				<a class="btn btn-secondary" href="JWlist.do">목록</a> 
				<a class="btn btn-secondary" href="JWinsert.do">글쓰기</a>
			</li>
		</ul>
	</div>
</body>
</html>