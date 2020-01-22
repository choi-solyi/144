<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

	.paymentcomplete{
		width:500px;
		height: 800px;
		margin : 0px auto;
	}
</style>
</head>
<body>

<c:set var="dto1" value="${requestScope.dto1}"/>
<c:set var="dto2" value="${requestScope.dto2}"/>
<%-- 

차감전 CP : <c:out value="${dto1.cp }"/>

<br><br><br>
이미지 : ${requestScope.img } <br>
상품명 : ${requestScope.mdname } <br>
상품 가격 : ${requestScope.price} <br>

 --%>

<div class="paymentcomplete">

<div class="card-deck">
  <div class="card">
    <img src="${requestScope.img}" class="card-img-top" alt="..." style="width:498px;">
    <div class="card-body">
      <h5 class="card-title">${requestScope.mdname} <small>가격 / ${requestScope.price } CP </small></h5>
      <p class="card-text"> 차감 전 CP / ${dto1.cp}</p>
    </div>
    <div class="card-footer">
      <small class="text-muted">차감 후 CP / ${dto2.cp }</small>
    </div>
  </div>
 </div>
</div>




</body>
</html>