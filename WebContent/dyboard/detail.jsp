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
	width: 80%;
	text-align: center;
	margin-top: 50px;
}

#dydetailhead div {
	display: inline-block;
}

#nick, #category, #bhit, #repnum {
	width: 10%;
	height: 60px;
	border: 1px solid black;
}

#title {
	width: 50%;
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
#deleterepboard{
       display: inline-block;
       margin: 10px 0 10px 20%;
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
				<c:out value="${dto.bhit}" />
			</div>
			<div id="repnum">댓글(00)</div>
		</div>
		<div id="dycontent">
			<c:out value="${dto.bcontent }" />
		</div>
		<c:if test="${sessionScope.id == dto.id }">
			<div id="updateboard">
				<a href="dyupdate.do?bno=${dto.bno}"> <input type="button"
					value="수정"></a>
			</div>
			<div id="deleteboard">
				<a href="dydelete.do?bno=${dto.bno}"> <input type="button"
					value="삭제"></a>
			</div>
		</c:if>
		<br> <a href="dylist.do"><input type="button" value="목록으로"></a>
	<div id="dy_repwrap">
		<div id="dy_repwritebox">
			<form method="post" action="dyaddrep.do">
				<div id="repwriter" >작성자 : <c:out value="${sessionScope.id}"/></div>  
				<br>
				<textarea rows="5" cols="100" name="repcontent" id="reptextarea" placeholder="댓글을 입력하세요"></textarea>
				
				<input type="hidden" name="bno" value="${dto.bno }">
				<input type="hidden" name="repwriter" value="${sessionScope.id }">
				<input type="submit" value="등록">
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
						result+= "<a href = " + "dyrepdelete.do?repno=" 
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