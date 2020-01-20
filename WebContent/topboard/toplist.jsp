<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
    
    #top_wrap a{
        text-decoration : none;
        color: black;
    }    
    .top_header{
        margin: 40px auto;
        width: 1200px;
        height: 260px;
        background-size: contain;
        background-repeat: no-repeat;
        background-image: url(topboard/img/topbanner.jpg);
    }
    .top_nav{
        width: 1200px;
        margin: 0px auto;
        text-align: center;
    }
    .top_nav img{
        margin: 50px 70px;
    }
    #top_wrap section{
        margin: 0px auto;
        width: 1200px;
        border-bottom: 1px solid black;
    }
    .top_board_wrap{
        border: 1px solid black;
        border-bottom: 0px solid black;
    }
    .top_t{
        font-weight: bolder;
        text-align: center;
    }
    .top_s{
    }
    
    .top_board {
        display: inline-block;
        padding : 5px 0px;
    }
    .top_no{
        width: 50px;
        text-align: center;
        margin-left: 5px;
    }
    .top_title{
        width: 750px;
        white-space: nowrap;
        word-wrap: normal;
        text-overflow: ellipsis;
        overflow:hidden; 
        margin-bottom : -10px;
    }
    .top_nick{
        width: 120px;
        text-align: center;
    }
    .top_date{
        width: 120px;
        text-align: center;
    }
    .top_hit{
        width: 60px;
        text-align: center;
    }
    .top_up{
        width: 60px;
        text-align: center;
    }
    .top_board_paging{
        width: 1200px;
        margin: 0px auto;
        margin-top : 10px;
    }
    .top_board_paging a{
        display : inline-block;
        border: 1px solid black;
        margin-left: 10px;
        padding: 5px 10px;
        border-radius: 100px;
    }
    .top_board_paging a:first-child{
        margin-left: 0px;
    }
    .top_board_btn{
        
    }
    .top_board_no{
        display : inline-block;
        border: 1px solid black;
        margin-left: 10px;
        padding: 5px 10px;
        border-radius: 100px;
    }
    .top_board_no.on{
        background: green;
    }
    .top_board_search{
        float: right;
        font-size: 16px;
        margin: 0px auto;
    }
    select{
        width: 80px;
        height: 30px;
    }
    .top_board_search_txt{
        height: 27px;
        margin-right: 20px;
    }
    top_board_search_btn{
        margin-right: 10px;
    }
    
</style>
</head>
<body>

	<div id = "top_wrap">
	<c:set var="list" value="${requestScope.list }"></c:set>
	<c:set var="currpage" value="${requestScope.currpage }"></c:set>
	<c:set var="startblock" value="${requestScope.startblock }"></c:set>
	<c:set var="endblock" value="${requestScope.endblock }"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage }"></c:set>
	<c:set var="search" value="${requestScope.search }"></c:set>
	<c:set var="txtsearch" value="${requestScope.txtsearch }"></c:set>
	<header class = "top_header">
	
	</header>
	<nav class = "top_nav">
		<h1>오늘의 추천 챔피언</h1>
		<img src = "topboard/img/c1.jpg">
		<img src = "topboard/img/c2.jpg">
		<img src = "topboard/img/c3.jpg">
		<img src = "topboard/img/c4.jpg">
		<img src = "topboard/img/c5.jpg">
	</nav>
	
	<section class = "top_section">
		<div class = "top_board_wrap">
                <div class = "top_t top_board top_no">번호</div>
                <div class = "top_t top_board top_title">제목</div>
                <div class = "top_t top_board top_nick">작성자</div>
                <div class = "top_t top_board top_date">작성일</div>
                <div class = "top_t top_board top_hit">조회수</div>
                <div class = "top_t top_board top_up">추천수</div>
            </div>
        <c:forEach var="list" items="${list }">
        <div class = "top_board_wrap">
                <div class = "top_s top_board top_no"><c:out value="${list.bno }"></c:out></div>
                <div class = "top_s top_board top_title">
                <a href = "topdetail.do?no=${list.bno }"><c:out value="${list.bcategory }"> </c:out><c:out value="${list.btitle }"></c:out></a></div>
                <div class = "top_s top_board top_nick"><c:out value="${list.id }"></c:out></div>
                <div class = "top_s top_board top_date"><c:out value="${list.bwritedate }"></c:out></div>
                <div class = "top_s top_board top_hit"><c:out value="${list.bhit }"></c:out></div>
                <div class = "top_s top_board top_up"><c:out value="${list.bup }"></c:out></div>
            </div>
        </c:forEach>
		</section>
		<div class = "top_board_paging">
                <a href = "#" class = "top_board_btn">◀</a>
                <c:forEach var = "i" begin = "${startblock}" end = "${endblock }" step = "1">
					<c:if test = "${currpage==i }">
						<c:out value="${i }"></c:out>
					</c:if>
					<c:if test="${currpage!=i }">
						<a class = "top_board_no" href = "toplist.do?curr=${i}&search=${search}&txtsearch=${txtsearch}">${i}</a>
					</c:if>
	
				</c:forEach>
                <a href = "#" class = "top_board_btn">▶</a>
                
                <form class = "top_board_search" method="post" action = "toplist.do">
                    <select name = "search">
						<option value = "title">글제목</option>
						<option value = "content">내용</option>
						<option value = "writer">작성자</option>
					</select>
					<input class = "top_board_search_txt" type="text" name = "searchtxt">
					<input class = "top_board_search_btn" type="submit" value="검색">
                </form>
                <a href = "topinsert.do">추가</a><br>
            </div>
	
</div>
</body>
</html>