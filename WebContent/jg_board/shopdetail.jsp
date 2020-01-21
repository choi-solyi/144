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
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>
<script>
var IMP = window.IMP; // 생략가능
IMP.init('http://localhost:8080/challenger144'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용

IMP.request_pay({
    pg : 'kakao', // version 1.1.0부터 지원.
    pay_method : 'card',
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : '주문명:결제테스트',
    amount : 100,
    buyer_email : 'iamport@siot.do',
    buyer_name : '구매자이름',
    buyer_tel : '010-1234-5678',
    buyer_addr : '서울특별시 강남구 삼성동',
    buyer_postcode : '123-456',
    m_redirect_url : 'http://http://localhost:8080/challenger144'
}, function(rsp) {
    if ( rsp.success ) {
        var msg = '결제가 완료되었습니다.';
        msg += '고유ID : ' + rsp.imp_uid;
        msg += '상점 거래ID : ' + rsp.merchant_uid;
        msg += '결제 금액 : ' + rsp.paid_amount;
        msg += '카드 승인번호 : ' + rsp.apply_num;
    } else {
        var msg = '결제에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;
    }
    alert(msg);
});

</script>
</head>
<body>

<c:set var ="mddto" value="${requestScope.mddto }"/>



<div class="shopdetail">
	
	<div class="shopimg"><img src="${mddto.img }" class="card-img" alt="..."></div>
	<div class="shopmd">[상품코드: ${mddto.mdcode }]<b> ${mddto.mdname }</b></div><br>
	<div class="shopprice"> <b>${mddto.price }원</b></div>
	
</div>

<div class="shoppayment">
	<button value="request_pay">결제</button>
</div>



</body>
</html>