<%@page import="com.sb.dto.SUPBoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>롤 링</title>
<style>
.insertsub {
	text-align: right;
	margin-bottom: 10px;
	margin-top: 15px;
}
</style>
</head>
<body>
	<c:set var="list" value="${requestScope.list }" />
	<c:set var="currpage" value="${requestScope.currpage}"></c:set>
	<c:set var="startblock" value="${requestScope.startblock}"></c:set>
	<c:set var="endblock" value="${requestScope.endblock}"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage}"></c:set>
	<c:set var="search" value="${requestScope.search}"></c:set>
	<c:set var="txtsearch" value="${requestScope.txtsearch}"></c:set>
	
	<div class="container">

		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col" style="width: 100px;">번호</th>
					<th scope="col" style="width: 150px;">카테고리</th>
					<th scope="col" style="width: 250px;">제목</th>
					<th scope="col" style="width: 150px;">닉네임</th>
					<th scope="col" style="width: 150px;">작성일</th>
					<th scope="col" style="width: 150px;">조회수</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="item" items="${list}">
					<tr>
						<td scope="row">${ item.bno}</td>
						<td>${item.bcategory}</td>
						<td><a href="sbdetail.do?bno=${item.bno}">${item.btitle}</a></td>
						<td>${item.nick}</td>
						<td>${item.bwritedate}</td>
						<td>${item.bhit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${startblock>1}">
					

					<a href="sblist.do?curr=${startblock-1}">이전</a>

		</c:if>
	
		<c:forEach var="i" begin="${startblock}" end="${endblock }" step="1">
			<c:if test="${currpage==i}">
				<c:out value="${i}" />
			</c:if>
			<c:if test="${currpage!=i}">
				<a
					href="sblist.do?curr=${i}&search=${search}&txtsearch=${txtsearch}">${i}</a>
			</c:if>

		</c:forEach>
		<c:if test="${endblock < totalpage}">
					

			<a href="sblist.do?curr=${endblock+1}">다음</a>

		</c:if>


		<form method="get" action="sblist.do">
			<select name="search">
				<option value="btitle">글제목</option>
				<option value="bcontent">내용</option>
				<option value="nick">작성자</option>
			</select> <input type="text" name="txtsearch"> <input type="submit"
				value="검색">
		</form>





		<div class="insertsub">
			<a href="sbinsert.do" class="btn btn-primary btn-lg active"
				role="button" aria-pressed="true"
				style="width: 200px; background-color: silver; border: 3px solid silver; color: black;">글쓰기</a>
		</div>
	</div>
	<div class="input-group">
		<input type="text" class="form-control" placeholder="소환사명을 입력하세요">
		<div class="input-group-btn">
			<button class="btn btn-default" type="button">전적검색</button>
		</div>
	</div>
	
	<!-- /input-group -->



</body>
</html>