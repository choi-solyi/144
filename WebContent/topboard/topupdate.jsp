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
            border : 2px solid silver;
            padding: 40px 80px;
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
            margin: 0px 0px 40px 20px;
        }
        .top_update_updateinput, .top_update_cancelinput{
            width: 80px;
            height: 40px;
            font-size: 1.5em;
            margin: 20px 0px 20px 20px;
        }
        
        .top_update_updateinput, .top_update_cancelinput {
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

.top_update_updateinput:active, .top_update_cancelinput:active {
	box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	o-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	-moz-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	-webkit-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	position:relative;
	top:4px
}

.top_update_updateinput:hover, .top_update_cancelinput:hover {
	background:#e1e1e1;
	background:-o-linear-gradient(90deg, #e1e1e1, #eeeeee);
	background:-moz-linear-gradient( center top, #e1e1e1 5%, #eeeeee 100% );
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #e1e1e1), color-stop(1, #eeeeee) );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e1e1e1', endColorstr='#eeeeee');
	background:-webkit-linear-gradient(#e1e1e1, #eeeeee);
	background:-ms-linear-gradient(#e1e1e1, #eeeeee);
	background:linear-gradient(#e1e1e1, #eeeeee);
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
    <textarea class = "top_update_content" rows="30" cols="130" name = "content" id = "content"
     required="required"><c:out value="${dto.bcontent }"></c:out></textarea><br>
    <input class = "top_update_updateinput" type = "submit" value = "수정">
	<input class = "top_update_cancelinput" type = "reset" value = "취소">

</form>
</div>
</body>
</html>