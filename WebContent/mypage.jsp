<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 <style>
        .mypage {
            width: 400px;
            margin: 30px auto;

        }
        
        .mypageinfo{
        	width : 400px;
        	height : 100px;
        	font-size:2.6em;
        	text-align: center;
        }
    </style>
</head>
<body>
  <section class="mypage">
	<div class="mypageinfo">My Page</div>
	<c:set var="dto" value="${requestScope.dto }" />
        <form>
            <fieldset disabled>
                <div class="form-group">
                    <label for="id">아이디</label>
                    <input type="text" id="disabledTextInput" class="form-control" placeholder="${dto.id}">
                </div>
                <div class="form-group">
                    <label for="name">이름</label>
                    <input type="text" id="disabledTextInput" class="form-control" placeholder="${dto.name }">
                </div>
                <div class="form-group">
                    <label for="nick">닉네임</label>
                    <input type="text" id="disabledTextInput" class="form-control" placeholder="${dto.nick }">
                </div>
             
                <div class="form-group">
                    <label for="tel">전화번호</label>
                    <input type="text" id="disabledTextInput" class="form-control" placeholder="${dto.tel }">
                </div>
                
                   <div class="form-group">
                    <label for="cp">Challenger Point</label>
                    <input type="text" id="disabledTextInput" class="form-control" placeholder="${dto.cp }">
                </div>
                
                
                <div class="form-group">
                    <label for="disabledSelect">라인</label>
                    <select id="disabledSelect" class="form-control">
                        <option>${dto.line }</option>
                    </select>
                </div>
                <div class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="disabledFieldsetCheck" disabled>
                        <label class="form-check-label" for="disabledFieldsetCheck">
                            Can't check this
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </fieldset>
        </form>




    </section>



</body>
</html>