
<%@page import="com.sy.dto.JGBoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<style>
.articlesoly {
	margin: 0;
	padding:;
}

#bgimg {
	padding: 0;
	margin: -5px;
}

/* ul li */
#bgimg1, #bgimg2, #bgimg3 {
	padding: -5px;
	margin: -5px;
	display: inline-block;
}

#bgimg1 {
	padding: -3px;
	width: 30.6%;
	height: 400px;
	background-image: url(http://choisolyi.dothome.co.kr/lol/img/jg3_44.jpg);
	background-repeat: no-repeat;
	background-position: top;
}

#bgimg2 {
	padding: -3px;
	width: 39.6%;
	height: 400px;
	background-image: url(http://choisolyi.dothome.co.kr/lol/img/jg3_11.jpg);
	background-repeat: no-repeat;
	background-position: top;

	/* background-attachment: fixed;*/
}

#bgimg3 {
	padding: -3px;
	width: 30.6%;
	height: 400px;
	background-image: url(http://choisolyi.dothome.co.kr/lol/img/jg3_33.jpg);
	background-repeat: no-repeat;
	background-position: right;
}

.imglinetop {
	color: white;
	width: 60%;
	height: 60px;
	margin: 0 auto;
	text-align: center;
	font-size: 2.3em;
	position: relative;
	bottom: 240px;
	border-radius: 10px;
	padding: 1px 0px 0px 0px;
	font-size: 6em;
	font-weight: 900;
	text-shadow: 0 0 30px #000000;
}

.imglines {
	width: 60%;
	height: 60px;
	margin: 0 auto;
	text-align: center;
	font-size: 2.3em;
	background-color: rgb(255, 255, 255, 0.88);
	position: relative;
	bottom: 150px;
	border-radius: 10px;
	padding: 1px 0px 0px 0px;
}

.gesipan {
	width: 1400px;
	height: 600px;
	border: 1px solid black;
	margin: 30px auto;
	padding: 20px;
}

.gesipantitle {
	width: 1400px;
	border: 1px solid black;
	margin: 0px auto 30px;
	padding: 20px;
	border-radius: 20px;
	font-size: 2.2em;
	font-weight: 600;
}
/*  */
.jgcontent {
	margin: 0 auto !important;
	width: 1200px !important;
	background-color: rgb(250, 250, 250, 0.7);
	position:relative;
	top:-100px;

}

.card-title {
	background-color: rgb(250, 250, 250, 0.9);
}

.card-text {
	height: 400px;
}

.btnsol1, .btnsol2, .btnsol3 {
	
}

.btnsol2, .btnsol1 {
	float: right;
	margin: 0px 20px;
}

.prevnext {
	width: 1200px !important;
	margin: 30px auto;
}

.replist {
	margin: 10px auto;
	width: 1220px;
	padding: 5px;
	position: fixed;
}

.botrep {
	display: inline-block;
	width: 260px;
	margin: 10px 5px auto;
	padding: 5px;
	height: 300px;
	vertical-align: top;
}

.card-body {
	padding: 10px !important;
}

.writerep {
	width: 800px;
	margin: 0 auto;
}

.form-control, .mb-3 {
	width: 800px;
}

.inlineblockcontent {
	display: inline-block;
}

.btndel, .btnupd {
	padding: 0px;
	margin: 0px 3px;
	float: right;
}

.alert a {
	text-decoration: none;
}

</style>

<script>
function send(){
	if(document.frm.title.value!="")
		document.frm.submit();
}


function delrep(repno, bno){
	console.log("-------------------");
	console.log(repno);
	console.log(bno);
	console.log("-------------------");
	location.href="jgdelrep.do?repno="+repno+"&bno="+bno;
}


</script>


