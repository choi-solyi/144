<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<title>Insert title here</title>
<style>

.shopdetail{
	width:700px;
	height:400px;
	margin : 15px auto;
	border:1px solid silver;
	border-radius:  10px;
}

.shoppayment{
	width:500px;
	height: 200px;

	margin : 15px auto;
	border:1px solid silver;
	border-radius:  10px;
	text-align: center;
	padding :10px 20px;

}
.shopimg{
	width : 300px;
	margin : 0px auto;
	text-align: center;
}
.shopmd{
	width : 500px;
	margin : 0px auto;
	text-align: center;
}
.shopprice{
	width : 500px;
	margin : 0px auto;
	text-align: center;
}

</style>

</head>
<body>

<c:set var ="mddto" value="${requestScope.mddto }"/>



<div class="shopdetail">
	
	<div class="shopimg"><img src="${mddto.img }" class="card-img" alt="..."></div>
	<div class="shopmd">[상품코드: ${mddto.mdcode }]<b> ${mddto.mdname }</b></div><br>
	<div class="shopprice"> <b>${mddto.price }원</b></div>
	
</div>

<div class="shoppayment">
	<button value="">결제</button>
</div>



</body>
</html>