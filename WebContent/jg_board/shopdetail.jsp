<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<title>Insert title here</title>
<style>

.shopdetail{
	width:700px;
	height:450px;
	margin : 15px auto;
	border:1px solid silver;
	border-radius:  10px;
}

.shoppayment{
	width:500px;
	height: 200px;

	margin : 15px auto;
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
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>
<script>
/* function payment(mdcode, price, mdname){
	console.log(mdcode);
	console.log(mdname);
	console.log(price);
	
	
	 location.href="payment.do?md=" + mddto; 
} */

$(document).ready(function(){
	$('#payment').click(function(){
		let img = '${mddto.img }';
		let a = ${mddto.mdcode};
		let b = '${mddto.mdname}';
		let c = ${mddto.price};
		let id =  '${sessionScope.id}';
		location.href="payment.do?id="+id+"&mdcode="+a+"&mdname="+b+"&price="+c+"&img="+img;
		
	})
})

</script>

</head>
<body>

<c:set var ="mddto" value="${requestScope.mddto }"/>



<div class="shopdetail">
	
	<div class="shopimg"><img src="${mddto.img }" class="card-img" alt="..."></div>
	<div class="shopmd">[상품코드: ${mddto.mdcode }]<b> ${mddto.mdname }</b></div><br>
	<div class="shopprice"> <b>${mddto.price } CP</b></div>
		<div class="shoppayment">
		<input type="button" class="btn btn-success btnsol" id="payment" value="CP로 결제" <%-- onclick=payment(${mddto.mdcode },${mddto.price},'${mddto.mdname}') --%>> 
	</div>
	
</div>


<%-- 	<input type="button" value="결제" onclick="payment('${mddto.mdcode }', '${mddto.mdname }', '${mddto.price }')>
 --%>





</body>
</html>