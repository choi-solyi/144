<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<!-- 댓글 script -->
<script>
	function send() { //댓글 작성 insert
		if (document.rep.rcontent.value != "")
			document.rep.submit();
	}

	function del(repno, bno) { //del
		location.href = 'EBdelrep.do?repno=' + repno + '&bno=' + bno;
	}
	$(document)
			.ready(
					function() { // replist
						let bno = ${dto.bno};
						$.ajax({
									url : 'EBrepdetail.do',
									method : 'post',
									data : {
										'bno' : bno
									},
									dataType : 'json',
									success : function(data) {
										$.each(data, function(index, item) {
											let result ='<table class="table table-hover table-sm" style="table-layout:fixed"><tbody><tr class="re">';
											result +='<td width="10%">'+item.repno+'</td>';
											result +='<td width="20%">'+item.id+'</td>';
											result +='<td width="50%">'+item.rcontent+'</td>';
											result +='<td width="15%">'+item.rwritedate+'</td>';
											result += "<td><input type='button' class='btn btn-outline-primary btn-sm' value='x' onclick=del("+ item.repno+ ","+ item.bno+ ")></td>";
											result += "</tr></tbody></table>";
										    $('#result').append(result);
														});
													}
									,error : function(data) {
										console.log('error', data);
									}
								});
					});
</script>


<body>
	<!-- 본문 detail -->
	<div class="container mt-5 text-center">

		<div class="jumbotron">
			<h1>대회 일정</h1>
		</div>

		<!-- 글번호, 제목 -->
		<div class="row border-bottom bg-light py-2 px-lg-3 font-weight-bold m-0">
			<div class="col-md-2">${dto.bno}</div>
			<div class="col-md-3 text-left">${dto.btitle}</div>
		</div>
		<!-- 날짜, 조회수, 추천 -->
		<div class="row border-bottom py-2 px-lg-3 m-0">
			<div class="col-md-2">날짜</div>
			<div class="col-md-2">${dto.bcaldate}</div>
			<div class="col-md-2">조회수</div>
			<div class="col-md-2">${dto.bhit}</div>
			<div class="col-md-2">추천</div>
			<div class="col-md-2">${dto.bup}</div>
		</div>

		<!-- 내용 이미지 첨부 -->
		<div class="col-sm-12 border-bottom mb-3" style="min-height:500px">
			<c:if test="${dto.bimg ne null}">
				<img alt="이미지" src="calBoard/calupload/${dto.bimg}">
			</c:if>
			<div class="text-left">${dto.bcontent}</div>
			<div>${dto.id }</div>
		</div>

		<!-- 목록으로, 수정, 삭제 -->
		<div class="col-sm-12 d-flex mb-3">
			<a href="EBlist.do" class="btn btn-primary mr-auto p-2">목록으로</a>
			<a href="EBupdate.do?bno=${dto.bno}" class="btn btn-primary p-2 mr-1">수정</a> <a
				href="EBdelete.do?bno=${dto.bno}" class="btn btn-primary p-2">삭제</a>
		</div>

		${dto.bno}
		<!-- 댓글 -->
		<c:if test="${sessionScope.id ne null}">
			<form method="post" action="EBaddrep.do" name="rep">
				<div class="input-group mb-3">
					<input type="hidden" name="bno" value="${dto.bno}">
					<textarea class="form-control" name="rcontent"></textarea>
					<div class="input-group-append">
						<input class="input-group btn btn-outline-primary " type="button" onclick="send()" value="추가">
					</div>
				</div>
			</form>
			<table id="result"></table>
		</c:if>

	</div>

</body>
</html>