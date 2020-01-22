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
		background-color : #255ad4;
	}
    #dyinsertform{
        width: 90%;
        margin: 0px auto;
    }
    #dyinsertform ul{
    	list-style : none;
    }
	#dyinsertform ul li{
		margin : 10px;
        width: 50%;
        
	}
	#dyinsertform ul li label{
		margin : 0px 10px;
		color : white;
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
		<input type="hidden" value="${sessionScope.id }" name="id">
			<li><label for="dybcategory">카테고리</label>
				<select id="dybcategory" name="bcategory">
					<option value="일반" selected>일반</option>
					<option value="유머">유머</option>
					<option value="꿀팁">꿀팁</option>
				</select>
			</li>
			<li><label for="dybtitle">제목</label>
				<input type="text" name="btitle" id="dybtitle" placeholder="제목을 입력하세요" maxlength="7" required>
				<!-- 파일 업로드 코드 작성  -->
			</li>
			<li>
				<textarea rows="20" cols="100" id="dybcontent" name="bcontent" placeholder="내용을 입력하세요" required></textarea>
			</li>
			<li>
				<input class="btn btn-success" type="submit" value="등록">
				<a href="dylist.do"><input class="btn btn-danger" type="button" value="취소"></a>
 			</li>
		</ul>
	</form>
	</div>
</body>
</html>