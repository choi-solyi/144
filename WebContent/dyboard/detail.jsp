<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
        #dydetailwrap{
            border: 1px solid black;
            width: 80%;
            text-align: center;
            margin-top: 50px;
        }
        #dydetailhead div{
            display: inline-block;
                            
        }
        #nick,#category,#bhit,#repnum{
            width: 10%;
            height: 60px;
            border: 1px solid black;
            
        }
        #title{
            width: 50%;
        }
        #deleteboard, #updateboard{
        	display: inline-block;
        }
        
    </style>
</head>
<body>
 <div id="dydetailwrap">
        <div id="dydetailhead">
            <div id="nick"><c:out value="${dto.nick}"/></div>
            <div id="category"><c:out value="${dto.bcategory}" /></div>
            <div id="title"><c:out value="${dto.btitle}" /></div>
            <div id="bhit"><c:out value="${dto.bhit}"/></div>
            <div id="repnum">���(00)</div>
        </div>
        <div id="content"><c:out value="${dto.bcontent }"/></div>
      	<c:if test="${sessionScope.id == dto.id }">
	        <div id="updateboard"><a href="dyupdate.do?bno=${dto.bno}"> <input type="button" value="����" ></a></div>
	        <div id="deleteboard"><a href="dydelete.do?bno=${dto.bno}"> <input type="button" value="����" ></a></div>
        </c:if>
        <br>
        <a href="dylist.do" ><input type="button" value="�������"></a>
    </div>
</body>
</html>