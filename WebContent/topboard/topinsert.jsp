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
            width: 1000px;
            margin: 50px auto;
            padding: 40px 80px;
            border: 2px solid silver;
        }
        .top_update_label{
            display: inline-block;
            width: 80px;
            margin-top: 10px;
        }
        .top_update_input_title{
        	height : 30px;
        	border: 2px solid silver;
        }
        
        .top_update_select{
            height: 30px;
        }
        
        .top_update_input, .top_update_select>option{
            height: 20px;
        }
        .top_update_content{

        }
        .top_update_btn {
	text-decoration:none;
	font-family:Arial;
	box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 4px 0px;
	o-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 4px 0px;
	-moz-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 4px 0px;
	-webkit-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 4px 0px;
	background:#eeeeee;
	background:-o-linear-gradient(90deg, #eeeeee, #e1e1e1);
	background:-moz-linear-gradient( center top, #eeeeee 5%, #e1e1e1 100% );
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #eeeeee), color-stop(1, #e1e1e1) );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#eeeeee', endColorstr='#e1e1e1');
	background:-webkit-linear-gradient(#eeeeee, #e1e1e1);
	background:-ms-linear-gradient(#eeeeee, #e1e1e1);
	background:linear-gradient(#eeeeee, #e1e1e1);
	text-indent:0px;
	line-height:5px;
	-moz-border-radius:3px;
	-webkit-border-radius:3px;
	border-radius:3px;
	text-align:center;
	vertical-align:middle;
	display:inline-block;
	font-size:16px;
	color:#000000;
	width:75px;
	height:15px;
	padding:13px;
	border-color:#e1e1e1;
	border-width:1px;
	border-style:solid;
	margin-top:-10px;
}

.top_update_btn:active {
	box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	o-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	-moz-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	-webkit-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	position:relative;
	top:4px
}

.top_update_btn:hover {
	background:#e1e1e1;
	background:-o-linear-gradient(90deg, #e1e1e1, #eeeeee);
	background:-moz-linear-gradient( center top, #e1e1e1 5%, #eeeeee 100% );
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #e1e1e1), color-stop(1, #eeeeee) );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e1e1e1', endColorstr='#eeeeee');
	background:-webkit-linear-gradient(#e1e1e1, #eeeeee);
	background:-ms-linear-gradient(#e1e1e1, #eeeeee);
	background:linear-gradient(#e1e1e1, #eeeeee);
}
        .top_insert_btn{
            margin: 40px 40px 20px 40px;
        }
    
    </style>
</head>



<body>

	<c:set var = "dto" value = "${requestScope.dto }"></c:set>
	<c:set var = "id" value = "${requestScope.id }"></c:set>
	
    <div class = "top_insert_wrap">
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
        <div class = "top_insert_btn">
            <input class = "top_update_btn" type = "submit" value = "전송">
            <input class = "top_update_btn" type = "reset" value = 취소>
        </div>
        </form>
    </div>
</body>
</html>