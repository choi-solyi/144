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
			
			<li><label for="dybcategory">ī�װ�</label>
				<select id="dybcategory" name="bcategory">
					<option value="�Ϲ�" selected>�Ϲ�</option>
					<option value="����">����</option>
					<option value="����">����</option>
				</select>
			</li>
			<li><label for="dybtitle">����</label>
				<input type="text" name="btitle" id="dybtitle" placeholder="������ �Է��ϼ���" required>
				<!-- ���� ���ε� �ڵ� �ۼ�  -->
			</li>
			<li>
				<textarea rows="20" cols="100" id="dybcontent" name="bcontent" placeholder="������ �Է��ϼ���" required></textarea>
			</li>
			<li>
				<input type="hidden" name ="bno" value="${requestScope.bno}">
				<input type="submit" value="����">
				<input type="reset" value="���">
 			</li>
		</ul>
	</form>
	</div>

</body>
</html>