</head>
<body>

	<!-- 상단이미지 -->

	<article id="articlesoly">
		<ul id="bgimg">
			<li id="bgimg1"></li>
			<li id="bgimg2"></li>
			<li id="bgimg3"></li>
		</ul>

		<p class="imglinetop">J U N G L E</p>
		<p class="imglines">
			<I>"이 여왕님의 지배를 받는 무한한 영광을 내려주지."</I>
		</p>

	</article>
	<!-- 상단이미지 끝  -->


	<%
		request.setCharacterEncoding("utf-8");
		//	JGBoardDTO dto = (JGBoardDTO) request.getAttribute("dto");
	%>

	<c:set var="dto" value="${requestScope.dto }" />


	<div class="jgcontent">
		<div class="card-header">

			글번호 ${dto.bno } / [ ${dto.bcategory } ] / 작성자 ${dto.nick } / 조회수
			${dto.bhit }
			<!-- 작성자 -->
			<%-- 		글번호  <%=dto.getBno()%>
			[<%=dto.getBcategory()%>] / 조회수
			<%=dto.getBhit()%>
			/ 작성자
			<%=dto.getNick()%> --%>

		</div>
		<div class="card-body">
			<h5 class="card-title" style="padding: 20px;">${dto.btitle}<%-- <%=dto.getBtitle()%> --%>
			</h5>
			<pre class="card-text" style="padding: 20px; white-space: pre-wrap;">${dto.bcontent}<%-- <%=dto.getBcontent()%> --%>
			</pre>

			<a href="jglist.do" class="btn btn-success btnsol">목록 보기</a>


			<!-- 본인일 경우에만 !!!!! -->

			<c:if test="${sessionScope.id == dto.id}">

				<a href="jgupdate.do?bno=${dto.bno}" class="btn btn-success btnsol">수정</a>

				<a href="jgdelete.do?bno=${dto.bno}" class="btn btn-success btnsol">삭제</a>

			</c:if>


		</div>
	</div>


	<!-- 이전글, 다음글  -->

	<div class="prevnext">

		<div class="alert alert-info" role="alert">
			<a href="jgdetail.do?bno=${nexdto.bno}"><table>
					<tbody class="prevnexttable">
						<tr>
							<td style="width: 80px; color: black;">▲ ${nexdto.bno}</td>
							<td style="width: 800px; color: black;">|| ${nexdto.btitle }
							</td>
							<td style="width: 300px; color: black;">|| ${nexdto.nick}</td>
							<td style="width: 30px; color: black;">▲</td>
						</tr>
					</tbody>
				</table></a>
		</div>
		<div class="alert alert-success" role="alert">
			<a href="jgdetail.do?bno=${predto.bno}"><table>
					<tbody class="prevnexttable">
						<tr>
							<td style="width: 80px; color: black;">▼ ${predto.bno}</td>
							<td style="width: 800px; color: black;">|| ${predto.btitle }
							</td>
							<td style="width: 300px; color: black;">|| ${predto.nick}</td>
							<td style="width: 30px; color: black;">▼</td>
						</tr>
					</tbody>
				</table> </a>
		</div>



	</div>

	<%-- 		 <div class="prevnext">
		<div class="alert alert-success" role="alert">
			<a href="jgdetail.do?bno=${dto.bno-1}">▲ 안 녕</a>
		</div>	


		<div class="alert alert-info" role="alert">
			<a href="jgdetail.do?bno=${dto.bno+1}">▲ ㅂㅇ</a>
		</div>
	</div> - --%>

	<!-- 댓글 쓰기 -->

	<div class="writerep">
		<form method="post" action="jgaddrep.do" name="frm"
			class="was-validated">
			<div class="form-group">
				<label for="disabledTextInput">아이디</label> <input type="text"
					id="id" class="form-control" name="id" placeholder="자동 입력"
					value="${sessionScope.id}" readonly="readonly">
			</div>


			<div class="mb-3">
				<label for="validationTextarea">내용</label>
				<textarea class="form-control is-invalid" name="rcontent"
					id="rcontent" placeholder="Required example textarea" required></textarea>
				<!-- <div class="invalid-feedback">Please enter a message in the
					textarea.</div> -->
			</div>



			<div class="inlineblockcontent">
				<input type="hidden" name="bno" id="bno" value="${dto.bno }">


				<input type="submit" onclick="send();" class="btn btn-success"
					value="댓글 쓰기">


			</div>
		</form>

	</div>


	<!-- 댓글 목록 보기 -->
	<div id="replist"
		style="margin: 10px auto; width: 1220px; padding: 5px;"></div>
		
		

	<!-- 	<input type="submit" onclick="update();" class="btn btn-success" value="수정">
	<input type="submit" onclick="delete();" class="btn btn-success" value="삭제"> 
  -->

	<script>
    let bno = ${dto.bno};
	let ssid = '<%=(String) session.getAttribute("id")%>';
		console.log(bno);
		console.log('세션아이디');
		console.log(ssid);

		$
				.ajax({
					url : 'listreq.do',
					data : {
						'bno' : bno
					},
					dataType : 'JSON',
					method : 'post',
					success : function(data) {
						console.log('test-alldata :', data);
						$('#replist').empty();
						$
								.each(
										data,
										function(index, item) {
											console.log(index);
											console.log(item);

											console.log(item.repno);
											if (index % 3 == 0) {
												let rep = "<div class='card border-success mb-3 botrep' style='max-width: 18rem;'>";
												rep += '<div class="card-header"> 댓글 ';
												if (ssid == item.id) {
													rep += '<input type="submit" onclick=delrep('
															+ item.repno
															+ ','
															+ item.bno
															+ '); class="btn btn-success btndel" value="삭제">';
													rep += '<input type="submit" onclick=update();" class="btn btn-success btnupd" value="수정">';
												}
												rep += "</div><div class='card-body text-success'><h5 class='card-title' style='text-align:center;'>"
														+ item.nick
														+ "<br><small> ( "
														+ item.rwritedate
														+ " )</h5>";
												rep += "<p class='card-text'>"
														+ item.rcontent
														+ "</p>	</div></div>";
												$('#replist').append(rep);
											} else if (index % 2 == 0) {
												let rep = "<div class='card border-info mb-3 botrep' style='max-width: 18rem;'>";
												rep += '<div class="card-header"> 댓글 ';
												if (ssid == item.id) {
													rep += '<input type="submit" onclick=delrep('
															+ item.repno
															+ ','
															+ item.bno
															+ '); class="btn btn-info btndel" value="삭제"> ';
													rep += '<input type="submit" onclick=update();" class="btn btn-info btnupd" value="수정">';
												}
												rep += "</div><div class='card-body text-info'><h5 class='card-title'  style='text-align:center;'>"
														+ item.nick
														+ "<br><small> ( "
														+ item.rwritedate
														+ " )</h5>";
												rep += "<p class='card-text'>"
														+ item.rcontent
														+ "</p>	</div></div>";
												$('#replist').append(rep);

											} else {
												let rep = "<div class='card border-dark mb-3 botrep' style='max-width: 18rem;'>";
												rep += '<div class="card-header"> 댓글 ';
												if (ssid == item.id) {
													rep += '<input type="submit" onclick=delrep('
															+ item.repno
															+ ','
															+ item.bno
															+ '); class="btn btn-dark btndel" value="삭제"> ';
													rep += '<input type="submit" onclick=update();" class="btn btn-dark btnupd" value="수정">';
												}
												rep += "</div><div class='card-body text-dark'><h5 class='card-title'  style='text-align:center;'>"
														+ item.nick
														+ "<br><small> ( "
														+ item.rwritedate
														+ " )</h5>";
												rep += "<p class='card-text'>"
														+ item.rcontent
														+ "</p>	</div></div>";
												$('#replist').append(rep);
											}
										});

					},
					error : function(data) {
						console.log('error : ', data);
					}
				});
	</script>
</body>
</html>