<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/list.css" type="text/css">
<style type="text/css">
#dy_midboardwrap {
	width: 100%;
	height: 1500px;
}

#dy_bgimg {
	border: 1px solid black;
	width: 100%;
	height: 450px;
	background-image:;
	text-align: center;
}

#dy_bgimg p {
	font-size: 40px;
}

#dy_bgimg div {
	font-size: 200px;
}

#dy_champwords {
	text-align: center;
	font-size: 40px;
	margin: 10px;
}

#bhitlist {
	margin: 0px auto;
	border: 1px solid black;
	width: 500px;
	height: 100px;
}

#writebtn {
	
}

#dy_boardhead {
	border: 1px solid black;
	width: 1020px;
	height: 50px;
	margin: 0px auto;
	text-align: center;
}

#dy_boardhead div {
	display: inline-block;
	margin-top: 15px;
}

.dy_bno {
	width: 10%;
}

.dy_btitle {
	width: 40%;
}

.dy_nick {
	width: 20%;
}

.dy_bwritedate {
	width: 10%;
}

.dy_bhit {
	width: 10%;
}
</style>

</head>
<body>
	<c:set var="currpage" value="${currpage }" />
	<c:set var="startblock" value="${startblock }" />
	<c:set var="endblock" value="${endblock }" />
	<c:set var="totalpage" value="${totalpage }" />
	<c:set var="search" value="${search }" />
	<c:set var="txtsearch" value="${txtsearch }" />

	<div id="dy_midboardwrap">
		<div id="dy_bgimg">
			<p>우리는 승패의 중심</p>
			<div>MID</div>
		</div>
		<p id="dy_champwords">"챔피언 대사"</p>
		<div id="bhitlist">(댓글수에 따른 상단 리스트)</div>
		<div id="boardwrap">
			<select id="dy_category">
				<option value="옵션1">옵션1</option>
				<option value="옵션1">옵션2</option>
				<option value="옵션1">옵션3</option>
			</select> <a href="dyinsert.do"><input type="button" name="write"
				id="write" value="글쓰기"></a>

			<div id="dy_boardhead">
				<div class="dy_bno">번호</div>
				<div class="dy_btitle">제목</div>
				<div class="dy_nick">글쓴이</div>
				<div class="dy_bwritedate">등록일</div>
				<div class="dy_bhit">조회</div>

				<c:forEach var="list" items="${list }">
					<div class="dy_bno">
						<c:out value="${list.bno }" />
					</div>
					<div class="dy_btitle">
						<a href="dydetail.do?bno=${list.bno}"><c:out
								value="${list.btitle }" /></a>
					</div>
					<div class="dy_nick">
						<c:out value="${list.nick }" />
					</div>
					<div class="dy_bwritedate">
						<c:out value="${list.bwritedate }" />
					</div>
					<div class="dy_bhit">
						<c:out value="${list.bhit }" />
					</div>

					<c:if test="${sessionScope.id == list.id }">
						<div>
							<a href="dydelete.do?bno=${list.bno }"> <input type="button"
								value="삭제"></a>
						</div>
					</c:if>

				</c:forEach>

				<c:forEach var="i" begin="${starblock }" end="${endblock }" step="1">
					<c:if test="${currpage==i }">
						<c:out value="${i }" />
					</c:if>
					<c:if test="${currpage!=i }">
						<a
							href="dylist.do?curr=${i}&search=${search}&txtsearch=${txtsearch}">${i}</a>
					</c:if>

				</c:forEach>

				<form action="dylist.do" method="post">
					<select name="searh">
						<option value="btitle">제목</option>
						<option value="bcontent">내용</option>
						<option value="nick">작성자</option>
					</select> <input type="text" name="txtsearch"> <input type="submit"
						value="검색">
				</form>
			</div>
		</div>

	</div>
</body>
</html>