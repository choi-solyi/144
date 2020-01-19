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

	<div class="container">

		<div class="card" style="text-align: center;">
			<div class="card-header">
				<ul>
					<li>${dto.id}</li>
					<li>${dto.bwritedate}</li>
					<li>${dto.bhit}</li>
				</ul>


			</div>

		</div>
		<br>
		<p style="margin-left: 20px;" class="btn btn-outline-info">${dto.bcategory}</p>
		<br>
		<div style="text-align: center;">
			<h3>${dto.btitle}</h3>
		</div>
		<div style="margin-top: 50px; padding: 0px 30px;">
			<pre>${dto.bcontent}</pre>

		</div>

		<div style="padding: 5px 15px;">

			<a class="btn btn-secondary btn-sm" href="sbupdate.do?bno=${dto.bno}"
				role="button">수정</a> <a class="btn btn-secondary btn-sm"
				href="sbdelete.do?bno=${dto.bno}" role="button">삭제</a>

			<div style="display: inline-block; margin-left: 900px;">
				<a class="btn btn-secondary btn-sm" href="sblist.do" role="button"
					style="padding: 5px 20px;">목록</a> <a
					class="btn btn-secondary btn-sm" href="#represult" role="button"
					style="padding: 5px 20px;">댓글</a>
				<div></div>
			</div>
			<div style="margin-top: 20px; text-align: right; margin-right: 10px;">

				<a href="sbinsert.do" class="btn btn-primary btn-lg active"
					role="button" aria-pressed="true"
					style="width: 200px; background-color: silver; border: 3px solid silver; color: black;">글쓰기</a>

			</div>

		</div>

	
		<script>
	

		let bno = ${dto.bno}
		

		$.ajax({
			url:'sbdetailrep.do'
			,data: {'bno':bno}
			,dataType:'json'
			,method:'post'
			,success:function(data){
				
				$.each(data,function(index,item){
					let result= "<tr>";
					result+= "<th>"+item.id+"("+item.rwritedate+")"+"</th>";
					result+= "<th>"+"<a href="+"sbdeleterep.do?repno="+item.repno+"&bno="+item.bno;
					result+= ">"+"삭제</a></th>";
					result+= "</tr>";
					result+= "<tr><th>"+item.rcontent+"</th>";
					result+= "</tr>";
					
					$('#represult').append(result);
				});
				
			}
			,error:function(data){
				console.log('error',data);
			}
			
		});

	
	
	</script>




		<table class="table" style="margin: 0 auto;">
			<thead id="represult">

			</thead>

		</table>
			<form method="post" action="sbaddrep.do" name="frm">

			<div class="input-group" style=" margin:0 auto;">
				<div class="input-group-prepend" >
					<span class="input-group-text">댓글</span>
				</div>
				<input type="hidden" name="bno" value="${dto.bno}">
				<input type="hidden" name="id" value="${dto.id }">
				<textarea class="form-control" aria-label="With textarea" name="rcontent" rows="3"></textarea>
				<input type="button" onclick="send()" value="등록">
				
			</div>


		</form>

	</div>


</body>
</html>