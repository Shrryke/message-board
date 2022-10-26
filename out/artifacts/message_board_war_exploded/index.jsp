<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import ="com.Entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="css/Mystyle.css">
<title>首页</title>
</head>
<body id="bg">
    <div id="header">
        <div id="headname">
            首页
        </div>
        <div id="pst1">	
            <%	
        		User user=(User)session.getAttribute("user");
            	if(user==null){
            %>
            
       		当前未登录!!
            <a href="logIn.jsp" class="button1">去登陆</a>
            <%
            	}
            	else{
         
            %>
            <img src=<%=user.getImage()%> alt="" id="image">
            <div id="username"><a href="myInfo.jsp"><%=user.getUname()%></a></div>
            <div id="exit"><a href="UserQuitServlet" class="button1">退出</a></div>
            <%
            	}
            %>
        </div>
 
    </div>


    <div id="nav">
        <ul>
            <li><a href="index.jsp">首页</a></li>
            <li><a href="QueryAllMessageServlet?num=1">留言</a></li>
        </ul>
    </div>

    <div id="infoBox">
        <div id="info_left" class="center">
            这里是首页目录
        </div>
        <div id="info_right" class="center">
           
           欢迎您
        </div>
    </div>
        
    
   

</body>
</html>