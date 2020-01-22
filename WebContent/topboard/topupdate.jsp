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

		.top_update_form{
			width: 1200px;
            margin: 40px auto 0px auto;
		}
        .tupdate{
            margin: 5px 0px 5px 20px;
            height: 25px;
        }
        .tupdate1{
            display: inline-block;
            width: 70px;
            margin: 5px 0px 5px 20px;
        }
        .top_update_nick{
        	margin : 0px
        }
        .top_update_content{
            margin: 0px 0px 0px 20px;
        }
        .top_update_updateinput, .top_update_cancelinput{
            width: 80px;
            height: 40px;
            font-size: 1.5em;
            margin: 20px 0px 20px 20px;
        }
        
</style>
</head>
<body>
<c:set var = "dto" value = "${requestScope.dto }"></c:set>
<div id = "top_update_wrap">
<form class = "top_update_form" method = "post" action = "topupdateresult.do">
	<input type = "hidden" name = "no" id = "no" value = '<c:out value="${dto.bno }"></c:out>'>
	<label class = "tupdate1 top_update_titlelabel" for = "title">제목</label>
    <input class = "tupdate top_update_title" name = "title" id = "title"
     value = '<c:out value="${dto.btitle }"></c:out>' required="required"><br>
    <label class = "tupdate1 top_update_categorylabel" for = "category">분류</label>
    <select class = "tupdate top_update_category" name = "category">
        <option value = "">분류</option>
		<option value = "[일반]">일반</option>
		<option value = "[정보]">정보</option>
		<option value = "[질문]">질문</option>
		<option value = "[인증]">인증</option>
		<option value = "[토론]">토론</option>
		<option value = "[공지]">공지</option>
    </select><br>
    <input class = "tupdate top_update_nick" type = "hidden" name = "nick" id = "nick" 
    value = '<c:out value="${dto.id }"></c:out>' required="required"><br>
    <textarea class = "top_update_content" rows="30" cols="161" name = "content" id = "content"
     required="required"><c:out value="${dto.bcontent }"></c:out></textarea><br>
    <input class = "top_update_updateinput" type = "submit" value = "수정">
	<input class = "top_update_cancelinput" type = "reset" value = "취소">

</form>
</div>
</body>
</html>