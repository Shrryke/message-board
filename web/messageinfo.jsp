<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.Entity.User" %>
    <%@ page import ="com.Entity.Message" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Mystyle.css">
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<%
		Message message=(Message)request.getAttribute("message");
	%>
	
    <div id="messageBox" class="size4">
        <div id="message_box">
            <div id="pst2">
                <img src="<%=message.getImage()%>" alt="" id="image">
                <div id="username"><a href="QueryUserAllMessagesServlet?account=<%=message.getUaccount()%>&num=1"><%=message.getUsername()%></a></div>
                <div id="time"><%=message.getTime()%></div>
            </div>
            <div id="newcontent"><%=message.getMessage()%>
            </div>
        </div>
</body>
</html>