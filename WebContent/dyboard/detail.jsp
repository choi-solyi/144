<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
#entirewrap{
	background-image: url(dyboard/img/갈리오.jpg);
	background-color: #ffffff;
    background-color: rgba( 255, 255, 255, 0.5 );
    margin : 0;
}

#dydetailwrap {
	width: 70%;
	text-align: center;
	margin: 0px auto;
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
	width: 100%;
	height: 500px;
	margin: 20px auto;
	text-align: left;
	padding: 30px;
	background-color : white;
	
}

#dy_repwritebox{
	width : 70%; height : 200px;
	margin : 10px auto;
}
#reptextarea{
	width: 60%;
}
#dy_replist{
    width: 70%; 
    margin: 10px auto;
    text-align:left;
    background-color : white;
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
#dy_repsubmit{
	position : relative;
	bottom : 20px;
	left : 20px;
}
#repwriter{
	color : white;
	position : relative;
	top : 10px;
	right : 225px;
 	font-weight : 900px;
}
/* #dy_replist span{
	font-size : 20px;
	position : relative; 
	left : 50px;
	bottom : 40px;
	
} */
#rwritedate{
	margin-left : 10px;
}
#rcontent{
	font-size : 20px;
	position : relative; 
	left : 50px;
	bottom : 40px;
}
#dy_replist a{
	float : right;
	position : relative;
	bottom : 8px;
}
#dy_replist p{
	margin : 0px; 
	position : relative;
	left : 20px;
	font-size : 40px;
}


</style>
</head>
<body>
	<c:set var="dto" value="${requestScope.dto }"/>
<div id="entirewrap">
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
				<div id="repwriter" >작성자 ID : <c:out value="${sessionScope.id}"/></div>  
				<br>
				<textarea  rows="5" cols="200" name="repcontent" id="reptextarea" placeholder="댓글을 입력하세요"></textarea>
				
				<input type="hidden" name="bno" value="${dto.bno }">
				<input type="hidden" name="repwriter" value="${sessionScope.id }">
				<input id="dy_repsubmit" class="btn btn-primary" type="submit" value="등록">
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
					result +="<p>" + item.nick + "</p>";
					result +="<span id='rwritedate'>"+"("+item.rwritedate +")"+"</span>";
					
					result +="<span id='rcontent'>" + item.rcontent +"</span>" ;
					if(ssid == item.id){
						result+= "<a class='btn btn-danger'"+" href = "+"dyrepdelete.do?repno=" 
								+ item.repno +"&bno=" + item.bno;
						result+= ">" +"삭제 </a>"+ "</div>";
					}
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
	<br><br><br>
	</div> <!-- detailwrap -->
</div>
</body>
</html>