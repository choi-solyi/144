<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#dywritewrap{
		width:60%; 
		margin : 50px auto;
		border: 1px solid black;
	}
    #dyinsertform{
        width: 90%;
        margin: 0px auto;
    }
	#dyinsertform ul li{
		margin : 10px;
        width: 50%;
	}
	#dyinsertform ul li label{
		margin : 0px 10px;
	}
	#dybcontent{
		position: relative;
        right: 20px;
	}


</style>
</head>
<body>
	<div id="dywritewrap">
	<form action="dyinsertresult.do" method="post" id="dyinsertform">
		<ul>
			<li><label for="dybcategory">카테고리</label>
				<select id="dybcategory" name="bcategory">
					<option value="1" selected>옵션1</option>
					<option value="2">옵션2</option>
					<option value="3">옵션3</option>
				</select>
			</li>
			<li><label for="dybtitle">제목</label>
				<input type="text" name="btitle" id="dybtitle" value="제목을 입력하세요" required>
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