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

.page-item.active .page-link {

    color: #fff;
    background-color: gray;
    border-color: gray;
}

.page-link {
    color: gray;

}
	
</style>
</head>
<body>		
	<div class="container">
	<div class="row justify-content-center" style="min-width : 100%">
	<img alt="이미지" src="img/one.JPG">
	</div>
		<ul class="list-group list-group-flush mt-3">
			<li class="list-group-item list-group-horizontal list-group-item-dark pt-3 pl-3 pr-3 pb-2 m-0 d-flex justify-content-between">
				<h3>번호</h3><h3>제목</h3><h3>글쓴이</h3><h3>등록일</h3><h3>조회</h3><h3>추천</h3>
		 <c:forEach var="i" items="${list}">
		
			<li class="list-group-item list-group-item-action p-3"><a
					href="JWdetail.do?bno=${i.bno}" class="d-flex justify-content-between"><span>${i.bno} [${i.bcategory}]</span><span>${i.btitle}<span class="badge badge-pill badge-secondary">${i.repcount}</span></span><span> ${i.nick}</span> <span>${i.bwritedate}</span> <span>${i.bhit}</span> <span>${i.bup}</span></a></li>
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
									<option value="nick">작성자</option>
								</select>
							</div>
							<input type="text" class="form-control" name="searchtxt">
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