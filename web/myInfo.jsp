<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/Mystyle.css">
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

    <div id="infoBox">
        <div id="info_left">
             <img src="<%=user.getImage()%>" alt="" id="bgimage">
        提交照片<br>
        <form action="UploadImageServlet" method="post" enctype="multipart/form-data">
            <input type="file" accept="image/*" name="spicture" class="button2"/>
            <input type="submit" value="提交" class="button2">
        </form>
        </div>
        <div id="info_right">
            <form action="UpdateMyInfoServlet">
                姓名:<input type="text" name="username" value="<%=user.getUname()%>"><br>
                账号:<input type="text" name="uaccount" value="<%=user.getUaccount()%>" readonly="readonly"><br>
                密码:<input type="text" name="upassword" value="<%=user.getUpassword()%>"><br>
                <input type="submit" value="修改" class="button2 size1">    
            </form>
        </div>
       
    </div>
</body>
</html>