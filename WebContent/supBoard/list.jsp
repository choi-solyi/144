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
	.insertsub{
		text-align: right;
		margin-bottom: 10px;
		margin-top:15px;
	}
</style>
</head>
<body>
	<c:set var="list" value="${requestScope.list }" />

	<div class="container">

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">카테고리</th>
					<th scope="col">제목</th>
					<th scope="col">닉네임</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>	
				</tr>
			</thead>
			
			<tbody>
			  <c:forEach var="item" items="${list}">
				<tr>
					<td scope="row">${ item.bno}</td>
					<td>${item.bcategory}</td>
					<td><a href="sbdetail.do?bno=${item.bno}">${item.btitle}</a></td>
					<td>${item.id}</td>
					<td>${item.bwritedate}</td>
					<td>${item.bhit}</td>
				</tr>
			  </c:forEach>
			</tbody>
		</table>


		<%-- <c:forEach var="item" items="${list}">
		<ul>
		<li>${item.bno}</li>
			<li>${item.bcategory}</li>
			<li><a href="sbdetail.do?bno=${item.bno}">${item.btitle}</a></li>
			<li>${item.id}</li>
			<li>${item.bwritedate}</li>
			<li>${item.bhit}</li>
		</ul>

	</c:forEach> --%>
		<div class="insertsub">
		<a href="sbinsert.do" class="btn btn-primary btn-lg active" role="button" aria-pressed="true" style="width:200px; background-color: silver; border:3px solid silver; color:black;">글쓰기</a>
		</div>
	</div>

</body>
</html>