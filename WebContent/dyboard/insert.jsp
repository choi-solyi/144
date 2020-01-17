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
	<form action="insertresult.do" method="post" id="dyinsertform">
		<ul>
			<li><label for="category">카테고리</label>
				<select>
					<option value="1">옵션1</option>
					<option value="2">옵션2</option>
					<option value="3">옵션3</option>
				</select>
			</li>
			<li><label>제목</label>
				<input type="text" name="btitle" id="btitle" value="내용을 입력하세요">
				<!-- 파일 업로드 코드 작성  -->
			</li>
			<li>
				<textarea rows="20" cols="100" id="dybcontent" name="bcontent">내용을 입력하세요</textarea>
			</li>
		</ul>
	</form>
	</div>
</body>
</html>