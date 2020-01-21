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

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
        $(document).ready(function(){
            
            $('.img_champ1').on('click', function(){
                $('.top_champ_inpo').hide();
                $('.top_board_champ1').show();     
            });
            $('.img_champ2').on('click', function(){
                $('.top_champ_inpo').hide();
                $('.top_board_champ2').show();     
            });    
            $('.img_champ3').on('click', function(){
                $('.top_champ_inpo').hide();
                $('.top_board_champ3').show();     
            }); 
            $('.img_champ4').on('click', function(){
                $('.top_champ_inpo').hide();
                $('.top_board_champ4').show();     
            }); 
            $('.img_champ5').on('click', function(){
                $('.top_champ_inpo').hide();
                $('.top_board_champ5').show();     
            }); 
            
            
            $('.champ1_sp').on('mouseover', function(){
                $('.top_champ1_st').show();
                $('.top_champ1_stt').hide();
                $('.top_champ1_stp').show();
            });
            $('.champ1_s1').on('mouseover', function(){
                $('.top_champ1_st').show();
                $('.top_champ1_stt').hide();
                $('.top_champ1_st1').show();
            });
            $('.champ1_s2').on('mouseover', function(){
                $('.top_champ1_st').show();
                $('.top_champ1_stt').hide();
                $('.top_champ1_st2').show();
            });
            $('.champ1_s3').on('mouseover', function(){
                $('.top_champ1_st').show();
                $('.top_champ1_stt').hide();
                $('.top_champ1_st3').show();
            });
            $('.champ1_us').on('mouseover', function(){
                $('.top_champ1_st').show();
                $('.top_champ1_stt').hide();
                $('.top_champ1_st4').show();
            });
            
            
            
            
            
            $('.champ2_sp').on('mouseover', function(){
                $('.top_champ2_st').show();
                $('.top_champ2_stt').hide();
                $('.top_champ2_stp').show();
            });
            $('.champ2_s1').on('mouseover', function(){
                $('.top_champ2_st').show();
                $('.top_champ2_stt').hide();
                $('.top_champ2_st1').show();
            });
            $('.champ2_s2').on('mouseover', function(){
                $('.top_champ2_st').show();
                $('.top_champ2_stt').hide();
                $('.top_champ2_st2').show();
            });
            $('.champ2_s3').on('mouseover', function(){
                $('.top_champ2_st').show();
                $('.top_champ2_stt').hide();
                $('.top_champ2_st3').show();
            });
            $('.champ2_us').on('mouseover', function(){
                $('.top_champ2_st').show();
                $('.top_champ2_stt').hide();
                $('.top_champ2_st4').show();
            });
            
            
            
            
            $('.champ3_sp').on('mouseover', function(){
                $('.top_champ3_st').show();
                $('.top_champ3_stt').hide();
                $('.top_champ3_stp').show();
            });
            $('.champ3_s1').on('mouseover', function(){
                $('.top_champ3_st').show();
                $('.top_champ3_stt').hide();
                $('.top_champ3_st1').show();
            });
            $('.champ3_s2').on('mouseover', function(){
                $('.top_champ3_st').show();
                $('.top_champ3_stt').hide();
                $('.top_champ3_st2').show();
            });
            $('.champ3_s3').on('mouseover', function(){
                $('.top_champ3_st').show();
                $('.top_champ3_stt').hide();
                $('.top_champ3_st3').show();
            });
            $('.champ3_us').on('mouseover', function(){
                $('.top_champ3_st').show();
                $('.top_champ3_stt').hide();
                $('.top_champ3_st4').show();
            });
            
            
            
            
            $('.champ4_sp').on('mouseover', function(){
                $('.top_champ4_st').show();
                $('.top_champ4_stt').hide();
                $('.top_champ4_stp').show();
            });
            $('.champ4_s1').on('mouseover', function(){
                $('.top_champ4_st').show();
                $('.top_champ4_stt').hide();
                $('.top_champ4_st1').show();
            });
            $('.champ4_s2').on('mouseover', function(){
                $('.top_champ4_st').show();
                $('.top_champ4_stt').hide();
                $('.top_champ4_st2').show();
            });
            $('.champ4_s3').on('mouseover', function(){
                $('.top_champ4_st').show();
                $('.top_champ4_stt').hide();
                $('.top_champ4_st3').show();
            });
            $('.champ4_us').on('mouseover', function(){
                $('.top_champ4_st').show();
                $('.top_champ4_stt').hide();
                $('.top_champ4_st4').show();
            });
            
            
            
            
            $('.champ5_sp').on('mouseover', function(){
                $('.top_champ5_st').show();
                $('.top_champ5_stt').hide();
                $('.top_champ5_stp').show();
            });
            $('.champ5_s1').on('mouseover', function(){
                $('.top_champ5_st').show();
                $('.top_champ5_stt').hide();
                $('.top_champ5_st1').show();
            });
            $('.champ5_s2').on('mouseover', function(){
                $('.top_champ5_st').show();
                $('.top_champ5_stt').hide();
                $('.top_champ5_st2').show();
            });
            $('.champ5_s3').on('mouseover', function(){
                $('.top_champ5_st').show();
                $('.top_champ5_stt').hide();
                $('.top_champ5_st3').show();
            });
            $('.champ5_us').on('mouseover', function(){
                $('.top_champ5_st').show();
                $('.top_champ5_stt').hide();
                $('.top_champ5_st4').show();
            });
            
        });
    </script>

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
    
    
    
    
    
    .top_nav{
        width: 1200px;
    }
    
    .top_board_champ1{
        margin: 0px auto 50px;
        width: 1000px;
        background-image: url(topboard/img/c1b.jpg);
        height: 600px;
        background-size: cover;
        background-repeat: no-repeat;
    }
    
    .top_board_champ2{
        margin: 0px auto 50px;
        width: 1000px;
        background-image: url(topboard/img/c2b.jpg);
        height: 600px;
        background-size: cover;
        background-repeat: no-repeat;
    }
    
    .top_board_champ3{
        margin: 0px auto 50px;
        width: 1000px;
        background-image: url(topboard/img/c3b.jpg);
        height: 600px;
        background-size: cover;
        background-repeat: no-repeat;
    }
    
    .top_board_champ4{
        margin: 0px auto 50px;
        width: 1000px;
        background-image: url(topboard/img/c4b.jpg);
        height: 600px;
        background-size: cover;
        background-repeat: no-repeat;
    }
    
    .top_board_champ5{
        margin: 0px auto 50px;
        width: 1000px;
        background-image: url(topboard/img/c5b.jpg);
        height: 600px;
        background-size: cover;
        background-repeat: no-repeat;
    }
    
    .top_board_champ1>img, .top_board_champ2>img, .top_board_champ3>img, 
    .top_board_champ4>img, .top_board_champ5>img{
        margin: 0px 40px;
    }
    .top_board_champ1name{
        width: 600px;
        padding: 30px 80px 0px;
        
    }
    .top_board_champ1name img{
        float: left;
        margin: 7px;
    }
    .top_cname{
        font-size: 20px;
        font-weight: 700;
        background-color: black;
        padding: 30px 0px 1px 0px;
    }
    .top_cname p{
        line-height: 0
    }
    
    .top_champ{
        width: 900px;
        margin: 5px auto;
        padding: 10px 20px;
        text-align: justify;
        background-color: black;
        display: none;
        

    }
    .top_champ1_stp, .top_champ1_st1, .top_champ1_st2, .top_champ1_st3, .top_champ1_st4{
        display: none;
    }
    
    .top_champ_inpo{
        display: none;
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
		<img class = "img_champ1" src = "topboard/img/c1.jpg">
		<img class = "img_champ2" src = "topboard/img/c2.jpg">
		<img class = "img_champ3" src = "topboard/img/c3.jpg">
		<img class = "img_champ4" src = "topboard/img/c4.jpg">
		<img class = "img_champ5" src = "topboard/img/c5.jpg">
		
		<div class = "top_board_champ">
          
           <div class = "top_champ_inpo top_board_champ1">
              <div class = "top_board_champ1name">
              <img src = "topboard/img/c1.jpg">
              <div class = "top_cname">
                  <p style="color: orange; margin-bottom : 20px;" >블라디미르 진홍빛 사신</p>
                  <p style="color: dodgerblue; font-size: 16px;"><br>Vladimir, The Crimson Reaper</p>
                  <p><br></p>
                  </div>
                  <p style="background-color: black; font-size: 12px; color: antiquewhite; text-align: justify; margin-top: 20px; padding: 10px">블라디미르는 마법형 챔피언으로 피를 다루는 능력이 있습니다. 상대의 체력을 흡수할 수 있기 때문에 라인을 쉽게 유지하며 짧을 쿨타임을 이용하여 상대를 계속 견제할 수 있습니다. 웅덩이를 이용하여 상대의 공격을 피할 수 있고 체력과 주문력이 함께 상승하는 특징을 가지고 있습니다.</p>
              </div>
              <div class = "top_board_champskill">
                  <p style="font-size: 32px; font-weight: 900; color: white; padding-top: 5px">SKILL</p>
              </div>
               <img class = champ1_sp src="topboard/img/cc1-1.png">
               <img class = champ1_s1 src="topboard/img/cc1-2.png">
               <img class = champ1_s2 src="topboard/img/cc1-3.png">
               <img class = champ1_s3 src="topboard/img/cc1-4.png">
               <img class = champ1_us src="topboard/img/cc1-5.png">
               
               <div class = "top_champ1_st top_champ1_st">
                  <div class = "top_champ top_champ1_stt top_champ1_stp">
                   <p style="color: orangered; font-weight: 900; display: inline-block">핏빛 계약 (Crimson Pact)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3"></p>
                   <p style="color: antiquewhite; font-size: 14px;">추가 체력 40당 블라디미르의 주문력이 1 증가하고, 추가 주문력 1마다 체력이 1.4만큼 증가합니다.</p>
                   </div>
               <div class = "top_champ top_champ1_stt top_champ1_st1">
                   <p style="color: orangered; font-weight: 900; display: inline-block">수혈 (Transfusion)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">체력 소모: 현재의 20%
                    재사용 대기시간: 28/25/22/19/16초</p>
                   <p style="color: antiquewhite; font-size: 14px;">블라디미르가 상대의 생명력을 흡수하여 80/100/120/140/160(+0.6AP)의 마법 피해를 입히고 자신의 체력을 20/25/30/35/40 (+0.35AP) 회복시킵니다.
                    수혈을 두 번 사용한 뒤 재사용 대기시간이 돌아오면 핏빛 격노상태가 됩니다.<br>

                    핏빛 격노: 블라디미르의 이동 속도가 잠깐 동안 증가하고 2.5초 동안 수혈의 피해량이 85%만큼 늘어나며, 30(+레벨당 10) + 잃은 체력의 5%(+0.04 AP)만큼 추가로 체력을 회복합니다.(미니언 상대로는 체력 회복 효과가 35%로 감소합니다.) (사정거리: 600)</p>
                   </div>
               <div class = "top_champ top_champ1_stt top_champ1_st2">
                   <p style="color: orangered; font-weight: 900; display: inline-block">피의 웅덩이 (Sanguine Pool))</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">재사용 대기시간: 9/8/7/6/5초</p>
                   <p style="color: antiquewhite; font-size: 14px;">블라디미르가 적의 공격을 받지 않도록 2초 동안 피의 웅덩이로 변하며 그 위에 있는 적의 속도를 40% 늦춥니다.<br>

                    블라디미르는 웅덩이 위에 있는 적에게 지속 시간 동안 80/135/190/245/300 (+추가 체력의 0.15%)의 마법 피해를 입히고 총 피해량의 10%를 체력으로 회복합니다.
                    선혈의 파도 사용 중 피의 웅덩이를 시전할 수 있습니다. (범위: 300)</p>
               </div>
                <div class = "top_champ top_champ1_stt top_champ1_st3">
                   <p style="color: orangered; font-weight: 900; display: inline-block">선혈의 파도 (Tides of Blood)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">체력 소모: 최대 체력의 2~8%,
                    재사용 대기시간: 13/11/9/7/5초</p>
                   <p style="color: antiquewhite; font-size: 12px;">첫 번째 사용시: 블라디미르가 정신 집중을 하며 최대 체력의 8%까지 희생해 피의 웅덩이를 채웁니다. 선혈의 파도의 피해량도 같은 양만큼 늘어납니다. 웅덩이가 가득차면 블라디미르의 이동 속도가 느려집니다.<br>
                    두 번째 사용시: 1.5초 후 혹은 스킬을 재사용하면 주변의 적에게 파도를 방출해 30/45/60/75/90(+0.025 체력)(+0.35 AP)에서 60/90/120/150/180(+0.06 체력)(+0.8 AP)의 마법 피해를 입히고, 40/45/50/55/60%만큼 둔화시킵니다. 파도가 일단 적에게 적중하면 그 뒤로 넘어가지 않습니다. (범위: 600)</p>
                </div>
               <div class = "top_champ top_champ1_stt top_champ1_st4">
                   <p style="color: orangered; font-weight: 900; display: inline-block">혈사병 (Hemoplague)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">재사용 대기시간: 150/135/120초</p>
                   <p style="color: antiquewhite; font-size: 14px;">블라디미르가 혈사병으로 목표 지역을 오염시키며, 혈사병에 감염된 적은 4초 동안 받는 모든 피해가 10% 증가합니다.<br>

                    4초 뒤 감염된 적은 150/250/350 (+0.7AP)의 마법 피해를 입고, 150/250/350(+0.7AP) 만큼 블라디미르의 체력이 회복됩니다. 두 번째로 적중한 적 챔피언부터는 한명당 회복량이 50%씩 증가합니다. (사정거리: 700, 범위: 350)</p>
               </div>
               </div>
               
           </div>
           
           <div class = "top_champ_inpo top_board_champ2">
              <div class = "top_board_champ1name" >
              <img src = "topboard/img/c2.jpg">
              <div class = "top_cname">
                  <p style="color: orange; margin-bottom : 20px;" >나서스, 사막의 관리자</p>
                  <p style="color: dodgerblue; font-size: 16px;"><br>Nasus, The Curator of the Sands</p>
                  <p><br></p>
                  </div>
                  <p style="background-color: black; font-size: 12px; color: antiquewhite; text-align: justify; margin-top: 20px; padding: 10px">
                  나서스는 게임 초반에는 약하지만 후반에는 엄청나게 강력해지는 성장형 챔피언입니다. 흡수의 일격을 일정 이상 쌓으면 거의 모든 챔피언을 혼자 이길 수 있는 강력한 모습을 보이게 됩니다. 다른 어떤 면보다 자신이 성장하는것이 중요합니다.</p>
              </div>
              <div class = "top_board_champskill">
                  <p style="font-size: 32px; font-weight: 900; color: white; padding-top: 5px">SKILL</p>
              </div>
               <img class = champ2_sp src="topboard/img/cc2-1.png">
               <img class = champ2_s1 src="topboard/img/cc2-2.png">
               <img class = champ2_s2 src="topboard/img/cc2-3.png">
               <img class = champ2_s3 src="topboard/img/cc2-4.png">
               <img class = champ2_us src="topboard/img/cc2-5.png">
               
               <div class = "top_champ2_st top_champ2_st">
                  <div class = "top_champ top_champ2_stt top_champ2_stp">
                   <p style="color: orangered; font-weight: 900; display: inline-block">영혼의 포식자 (Soul Eater)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3"></p>
                   <p style="color: antiquewhite; font-size: 14px;">나서스가 입힌 물리 피해의 12/18/24%만큼 체력이 회복됩니다.</p>
                   </div>
               <div class = "top_champ top_champ2_stt top_champ2_st1">
                   <p style="color: orangered; font-weight: 900; display: inline-block">흡수의 일격 (Siphoning Strike)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 20,
                    재사용 대기시간: 8/7/6/5/4초</p>
                   <p style="color: antiquewhite; font-size: 14px;">사용 시: 나서스의 다음 공격에 30/50/70/90/110 (+1.0AD) (+3 x 흡수의 일격으로 적을 죽인수)의 물리 피해를 입힙니다.<br>
                    기본 지속 효과: 흡수의 일격으로 적을 죽이면 흡수의 일격에 3의 추가 피해가 영구적으로 추가됩니다. 챔피언과 대형 미니언, 몬스터에 대해서는 네 배의 효과가 적용됩니다. (사정거리: 200)
                   </div>
               <div class = "top_champ top_champ2_stt top_champ2_st2">
                   <p style="color: orangered; font-weight: 900; display: inline-block">쇠약 (Wither)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 80,
                    재사용 대기시간: 15/14/13/12/11초</p>
                   <p style="color: antiquewhite; font-size: 14px;">나서스가 5초 동안 대상 챔피언의 노화를 촉진시켜, 이동 속도를 처음에는 35%, 이후 지속 시간 동안 최대 47/59/71/83/95%까지 늦춥니다. 이 절반만큼 대상의 공격 속도가 감소합니다. (사정거리: 600)
               </div>
                <div class = "top_champ top_champ2_stt top_champ2_st3">
                   <p style="color: orangered; font-weight: 900; display: inline-block">영혼의 불길 (Spirit Fire)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 70/85/100/115/130, 
                    재사용 대기시간: 12초</p>
                   <p style="color: antiquewhite; font-size: 12px;">나서스가 대상 지역을 영혼의 불길로 태웁니다. 지역 내 적에게 최초 55/95/135/175/215 (+0.6AP)의 마법피해를 입힙니다.

                    다음 5 초 동안, 지역내 적의 방어력이 15/20/25/30/35% 만큼 감소하고 추가로 11/19/27/35/43 (+0.12AP) 의 마법 피해를 매초간 입힙니다. (사정거리: 650, 범위: 400)</p>
                </div>
               <div class = "top_champ top_champ2_stt top_champ2_st4">
                   <p style="color: orangered; font-weight: 900; display: inline-block">사막의 분노 (Fury of the Sands)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 100,
                    재사용 대기시간: 120초</p>
                   <p style="color: antiquewhite; font-size: 14px;">나서스가 15초 동안 모래 폭풍 속에서 힘을 얻어 체력 300/450/600, 공격 사거리가 50 증가합니다.<br>

                    폭풍이 부는 동안 나서스는 매 초마다 주변 적이 보유한 최대 체력의 3/4/5 (+0.01AP)%를 마법 피해(초당 최대 240의 피해)로 입힙니다.<br>

                    활성화시 방어력 및 마법 저항력이 15/35/55 증가하며, 매 초마다 1/2/3씩 추가로 증가합니다. (15초 동안 총 30/65/100 증가)<br>

                    나서스가 강화된 시간 동안 Q 스킬의 재사용 대기시간이 50% 감소합니다. (범위: 350)</p>
               </div>
               </div>
               
           </div>
           
           <div class = "top_champ_inpo top_board_champ3">
              <div class = "top_board_champ1name" >
              <img src = "topboard/img/c3.jpg">
              <div class = "top_cname">
                  <p style="color: orange; margin-bottom : 20px;" >레넥톤, 사막의 도살자</p>
                  <p style="color: dodgerblue; font-size: 16px;"><br>Renekton, The Butcher of the Sands</p>
                  <p><br></p>
                  </div>
                  <p style="background-color: black; font-size: 12px; color: antiquewhite; text-align: justify; margin-top: 20px; padding: 10px">
                  레넥톤은 강력한 공격력과 체력으로 상대방을 압도하는 챔피언으로 주로 아군 맨앞에 서게 됩니다. 마나가 아닌 분노를 사용하는 챔피언으로 분노가 쌓이면 기술들의 성능이 더욱 강회되는 특징이 있습니다.</p>
              </div>
              <div class = "top_board_champskill">
                  <p style="font-size: 32px; font-weight: 900; color: white; padding-top: 5px">SKILL</p>
              </div>
               <img class = champ3_sp src="topboard/img/cc3-1.png">
               <img class = champ3_s1 src="topboard/img/cc3-2.png">
               <img class = champ3_s2 src="topboard/img/cc3-3.png">
               <img class = champ3_s3 src="topboard/img/cc3-4.png">
               <img class = champ3_us src="topboard/img/cc3-5.png">
               
               <div class = "top_champ3_st top_champ3_st">
                  <div class = "top_champ top_champ3_stt top_champ3_stp">
                   <p style="color: orangered; font-weight: 900; display: inline-block">분노의 지배 (Reign of Anger)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3"></p>
                   <p style="color: antiquewhite; font-size: 14px;">레넥톤이 매번 공격할 때마다 분노를 5씩 획득합니다. 분노가 50 이상 쌓이면 스킬에 추가 효과를 부여할 수 있지만 이렇게 사용한 스킬은 분노 50을 소모합니다. 비전투 중일 때는 분노가 매 초마다 4씩 감소합니다.<br>

                    레넥톤의 체력이 50% 이하일 때는 50%의 분노를 더 획득합니다.</p>
                   </div>
               <div class = "top_champ top_champ3_stt top_champ3_st1">
                   <p style="color: orangered; font-weight: 900; display: inline-block">양떼 도륙 (Cull the Meek)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">분노 소모: 0 (50),
                    재사용 대기시간: 8초</p>
                   <p style="color: antiquewhite; font-size: 14px;">레넥톤이 검을 휘둘러 주변의 모든 적에게 65/100/135/170/205 (+0.8 추가AD)의 물리 피해를 입히고
                    미니언 공격시 3/4.5/6/7.5/9 (+0.04 추가AD), 챔피언 공격시 12/18/24/30/36 (0.12 추가AD)의 체력을 50/75/100/125/150 까지 회복합니다.<br>

                    양떼 도륙은 각각 챔피언 공격시 대상당 10의 분노를 얻고, 챔피언 외 대상 공격 시 대상당 2.5의 분노를 얻어 최대 30의 분노를 얻을 수 있습니다.<br>

                    분노 50 추가 효과: 피해가 100/150/200/250/300 (+1.2 추가AD) 증가합니다. 치료 효과가 미니언 공격시 9/13.5/18/22.5/27 (+0.12 추가AD), 챔피언 공격시 36/54/72/90/108 (+0.24 추가AD)로, 최대 200/300/400/500/600까지 증가합니다. (범위: 450)
                   </div>
               <div class = "top_champ top_champ3_stt top_champ3_st2">
                   <p style="color: orangered; font-weight: 900; display: inline-block">무자비한 포식자 (Ruthless Predator)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">분노 소모: 0 (50)
                    재사용 대기시간: 13/12/11/10/9초</p>
                   <p style="color: antiquewhite; font-size: 14px;">챔피언 공격 시 분노 10을 얻습니다.

                    레넥톤의 다음 공격이 두 번 명중하여 적에게 10/30/50/70/90 (+1.5AD)의 물리 피해를 입히고 0.75초 동안 기절시킵니다. 각 공격은 명중 시 발생 효과가 적용됩니다.<br>

                    분노 50 추가 효과: 레넥톤이 적의 보호막을 파괴하고, 세 번 공격하여 적에게 15/45/75/105/135 (+2.25AD)의 물리 피해를 입히고 대상을 1.5초 동안 기절시킵니다. (사정거리: +50)
               </div>
                <div class = "top_champ top_champ3_stt top_champ3_st3">
                   <p style="color: orangered; font-weight: 900; display: inline-block">자르고 토막내기 (Slice and Dice)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">분노 소모: 0 (50),
                    재사용 대기시간: 18/17/16/15/14초</p>
                   <p style="color: antiquewhite; font-size: 12px;">자르기: 레넥톤이 돌격하여 40/70/100/130/160 (+0.9 추가AD)의 물리 피해를 입힙니다. 적을 맞히면 4초 이내에 토막내기를 쓸 수 있습니다.<br>

                    토막내기: 레넥톤이 돌격하여 30/60/90/120/150 (+0.9 추가AD)의 물리 피해를 입힙니다.<br>

                    자르기와 토막내기는 각각 챔피언 공격시 대상당 10의 분노를 얻고, 챔피언 외 대상 공격 시 대상당 2의 분노를 얻어 최대 30의 분노를 얻을 수 있습니다.<br>

                    토막내기 - 분노 50 추가 효과: 피해가 70/115/160/205/250 (+1.35 추가AD)로 증가합니다. 피격당한 적은 4초 동안 방어력이 25/27.5/30/32.5/35% 감소합니다. (사정거리: 550)</p>
                </div>
               <div class = "top_champ top_champ3_stt top_champ3_st4">
                   <p style="color: orangered; font-weight: 900; display: inline-block">강신 (Dominus)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">재사용 대기시간: 120초</p>
                   <p style="color: antiquewhite; font-size: 14px;">레넥톤이 15초 동안 어둠의 기운으로 자신을 감싸며 250/500/750의 체력과 20의 분노를 얻습니다. 스킬이 활성화되어 있는 동안 레넥톤은 근처의 적들에게 40/80/120 (+0.1AP)의 마법 피해를 입히고 초당 5의 분노를 획득합니다.</p>
               </div>
               </div>
               
           </div>
           
           <div class = "top_champ_inpo top_board_champ4">
              <div class = "top_board_champ1name" >
              <img src = "topboard/img/c4.jpg">
              <div class = "top_cname">
                  <p style="color: orange; margin-bottom : 20px;" >이렐리아, 칼날의 의지</p>
                  <p style="color: dodgerblue; font-size: 16px;"><br>Irelia, The Will of the Blades</p>
                  <p><br></p>
                  </div>
                  <p style="background-color: black; font-size: 12px; color: antiquewhite; text-align: justify; margin-top: 20px; padding: 10px">
                  이렐리아는 브루저 챔피언 중 하나로, 돌진 능력이 뛰어난 챔피언입니다. 표식을 이용해 Q 스킬을 초기화 하고, 체력도 조금 회복할 수 있습니다. 광역 스턴과 지역 장악 궁극기를 잘 활용하는 것이 중요합니다.</p>
              </div>
              <div class = "top_board_champskill">
                  <p style="font-size: 32px; font-weight: 900; color: white; padding-top: 5px">SKILL</p>
              </div>
               <img class = champ4_sp src="topboard/img/cc4-1.png">
               <img class = champ4_s1 src="topboard/img/cc4-2.png">
               <img class = champ4_s2 src="topboard/img/cc4-3.png">
               <img class = champ4_s3 src="topboard/img/cc4-4.png">
               <img class = champ4_us src="topboard/img/cc4-5.png">
               
               <div class = "top_champ4_st top_champ4_st">
                  <div class = "top_champ top_champ4_stt top_champ4_stp">
                   <p style="color: orangered; font-weight: 900; display: inline-block">아이오니아의 열정 (Ionian Fervor)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3"></p>
                   <p style="color: antiquewhite; font-size: 14px;">스킬이 적에게 적중하면 6초 동안 아이오니아의 열정 중첩을 1만큼 얻으며, 중첩당 공격 속도가 8/10/12% 증가합니다. 중첩이 최대 5만큼 쌓이면 공격 속도가 40/50/60%만큼 증가하고, 적중 시 피해가 15~66(+0.25 추가AD)만큼 증가합니다.<br>

                    챔피언과 대형 몬스터를 기본 공격 시 아이오니아의 열정 지속 시간이 초기화됩니다.<br>

                    스킬 하나를 여러 챔피언에게 맞히면 중첩을 여러 개 쌓을 수 있습니다. (범위: 1200)<br>

                    </p>
                   </div>
               <div class = "top_champ top_champ4_stt top_champ4_st1">
                   <p style="color: orangered; font-weight: 900; display: inline-block">칼날 쇄도 (Bladesurge)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 20,
                    재사용 대기시간: 12/11/10/9/8초</p>
                   <p style="color: antiquewhite; font-size: 14px;">이렐리아가 적에게 돌진하여 5/25/45/65/85 (+0.6AD)의 물리 피해를 입히고 적중 시 효과를 적용하며 (0.12/0.14/0.16/0.18/0.2AD)의 체력을 회복합니다.<br>

                    칼날 쇄도로 표식이 있는 적을 공격하거나 적을 처치하면 재사용 대기시간이 초기화됩니다.<br>

                    미니언에게는 55/75/95/115/135의 추가 피해를 입힙니다. (사정거리: 600)<br>
                   </div>
               <div class = "top_champ top_champ4_stt top_champ4_st2">
                   <p style="color: orangered; font-weight: 900; display: inline-block">저항의 춤 (Defiant Dance)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 70/75/80/85/90,
                    재사용 대기시간: 20/18/16/14/12초</p>
                   <p style="color: antiquewhite; font-size: 14px;">첫 번째 시전: 이렐리아가 칼날을 방어 대열로 정렬하며 힘을 충전합니다. 이렐리아가 받는 물리 피해량이 50%만큼 감소합니다. 이때 공격이나 이동은 할 수 없습니다.<br>

                    두 번째 시전: 이렐리아가 칼날을 날리며 10/25/40/55/70 (+0.5 AD)(+0.4 AP)의 물리 피해를 가합니다. 피해량은 0.75초 충전 후 최대가 되어 두 배까지 20/50/80/110/140 (+1.0 AD)(+ 0.8 AP) 증가합니다.<br>

                    저항의 춤은 적이 중단시킬 수 없습니다.
               </div>
                <div class = "top_champ top_champ4_stt top_champ4_st3">
                   <p style="color: orangered; font-weight: 900; display: inline-block">쌍검협무 (Flawless Duet)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 50/55/60/65/70,
                    재사용 대기시간: 18/16.5/15/13.5/12초</p>
                   <p style="color: antiquewhite; font-size: 12px;">이렐리아가 칼날 2개를 던집니다. 두 번째 칼날이 목표 위치에 도착한 뒤 두 칼날이 서로를 향해 날아가며, 이때 칼날에 적중한 적은 70/110/150/190/230 (+0.8AP) 의 마법 피해를 입고 0.75초 동안 기절합니다.<br>

                    챔피언 및 대형 몬스터에게 적중 시 5초 동안 표식이 남습니다. (사정거리: 775)</p>
                </div>
               <div class = "top_champ top_champ4_stt top_champ4_st4">
                   <p style="color: orangered; font-weight: 900; display: inline-block">선봉진격검 (Vanguard's Edge)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 100,
                    재사용 대기시간: 140/120/100초</p>
                   <p style="color: antiquewhite; font-size: 14px;">이렐리아가 칼날 다발을 발사합니다. 적 챔피언에게 적중하면 칼날 다발이 넓게 펼쳐지며 이때 칼날은 125/225/325 (+0.7AP)의 마법 피해를 주고 챔피언 및 대형 몬스터에게 5초 동안 표식을 남깁니다.<br>

                    펼쳐진 칼날 다발은 2.5초 동안 결계를 형성합니다. 이 결계를 적이 통과하면 125/200/275 (+0.7AP)의 마법 피해를 입고 1.5초 동안 90% 둔화됩니다.<br>

                    무장 해제된 적은 기본 공격을 할 수 없습니다. (사정거리: 1000)</p>
               </div>
               </div>
               
           </div>
           
           <div class = "top_champ_inpo top_board_champ5">
              <div class = "top_board_champ1name" >
              <img src = "topboard/img/c5.jpg">
              <div class = "top_cname">
                  <p style="color: orange; margin-bottom : 20px;" >마오카이, 뒤틀린 나무 정령</p>
                  <p style="color: dodgerblue; font-size: 16px;"><br>Maokai, The Twisted Treant</p>
                  <p><br></p>
                  </div>
                  <p style="background-color: black; font-size: 12px; color: antiquewhite; text-align: justify; margin-top: 20px; padding: 10px">
                  마오카이는 AP 탱킹 챔피언으로 상황에 따라 다양한 성장이 가능한 캐릭터 입니다. 묘목을 이용하여 적진을 정찰하거나 지뢰처럼 데미지를 줄 수 있고 궁극기를 사용하면 다수의 적에게 피해를 입히며 속박까지 걸어 무력화시킬 수 있습니다.</p>
              </div>
              <div class = "top_board_champskill">
                  <p style="font-size: 32px; font-weight: 900; color: white; padding-top: 5px">SKILL</p>
              </div>
               <img class = champ5_sp src="topboard/img/cc5-1.png">
               <img class = champ5_s1 src="topboard/img/cc5-2.png">
               <img class = champ5_s2 src="topboard/img/cc5-3.png">
               <img class = champ5_s3 src="topboard/img/cc5-4.png">
               <img class = champ5_us src="topboard/img/cc5-5.png">
               
               <div class = "top_champ5_st top_champ5_st">
                  <div class = "top_champ top_champ5_stt top_champ5_stp">
                   <p style="color: orangered; font-weight: 900; display: inline-block">마법 흡수 (Sap Magic)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">재사용 대기시간: 30/25/20초</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3"></p>
                   <p style="color: antiquewhite; font-size: 14px;">마오카이가 자연에서 마법의 힘을 빨아들여 40초 마다 다음 기본 공격 시 5/15/25/35/45/55/65 + 최대 체력의 6/7.5/9/10/11/12/13% 만큼 체력을 회복합니다.<br>

                    마오카이가 스킬을 사용하거나 적의 스킬에 적중당하면 마법 흡수의 재사용 대기시간이 4초 줄어듭니다.<br>

                    마오카이의 체력이 95%보다 많을 때 마법 흡수가 발동하지 않습니다.<br>

                    </p>
                   </div>
               <div class = "top_champ top_champ5_stt top_champ5_st1">
                   <p style="color: orangered; font-weight: 900; display: inline-block">덤불 주먹 (Bramble Smash)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 50,
                    재사용 대기시간: 8/7.25/6.5/5.75/5초</p>
                   <p style="color: antiquewhite; font-size: 14px;">마오카이가 충격파를 일으켜 적을 뒤로 날려버리고 70/115/160/205/250 (+0.5AP)의 마법 피해를 입히며 0.25초 동안 속도를 99%만큼 늦춥니다. (사정거리: 700)
                   </div>
               <div class = "top_champ top_champ5_stt top_champ5_st2">
                   <p style="color: orangered; font-weight: 900; display: inline-block">뒤틀린 전진 (Twisted Advande)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 60,
                    재사용 대기시간: 13/12/11/10/9초</p>
                   <p style="color: antiquewhite; font-size: 14px;">마오카이가 비전 에너지로 가득한 구름으로 변신하여 대상 적에게 다가가 70/95/120/145/170 (+0.4AP)의 마법 피해를 입히고 1/1.1/1.2/1.3/1.4초 동안 바닥에 고정시킵니다. (사정거리: 525)
               </div>
                <div class = "top_champ top_champ5_stt top_champ5_st3">
                   <p style="color: orangered; font-weight: 900; display: inline-block">묘목 던지기 (Sapling Toss)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 60/65/70/75/80
                    재사용 대기시간: 10초</p>
                   <p style="color: antiquewhite; font-size: 12px;">마오카이가 30초 동안 주변을 감시하는 묘목을 던집니다. 묘목은 근처 적을 추격해 가까이 가면 폭발하며 25/50/75/100/125 + 대상의 최대 체력의 7/7.25/7.5/7.75/8% (+주문력 100당 1%)에 해당하는 마법 피해를 입힙니다. 폭발에 맞은 적은 2초 동안 35% 둔화됩니다.<br>

                    수풀에 설치된 묘목은 30(+마오카이의 추가 체력의 2.5%)초 동안 유지되고 더 강력한 폭발을 일으켜 맞은 적 모두에게 2초 동안 두 배의 피해를 입힙니다.<br>

                    챔피언이 아닌 대상에게는 최대 300의 피해를 입히며, 수풀에 설치될 경우 이 수치가 두 배로 증가합니다. (사정거리: 1100)</p>
                </div>
               <div class = "top_champ top_champ5_stt top_champ5_st4">
                   <p style="color: orangered; font-weight: 900; display: inline-block">대자연의 마수 (Nature's Grasp)</p>
                   <p style="color: white; font-size: 12px; display: inline-block; float: right; line-height: 2.3">마나 소모: 100,
                    재사용 대기시간: 120/100/80초</p>
                   <p style="color: antiquewhite; font-size: 14px;">마오카이가 나뭇가지와 가시로 된 거대 벽을 소환합니다. 벽은 천천히 전진하며 벽에 닿은 적에게 150/225/300 (+0.75AP)의 마법 피해를 입히고 0.8 ~ 2.6초 동안 속박합니다. 속박 시간은 벽이 이동한 거리에 비례합니다. (사정거리: 3000))</p>
               </div>
               </div>
               
           </div>
       </div>
		
		
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
							<option value = "btitle">글제목</option>
							<option value = "bcontent">내용</option>
							<option value = "id">작성자</option>
						</select>
					<input class = "top_board_search_txt" type="text" name = "searchtxt">
					<input class = "top_board_search_btn" type="submit" value="검색">
                </form>
                <a href = "topinsert.do">추가</a><br>
            </div>
	
</div>
</body>
</html>