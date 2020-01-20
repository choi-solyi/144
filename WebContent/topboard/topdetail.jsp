<%@page import="java.net.URLEncoder"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src=https://code.jquery.com/jquery-3.4.1.min.js></script>
<script>
	function send(){
		if(document.frm.title.value!=""){
			document.frm.submit();
		}
	}
	
	function del(repno, bno){
		location.href="toprepdelete.do?repno="+repno+"&bno="+bno;
		
	}
	
	$(document).ready(function(){
		
		let no=${dto.bno}
				
		$.ajax({
			url:'repdetail.do'
			,data: {'no':no}
			,dataType:'json'
			,method:'post'
			,success:function(data){
				
				$.each(data,function(index,item){
					let result="<div class = 'top_content_rep_content'>"
					result+= "<div class = 'top_content_rep_id'>닉네임 : "+item.nick+"</div>";
					result+= "<div class = 'top_content_rep_rcontent'>"+item.rcontent;
					result+= "<input class = 'top_content_rep_del' type='button' value='삭제' onclick=del("+item.repno+","+item.bno+")>";
					result+= "</div></div>";
					
					$('#top_content_rep').append(result);
				});
				
			}
			,error:function(data){
				console.log('error',data);
			}
			
		});
		
		
	});
	

</script>
<style>
        .top_content_header{
            margin: 40px auto;
            width: 1200px;
            height: 260px;
            background-size: contain;
            background-repeat: no-repeat;
            background-image: url(topboard/img/topbanner.jpg);
        }
        .top_content{
            margin: 0px auto;
            width: 1200px;

        }
        .tcontent{
            display: inline-block;
            text-align: center;
        }
        .top_btitle{
            background-color: lightgray;
            border-top : 4px solid gray;
            border-bottom : 2px solid gray;
        }
        .tc_title{
            font-weight: bolder;
            margin:  20px 0px;
        }
        .top_content_id{
            width: 200px;
        }
        .top_content_writedate{
            width: 770px;
        }
        .top_content_hit{
            width : 100px;
        }
        .top_content_up{
            width : 100px;
        }
        .top_bcontent{
            margin-left: 40px;
        }
        .top_content_category{
            margin: 20px 0px;
        }
        .top_content_title{
            margin: 60px 0px;
            font-size: 2rem;
            color: red;
        }
        .top_content_content{
            margin-bottom: 60px;
        }
        
        .top_bcontent a{
            text-decoration: none;
            font-weight: bolder;
            color: gray;
        }
        
        .top_link_up{
            display: inline-block;
            margin: 0px auto;
            font-size: 3em;
            position: relative;
            left : 45%;
            
        }
        
        #top_content_rep{
            width: 1200px;
            margin: 40px auto;

        }
        .top_content_rep_title{
            font-weight: bolder;
            font-size: 20px;
            background-color: lightgray;
            padding: 10px 40px;
        }
        .top_content_rep_content{
            border-bottom: 2px solid lightgray;
        }
        
        .top_content_rep_id{
            margin: 10px 10px 10px 40px;
            
        }
        .top_content_rep_rcontent{
            margin: 10px 10px 10px 40px;
        }
        .top_content_rep_del{
            float: right;
            margin: 0px 20px;
        }
        
        .top_rep_form{
            width: 1200px;
            margin: 0px auto;
        }
        
        .top_rep_nick{
            margin-bottom: 30px;
            height: 30px;
        }
        
        .top_rep_content{
            margin-bottom: 30px;
        }
    
    </style>

</head>
<body>
<c:set var = "dto" value = "${requestScope.dto }"></c:set>
<div id = "top_content_wrap">

	<header class = "top_content_header">
            
        </header>
        <section class = "top_content">
            <div class = "top_btitle">
                <div class = "tcontent tc_title top_content_id">닉네임 : <c:out value = "${dto.id }"></c:out></div>
                <div class = "tcontent tc_title top_content_writedate"><c:out value = "${dto.bwritedate }"></c:out></div>
                <div class = "tcontent tc_title top_content_hit">조회 : <c:out value = "${dto.bhit }"></c:out></div>
                <div class = "tcontent tc_title top_content_up">추천 : <c:out value = "${dto.bup }"></c:out></div><br>
            </div>
            <div class = "top_bcontent">
                <div class = "tcontent top_content_category"><c:out value = "${dto.bcategory }"></c:out></div><br>
                <div class = "tcontent top_content_title"><c:out value = "${dto.btitle }"></c:out></div><br>
                <div class = "tcontent top_content_content"><c:out value = "${dto.bcontent }"></c:out></div><br>
                <a class = "top_link_up" href = "topup.do?no=${dto.bno }">추천</a><br>
                <a class = "top_link_list" href = "toplist.do">목록</a>
                <a class = "top_link_update" href = "topupdate.do?no=${dto.bno }">수정</a>
                <a class = "top_link_del" href = "topdelete.do?no=${dto.bno }">삭제</a>
            </div>
        </section>

		
</div>
	<section id = "top_content_rep">
		<div class = "top_content_rep_title">
             	댓글
        </div>
		
	</section>
	
	<form class = "top_rep_form" method = "post" action = "mwrep.do" name = "frm">
        	<input type = "hidden" name = "no" value = "${dto.bno}">
        	<input class = "top_rep_nick" type = "text" name = "nick" name = "nick"><br>
	        <textarea class = "top_rep_content" rows="7" cols="168" name = "content"></textarea><br>
	        <input type = "button" onclick = "send()" value = "추가">
    </form>


</body>
</html>