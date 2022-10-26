<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon"  href="#"/>
    <link href="css/Mystyle.css" rel="stylesheet" type="text/css"/>
    <title>登录</title>
</head>
<body id="bg">
    <div id="login">
        <form action="UserRegisterServlet" method="POST">
            <h2>注册</h2><br>
            <input type="text" name="uname" placeholder="昵称" required="required"/><br/><br/>
            <input type="text" name="uaccount" placeholder="账号" required="required"/><br/><br/>
            <input type="text" name="upassword" placeholder="密码" required="required"/><br/><br/>
            <input type="submit" value="注册">
        </form>
        <a class="button1" href="logIn.jsp">返回登录</a>
    </div>
</body>
</html>
