<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>



<style>
#div1 {
	width: 800px;
	height: 1350px;
	position: relative;
	top: -200px;
	left: 480px;
	margin: 0px auto;
	z-index: -200;
}

#div0, #div1, #div2 {
	display: inline-block;
}

#div0 {
	background-color: #f8f8f8 !important;
	width: 488px;
	height: 1350px;
	z-index: 200 !important;
	position: absolute;
	background-color: white;
}

#div2 {
	background-color: #f8f8f8 !important;
	width: 500px;
	height: 1350px;
	z-index: 200 !important;
	position: absolute;
	background-color: white;
	left: 1323px;
}

#kakaoAdWrap, .bnr_adcm300 {
	opacity: 0;
}
</style>
<script>
	/* $(document).ready(function(){
	 $('#div').load("https://www.op.gg/");
	
	 }) */
</script>



</head>



<body>

	<c:set var="sname" value="${requestScope.summoner }" />
	<div id="div0"></div>

	<div id="div1">
		<%-- <c:import url="https://kr.op.gg/summoner/userName=C194C774"> --%>
		<c:import url="http://fow.kr/find/${sname}">
		</c:import>
	</div>

	<div id="div2"></div>

</body>
</html>