<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
    <style>
        .top_update_form{
            width: 1200px;
            margin: 50px auto;
        }
        .top_update_label{
            display: inline-block;
            width: 80px;
            margin-top: 10px
        }
        .top_update_input, .top_update_select>option{
            height: 20px;
        }
        .top_update_content{
            margin: 0px 20px ;
        }
        .top_update_btn{
            width: 80px;
            height: 40px;
            font-size: 20px
        }
    
    </style>
</head>



<body>

	<c:set var = "dto" value = "${requestScope.dto }"></c:set>
	<c:set var = "id" value = "${requestScope.id }"></c:set>
	
    <form class = "top_update_form" method = "post" action = "topinsertresult.do">
	<label class = "top_update_label top_update_label_title" for = "title">제목</label>
	<input class = "top_update_input top_update_input_title" type = "text" name = "title" id = "title" required="required"><br>
	<label class = "top_update_label top_update_label_category" for = "category">분류</label>
	<select class = "top_update_select" name = "category">
		<option value = "">분류</option>
		<option value = "[일반]">일반</option>
		<option value = "[정보]">정보</option>
		<option value = "[질문]">질문</option>
		<option value = "[인증]">인증</option>
		<option value = "[토론]">토론</option>
		<option value = "[공지]">공지</option>
	</select><br>
	<input class = "top_update_input top_update_input_id" type = "hidden" name = "id" id = "id"
	value = '<c:out value="${id }"></c:out>'  readonly ><br>
	<textarea class = "top_update_content" rows="30" cols="100" name = "content" id = "content" required="required"></textarea><br>
	<input class = "top_update_btn" type = "submit" value = "전송">
	<input class = "top_update_btn" type = "reset" value = 취소>

    </form>
</body>
</html>