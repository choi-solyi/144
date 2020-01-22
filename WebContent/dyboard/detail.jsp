<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
#dydetailwrap {
	border: 1px solid black;
	width: 70%;
	text-align: center;
	margin: 50px auto;
}
#dydetailhead {
	
	background-color : orange;
	padding: 10px;
}

#nick, #category, #bhit, #repnum{
	width: 10%;
	height: 40px;
	display: inline-block;
	margin : 0px 10px;
	padding : 7px;
	background-color : #007bff;
	color : white;
	border-radius : 10px;
}

#title {
	width: 50%;
	height: 60px;
	display: inline-block;
	margin : 0px auto;
	padding : 17px;
	color : white;
	font-size: 20px;
}

#deleteboard, #updateboard {
	display: inline-block;
}

#dycontent {
	border: 1px solid black;
	width: 70%;
	height: 500px;
	margin: 20px auto;
	text-align: left;
	padding: 30px;
}

#dy_repwritebox{
	border : 1px solid black;
	width : 70%; height : 200px;
	margin : 10px auto;
}
#reptextarea{
	width: 60%;
}
#dy_replist{
    width: 70%; 
    margin: 10px auto;
    border: 1px solid black;
    text-align:left;
}
#updateboard{
	float: left;
	position : relative;
	left : 250px;
}
#deleteboard{
	float: right;
	position : relative;
	right : 250px;
}
#deleterepboard{
       display: inline-block;
       margin: 10px 0 10px 20%;
       float : right;
}
#dy_repwritebox{
	background-color: rgb(46, 204, 113);
}
#dy_repwritebox textarea{
	width: 80%;

}


</style>
</head>
<body>
	<c:set var="dto" value="${requestScope.dto }"/>
	<div id="dydetailwrap">
		<div id="dydetailhead">
			<div id="nick">
				<c:out value="${dto.nick}" />
			</div>
			<div id="category">
				<c:out value="${dto.bcategory}" />
			</div>
			<div id="title">
				<c:out value="${dto.btitle}" />
			</div>
			<div id="bhit">
				<c:out value="조회수  : ${dto.bhit}" />
			</div>
			<div id="repnum">댓글(00)</div>
		</div>
		<div id="dycontent">
			<c:out value="${dto.bcontent }" />
		</div>
		<c:if test="${sessionScope.id == dto.id }">
			<div id="updateboard">
				<a class="btn btn-warning" href="dyupdate.do?bno=${dto.bno}" role="button">수정</a>
			</div>
			<div id="deleteboard">
				<a class="btn btn-danger" href="dydelete.do?bno=${dto.bno}" role="button">삭제</a>
			</div>
		</c:if>
		<br>
		<br> <a class="btn btn-primary" href="dylist.do" role="button">목록으로</a>
		
	<div id="dy_repwrap">
		<div id="dy_repwritebox">
			<form method="post" action="dyaddrep.do">
				<div id="repwriter" >작성자 : <c:out value="${sessionScope.id}"/></div>  
				<br>
				<textarea  rows="5" cols="200" name="repcontent" id="reptextarea" placeholder="댓글을 입력하세요"></textarea>
				
				<input type="hidden" name="bno" value="${dto.bno }">
				<input type="hidden" name="repwriter" value="${sessionScope.id }">
				<input class="btn btn-primary" type="submit" value="등록">
			</form>
			<form>
				<input type="hidden" name="bno" value="${dto.bno }">
			</form>
		</div>
	
	</div>
	<script>
		let bno = ${dto.bno};
		let ssid = '${sessionScope.id}';
		console.log(bno);
		console.log('세션아이디',ssid);
		$.ajax({
			url : 'dyreplist.do',
			data :{
				'bno' : bno
			}
			,dataType : 'json'
			,method : 'post'
			,success : function(data){
				
				$.each(data, function(index, item) {
					
					let result = "<div id='dy_replist'>" ;
					result +=item.nick + "<br>" ;
					result +=item.rwritedate;
					if(ssid == item.id){
						result+= "<a href = " +"class="+"btn btn-danger"+"dyrepdelete.do?repno=" 
								+ item.repno +"&bno=" + item.bno;
						result+= ">" +"삭제 </a>";
					}
					result += "<br>" + item.rcontent + "</div>";
					
				$('#dy_replistwrap').append(result);	
				});
			}
			,error : function(data) {
				console.log('error',data)
			}
			
			
		});
	</script>
	<div id="dy_replistwrap">
	 
	 </div>
	
	
	</div> <!-- detailwrap -->

</body>
</html>