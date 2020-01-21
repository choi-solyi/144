<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>



<style>
#div1{
	width:1000px;
	height:1000px;
	border: 1px solid silver;
	margin : 0px auto;
}

#div0, #div1, #div2{
	display: inline-block;
}

#div0, #div2{
display:none;
	background-color: white;
	width : 200px;
	height:1800px;
	z-index: 200 !important;
	position: absolute;
	
}

#kakaoAdWrap, .bnr_adcm300{
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

<c:set var="sname" value="${requestScope.summoner }"/>
<div id="div0"></div>
<div id="div1" >
<c:out value="${sname }"/>  
<%-- <c:import url="https://kr.op.gg/summoner/userName=C194C774"> --%>
<c:import url="http://fow.kr/find/${sname }">
</c:import>
</div>

<div id="div2"></div>

</body>
</html>