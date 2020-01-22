<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- 
    Bootstrap CSS
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> -->

<style>
    .shop_section{
        width: 1200px;
        margin: 50px auto;
        padding: 
        
    }
    .shopbtn:link, .shopbtn:active{
        text-decoration: none;
        color: black;
    }
    
    .shopbtn:hover{
        color:palevioletred;
        background-color: lavenderblush;
    }
    
    .cpinfo{
    	width:300px;
    	height: 100px;
    	margin: 0px auto;
    }
    </style>
</head>

<body>


   <section class="shop_section">
   	<c:set var="dto" value="${requestScope.dto }" />
   
   <div class="cpinfo">
<button type="button" class="btn btn-lg btn-danger" data-toggle="popover" title="${dto.nick }님" data-content=" 현재 ${dto.cp } CP 보유중!　">내 CP 확인하기</button>
   

   </div>
   
   
  
   
    <div class="card-group">
        <div class="card">
           <a href="mdcode.do?mdcode=1001" class="shopbtn">
            <img src="http://choisolyi.dothome.co.kr/lol/img/shop1_1.jpg" class="card-img-top" alt="...">
            <div class="card-body" style="text-align: center;">
                <h5 class="card-title">귀욤귀욤 DJ 소나 피규어 </h5>
                <p class="card-text " ><big class="text-muted"><b style="color: dodgerblue; ">70,000원</b></big></p>
            </div>
            </a>
        </div>
        <div class="card">
           <a href="mdcode.do?mdcode=1002" class="shopbtn">
            <img src="http://choisolyi.dothome.co.kr/lol/img/shop2_1.jpg" class="card-img-top" alt="...">
            <div class="card-body"  style="text-align: center;">
                <h5 class="card-title">존멋 KDA 아칼리 스태츄</h5>
                <p class="card-text"><big class="text-muted"><b style="color: dodgerblue">120,000원</b></big></p>
            </div>
            </a>
        </div>
        <div class="card">
           <a href="mdcode.do?mdcode=1003"  class="shopbtn">
            <img src="http://choisolyi.dothome.co.kr/lol/img/shop3_1.jpg" class="card-img-top" alt="...">
            <div class="card-body" style="text-align: center;">
                <h5 class="card-title" >귀여운 티모 피규어^ㅗ^</h5>
                <p class="card-text"><big class="text-muted"><b style="color: dodgerblue">7,000원</b></big></p>
            </div>
            </a>
        </div>
    </div>
 </section>
 
 <script>
 $(function () {
	  $('[data-toggle="popover"]').popover()
	})
 </script>
 <!--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> -->
</body>
</html>