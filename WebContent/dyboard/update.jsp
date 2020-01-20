<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	#dyupdatewrap{
		width:60%; 
		margin : 50px auto;
		border: 1px solid black;
	}
    #dyupdateform{
        width: 90%;
        margin: 0px auto;
    }
	#dyupdateform ul li{
		margin : 10px;
        width: 50%;
	}
	#dyupdateform ul li label{
		margin : 0px 10px;
	}
	#dybcontent{
		position: relative;
        right: 20px;
	}


</style>
</head>
<body>
<div id="dyupdatewrap">
	<form action="dyupdateresult.do" method="post" id="dyupdateform">
		<ul>
			<input type="hidden" name ="bno" value="${bno}">
			<li><label for="dybcategory">카테고리</label>
				<select id="dybcategory" name="bcategory">
					<option value="일반" selected>일반</option>
					<option value="유머">유머</option>
					<option value="꿀팁">꿀팁</option>
				</select>
			</li>
			<li><label for="dybtitle">제목</label>
				<input type="text" name="btitle" id="dybtitle" placeholder="제목을 입력하세요" required>
				<!-- 파일 업로드 코드 작성  -->
			</li>
			<li>
				<textarea rows="20" cols="100" id="dybcontent" name="bcontent" required>내용을 입력하세요</textarea>
			</li>
			<li>
				<input type="submit" value="등록">
				<input type="reset" value="취소">
 			</li>
		</ul>
	</form>
	</div>

</body>
</html>