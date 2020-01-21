<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul li {
	list-style: none;
	display: inline-table;
	padding: 0px 120px;
}

.bg {
	display: inline-block;
}

.bg1 {
	width: 470px;
}
</style>

<script>
	function send() {
		if (document.frm.rcontent.value != "") {
			document.frm.submit();
		}
	}

	
</script>

</head>
<body>
	<c:set var="dto" value="${requestScope.dto}" />
	<c:set var="ssid" value="${sessionScope.id }" />
	<c:set var="file1" value="${dto.bimg }" />
	<c:set var="repcount" value="${requestScope.repcount }"/>
	
	<div class="bg">
		<img src=supBoard/img/sup1.jpg class="bg1">
	</div>
	<div class="bg">
		<img src=supBoard/img/sup2.jpg class="bg1">
	</div>
	<div class="bg">
		<img src=supBoard/img/sup3.jpg class="bg1">
	</div>
	<div class="bg">
		<img src=supBoard/img/sup4.jpg class="bg1">
	</div>
	<div class="container">



		<div
			style="text-align: center; margin-bottom: 50px; margin-top: 50px;">
			<h1>S U P P O R T E R</h1>
		</div>
		<div class="container">


			<div class="card-header" style="margin-left: -40px;">
				<ul>
					<li>${dto.nick}</li>
					<li>${dto.bwritedate}</li>
					<li>${dto.bhit}</li>
				</ul>

	


			</div>
			<br>
			<p style="margin-left: 20px;" class="btn btn-outline-info">${dto.bcategory}</p>
			<c:if test="${dto.bimg != null}">
				<div style="text-align: right; padding: 0px 55px;">
					<label>[파일첨부]</label> <a href="sbdownload.do?file=${file1 }">${file1 }</a>
				</div>
			
			</c:if>

			<br>
			<div style="text-align: center;">
				<h3>${dto.btitle}</h3>
			</div>
			<div style="margin-top: 50px; padding: 0px 30px;">
				
				<pre>${dto.bcontent}</pre>
				
				<img src="supBoard/upload/${file1}" alt="${file1 }">
				
				
			</div>
			



			<div style="padding: 5px 15px;">
				<c:if test="${ssid==dto.id}">
					<a class="btn btn-secondary btn-sm"
						href="sbupdate.do?bno=${dto.bno}" role="button">수정</a>
					<a class="btn btn-secondary btn-sm"
						href="sbdelete.do?bno=${dto.bno}" role="button">삭제</a>
				</c:if>
				<div style="display: inline-block; margin-left: 850px;">
					<a
						class="btn btn-secondary btn-sm" href="#represult" role="button"
						style="padding: 5px 20px;">댓글수(${repcount})</a>
					<a class="btn btn-secondary btn-sm" href="sblist.do" role="button"
						style="padding: 5px 20px;">목록</a> 
					
				</div>
				<div style="margin-top: 20px; text-align: right;">

					<a href="sbinsert.do" class="btn btn-primary btn-lg active"
						role="button" aria-pressed="true"
						style="width: 200px; background-color: silver; border: 3px solid silver; color: black;">글쓰기</a>

				</div>

			</div>
		</div>
		<form method="post" action="sbaddrep.do" name="frm">
		   <div style="margin:0 auto;">
			<div class="input-group" style="margin-top:70px;">
				<div class="input-group-prepend">
					<span class="input-group-text">댓글</span>
				</div>
				<input type="hidden" name="bno" value="${dto.bno}"> <input
					type="hidden" name="id" value="${sessionScope.id }">
				<textarea class="form-control" aria-label="With textarea"
					name="rcontent" rows="3"></textarea>
				<!-- <input type="button" onclick="send()" value="등록" > -->
				<button type="button" onclick="send()" class="btn btn-outline-dark">등록</button>
			</div>
			</div>

		</form>
		<script>
	

		let bno = ${dto.bno};
		let ssid = '${sessionScope.id}';
		console.log(bno);
		console.log('세션아이디',ssid);
	
		
			$.ajax({
				url : 'sbdetailrep.do',
				data : {
					'bno' : bno
				},
				dataType : 'json',
				method : 'post',
				success : function(data) {

					$.each(data, function(index, item) {
						
						
						
						
						
						var result="<tr>";
						 
						result+="<th>"+item.nick+"("+item.rwritedate+")"+"</th>";
						if(ssid==item.id){
							result+="<th>";
							result+="<a href="+"sbdeleterep.do?repno="+item.repno+"&bno="+item.bno;
							result+=">"+"삭제</a></th>";
						}
						result+="</tr>";
						result+="<tr>";
						result+="<th>"+item.rcontent;
						result+="</th></tr>";
						
					 
						 

						$('#represult').append(result);
					});

				},
				error : function(data) {
					console.log('error', data);
				}

			});
		</script>




		<table class="table">
			<thead id="represult">
				
			</thead>
			

		</table>
		
		
		<div class="input-group" style="width:500px;  margin-left:350px; margin-bottom:150px;">
		
		<input type="text" class="form-control" placeholder="소환사명을 입력하세요">
		<div class="input-group-btn">
			<button class="btn btn-default" type="button">전적검색</button>
		</div>
		
	</div>

	</div>


</body>
</html>