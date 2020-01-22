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
	.bg{
		display: inline-block;
		
	}

	.bg1{
		width:470px;		
		
	}
	

</style>

<script>
	
	if(${re>0}){
		alert('작성완료. 10cp가 적립되었습니다.');
	}
	

</script>
	

</head>
<body>
	
	<c:set var="list" value="${requestScope.list }" />
	<c:set var="currpage" value="${requestScope.currpage}"></c:set>
	<c:set var="startblock" value="${requestScope.startblock}"></c:set>
	<c:set var="endblock" value="${requestScope.endblock}"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage}"></c:set>
	<c:set var="search" value="${requestScope.search}"></c:set>
	<c:set var="txtsearch" value="${requestScope.txtsearch}"></c:set>
	<c:set var="rcount" value="${requestScope.rcount }"/>
	<c:set var="re" value="${requestScope.re }"/>
	
	
	
	
	
	
	<div class="bg">
			<img src=supBoard/img/sup1.jpg class="bg1">
	</div>
	<div class="bg">
			<img src=supBoard/img/sup2.jpg class="bg1">
	</div>
	<div class="bg">
			<img src=supBoard/img/sup3.jpg class="bg1">
	</div>
	<div class="bg">
			<img src=supBoard/img/sup4.jpg class="bg1">
	</div>
	<div class="container">
		
	
	
		<div style="text-align: center; margin-bottom: 50px; margin-top:50px;">
		<h1>S U P P O R T E R</h1>
		</div>
		
		<table class="table table-hover">
		
			<thead class="thead-dark">
				<tr style="text-align: center;">
					<th scope="col" >번호</th>
					<th scope="col">카테고리</th>
					<th scope="col" style="width:300px;" >제목</th>
					<th scope="col" >닉네임</th>
					<th scope="col" >작성일</th>
					<th scope="col" >조회수</th>
					
				</tr>
			</thead>

			<tbody>
				<c:forEach var="item" items="${list}">
					<tr style="text-align: center;">
						<td scope="row">${ item.bno}</td>
						<td>${item.bcategory}</td>
						<td><a style="text-decoration: none;"  href="sbdetail.do?bno=${item.bno}">${item.btitle}</a></td>
						<td>${item.nick}</td>
						<td>${item.bwritedate}</td>
						<td>${item.bhit}</td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
		<c:if test="${startblock>1}">
					
					<li class="page-item">
					<a  class="page-link" href="sblist.do?curr=${startblock-1}"  aria-label="Previous">이전</a>
					</li>
		</c:if>
	
		<c:forEach var="i" begin="${startblock}" end="${endblock }" step="1">
			<li class="page-item">
			<c:if test="${currpage==i}">
				 <a class="page-link" href="#">${i}</a> <%-- <c:out  value="${i}" /> --%>
			</c:if>
			</li>	
			 <li class="page-item">
			  
			<c:if test="${currpage!=i}">
				<a class="page-link" href="sblist.do?curr=${i}&search=${search}&txtsearch=${txtsearch}">${i}</a>
			</c:if>
			</li>
		</c:forEach>
		 <li class="page-item">
		<c:if test="${endblock < totalpage}">
					
			
			<a class="page-link" href="sblist.do?curr=${endblock+1}" aria-label="Next">다음</a>

		</c:if>
		</li>
		</ul>
		</nav>
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
	<form method="post" action="opgg.do">
	<div class="input-group" style="width:500px; margin: 0 auto;">
		
		<input type="text" class="form-control" placeholder="소환사명을 입력하세요" name="summoner" id="summoner">
		<div class="input-group-btn" style="margin-bottom:150px;">
			<button class="btn btn-default" type="submit" >전적검색</button>
		</div>
		
	</div>
	</form>
	<!-- /input-group -->



</body>
</html>