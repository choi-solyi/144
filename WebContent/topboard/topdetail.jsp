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

<style>

		#top_wrap{
		   		background-image: url("topboard/img/top_bg.jpg");
		   	
		   		background-size: cover;
		   }
		   .top_opacity{
		   		padding: 40px;
		   		background-color: rgba(255,255,255,0.4);
		   }
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
            padding: 0px 0px 40px 40px;
            background-color: white;
        }
        .top_content_category{
        	float:right;
            margin: 20px;
            vertical-align: middle;
        }
        .top_content_title{
            margin: 20px 0px 60px 0px;
            font-size: 1.5em;
            font-weight: bolder;
        }
        .top_content_content{
            margin-bottom: 60px;
        }
        
        .top_bcontent a{
            text-decoration: none;
            font-weight: bolder;
            color: gray;
        }
        
        .top_link_up, .top_link_update, .top_link_del, .top_link_list{
        
	font-weight:bold;
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
	line-height:15px;
	-moz-border-radius:3px;
	-webkit-border-radius:3px;
	border-radius:3px;
	text-align:center;
	vertical-align:middle;
	display:inline-block;
	font-size:20px;
	color:#696969;
	width:75px;
	height:40px;
	padding:13px;
	border-color:#e1e1e1;
	border-width:1px;
	border-style:solid;
}

.top_link_up:active, .top_link_update:active, .top_link_del:active, .top_link_list:active{
	box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	o-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	-moz-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	-webkit-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	position:relative;
	top:4px
}

.top_link_up:active, .top_link_update:active, .top_link_del:active, .top_link_list:hover{
	background:#e1e1e1;
	background:-o-linear-gradient(90deg, #e1e1e1, #eeeeee);
	background:-moz-linear-gradient( center top, #e1e1e1 5%, #eeeeee 100% );
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #e1e1e1), color-stop(1, #eeeeee) );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e1e1e1', endColorstr='#eeeeee');
	background:-webkit-linear-gradient(#e1e1e1, #eeeeee);
	background:-ms-linear-gradient(#e1e1e1, #eeeeee);
	background:linear-gradient(#e1e1e1, #eeeeee);

        
        }
        
                
        .top_link_up{
            display: inline-block;
            margin: 0px auto;
            position: relative;
            left : 45%;
            width:120px;
			height:60px;
			font-size:30px;
			line-height:30px;
            
        }
        
        .top_link_up, .top_link_update, .top_link_del, .top_link_list{
        
        }
        
        #top_content_rep{
            width: 1200px;
            margin: 0px auto;
            padding : 40px 0px;
            background-color: white;
            

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
            background-color: white;
        }
        
        /* .top_rep_nick{
            margin-bottom: 30px;
            height: 30px;
        } */
        
        .top_rep_content{
        	display : inline-block;
            margin: -20px 0px 0px 40px;
        }
        
        .top_content_rep_id, .top_content_rep_rcontent{
			
		}
		

.top_rep_btn {
	font-weight:bold;
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
	line-height:15px;
	-moz-border-radius:3px;
	-webkit-border-radius:3px;
	border-radius:3px;
	text-align:center;
	vertical-align:middle;
	display:inline-block;
	font-size:20px;
	color:#696969;
	width:75px;
	height:40px;
	padding:13px;
	border-color:#e1e1e1;
	border-width:1px;
	border-style:solid;
	margin : 0px 0px 40px 10px;
}

.top_rep_btn:active {
	box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	o-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	-moz-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	-webkit-box-shadow:inset #fafafa 0px 5px 8px -1px,#a8a8a8 0px 0 0px;
	position:relative;
	top:4px
}

.top_rep_btn:hover {
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
<c:set var = "session" value="${sessionScope.id }" />
<div id = "top_content_wrap">
<div id = "top_wrap">
	<div class = "top_opacity">

	<header class = "top_content_header">
            
        </header>
        <section class = "top_content">
            <div class = "top_btitle">
                <div class = "tcontent tc_title top_content_id">닉네임 : <c:out value = "${dto.nick }"></c:out></div>
                <div class = "tcontent tc_title top_content_writedate"> <c:out value = "${dto.bwritedate }"></c:out></div>
                <div class = "tcontent tc_title top_content_hit">조회 : <c:out value = "${dto.bhit }"></c:out></div>
                <div class = "tcontent tc_title top_content_up">추천 : <c:out value = "${dto.bup }"></c:out></div><br>
            </div>
            <div class = "top_bcontent">
                <div class = "tcontent top_content_category"><c:out value = "${dto.bcategory }"></c:out></div>
                <div class = "tcontent top_content_title"><c:out value = "${dto.btitle }"></c:out></div><br>
                <div class = "tcontent top_content_content"><c:out value = "${dto.bcontent }"></c:out></div><br>
                <a class = "top_link_up" href = "topup.do?no=${dto.bno }">추천</a><br>
                <c:if test="${session == dto.id }">
					<a class = "top_link_update" href = "topupdate.do?no=${dto.bno }">수정</a>
                	<a class = "top_link_del" href = "topdelete.do?no=${dto.bno }">삭제</a>
				</c:if>
				
				<a class = "top_link_list" href = "toplist.do">목록</a>
				
            </div>
        </section>
        
        <div id = "top_content_rep">
		<div class = "top_content_rep_title">
             	댓글은 작성자에게 큰 힘이 됩니다. 빠샤!
        </div>
    </div>
	
	
	<form class = "top_rep_form" method = "post" action = "mwrep.do" name = "frm">
        	<input type = "hidden" name = "no" value = "${dto.bno}">
        	<input type = "hidden" class = "top_rep_nick" type = "text" name = "nick" name = "nick" value = "${session }"><br>
	        <textarea class = "top_rep_content" rows="7" cols="145" name = "content"></textarea>
	        <input class = "top_rep_btn" type = "button" onclick = "send()" value = "추가">
    </form>

		
</div>
</div>
</div>
	


<script>
	function send(){
		if(document.frm.title.value!=""){
			document.frm.submit();
		}
	}
	
	function del(repno, bno){
		location.href="toprepdelete.do?repno="+repno+"&bno="+bno;
		
	}
	

		let no=${dto.bno}
				
		$.ajax({
			url:'repdetail.do'
			,data: {'no':no}
			,dataType:'json'
			,method:'post'
			,success:function(data){
				
				$.each(data,function(index,item){
					let result="<div class = 'top_content_rep_content'>"
					result+= "<div class = 'top_content_rep_id'>"+item.nick+" "+"("+item.rwritedate+")"+"</div>";
					result+= "<div class = 'top_content_rep_rcontent'>"+item.rcontent;
					//if(session==item.id){
					result+= "<input class = 'top_content_rep_del' type='button' value='삭제' onclick=del("+item.repno+","+item.bno+")>";
					//}
					result+= "</div></div>";
					$('#top_content_rep').append(result);
				});
				
			}
			,error:function(data){
				console.log('error',data);
			}
			
		});
	

</script>


</body>


</html>