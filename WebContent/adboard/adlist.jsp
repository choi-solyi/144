<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<ul class="list-group-item list-group-flush mt-3">
			<li class="list-group-item list-group-item-dark">[카테고리] 글번호,
				글제목, 글작성일, 글조회수, 추천수, 작성자</li>
			<c:forEach var="i" items="${list}">
				<li class="list-group-item list-group-item-action"><a
					href="JWdetail.do?bno=${i.bno}">[${i.bcategory}] ${i.bno},
						${i.btitle}, ${i.bwritedate}, ${i.bhit}, ${i.bup}, ${i.id}</a></li>
			</c:forEach>
			<li class="list-group-item">
				<div class="row justify-content-center mb-3">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</div>
				<form method="post" action="JWlist.do">
					<div class="form-group row ">
						<div class="col-sm-2">
							<select class="form-control" name="search">
								<option value="btitle">제목</option>
								<option value="bcontent">내용</option>
								<option value="id">작성자</option>
							</select>
						</div>
						<div class="col-sm-9">
							<input class="form-control" type="text" name="searchtxt">
						</div>
						<div class="col-sm-1">
							<input class="btn btn-secondary" type="submit" value="검색">
						</div>
					</div>
				</form> <a class="btn btn-secondary" href="JWlist.do">목록</a> <a
				class="btn btn-secondary" href="JWinsert.do">글쓰기</a>
			</li>
		</ul>
	</div>
</body>
</html>