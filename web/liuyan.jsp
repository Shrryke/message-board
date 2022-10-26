<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %>
<%@ page import ="com.Entity.Message" %>
<%@ page import ="com.Entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="css/Mystyle.css">
<title>留言</title>
</head>
<body id="bg">
    <div id="header">
        <div id="headname">
            留言板
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


    <div id="formBox">
        有什么想留言告诉大家的
        <form action="SubmitMessageServlet">
            <textarea name="message" id="" cols="" rows=""></textarea>
            <input type="submit" value="发表">
        </form>
    </div>
    <%
			List<Message> messages=(List<Message>)request.getAttribute("message");
			for(Message message:messages){
	%>
    
    
    <div id="messageBox" class="size2">
        <div id="message_left">
            <div id="pst2">
                <img src="<%=message.getImage()%>" alt="" id="image">
                <div id="username"><a href="QueryUserAllMessagesServlet?account=<%=message.getUaccount()%>&num=1"><%=message.getUsername()%></a></div>
                <div id="time"><%=message.getTime()%></div>
            </div>
            <div id="content"><a href="QueryMessageByIdServlet?id=<%=message.getID()%>"><%=message.getMessage()%></a></div>
        </div>
        <div id="message_right">
     		<%
     			if(user!=null && user.getUaccount().equals(message.getUaccount())){
     		%>
            <a href="DeleteMessageById?id=<%=message.getID()%>" class="button2">删除</a>
            <%
     			}
            %>
        </div>
        
    </div>
    
    <%
			}
	%>


    <div id="footerBox">
        <a href="QueryAllMessageServlet?num=1" class="button2">首页</a>
        <a href="QueryAllMessageServlet?num=<%=(int)request.getAttribute("num")-1%>" class="button2">上一页</a>
        <div id="pagenum"><%=request.getAttribute("num")%></div>
        <a href="QueryAllMessageServlet?num=<%=(int)request.getAttribute("num")+1%>" class="button2">下一页</a>
        <a href="QueryAllMessageServlet?num=<%=request.getAttribute("MaxPage")%>" class="button2">尾页</a>
    </div>
    
        
    
   

</body>
</html>