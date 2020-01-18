<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul li {
	list-style: none;
	display: inline-table;
	padding: 0px 120px;
}
</style>
</head>
<body>
	<c:set var="dto" value="${requestScope.dto}" />

	<div class="container">

		<div class="card" style="text-align: center;">
			<div class="card-header">
				<ul>
					<li>${dto.id}</li>
					<li>${dto.bwritedate}</li>
					<li>${dto.bhit}</li>
				</ul>


			</div>

		</div>
		<br>
		<p style="margin-left: 20px;" class="btn btn-outline-info">${dto.bcategory}</p>
		<br>
		<div style="text-align: center;">
			<h3>${dto.btitle}</h3>
		</div>
		<div style="margin-top: 50px; padding: 0px 30px;">
			<pre>${dto.bcontent}</pre>

		</div>

		<div style="padding: 5px 15px;">

			<a class="btn btn-secondary btn-sm" href="sbupdate.do?bno=${dto.bno}"
				role="button">수정</a> <a class="btn btn-secondary btn-sm"
				href="sbdelete.do?bno=${dto.bno}" role="button">삭제</a>

			<div style="display: inline-block; margin-left: 900px;">
				<a class="btn btn-secondary btn-sm" href="sblist.do" role="button"
					style="padding: 5px 20px;">목록</a> <a
					class="btn btn-secondary btn-sm" href="#" role="button"
					style="padding: 5px 20px;">댓글</a>
				<div></div>
			</div>
			<div style="margin-top: 20px; text-align: right; margin-right: 10px;">

				<a href="sbinsert.do" class="btn btn-primary btn-lg active"
					role="button" aria-pressed="true"
					style="width: 200px; background-color: silver; border: 3px solid silver; color: black;">글쓰기</a>

			</div>

			</div>
			<form method="post" action="sbaddrep.do" name="frm">

				<input type="hidden" name="bno" value="${dto.bno}">
				<textarea rows="3" cols="20" name="rcontent"></textarea>
				<br> <input type="hidden" id="id" name="id" value="${dto.id}}"> 
				<input type="button" onclick="send()" value="추가">
					


			</form>
		





			<%-- <ul>
			<li>${dto.id}</li>
			<li>${dto.bwritedate}</li>
			<li>${dto.bhit}</li>
			<li>${dto.bcategory}</li>
			<li>${dto.btitle}</li>
			<li>${dto.bcontent}</li>
		</ul> --%>


		</div>
</body>
</html>