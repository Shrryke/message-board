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
            <form action="UserLogInServlet" method="POST">
                <h2>登录</h2><br>
                <input type="text" name="uaccount" placeholder="账号" required="required"/><br/><br/>
                <input type="password" name="upassword" placeholder="密码"required="required"/><br/><br/>
                <input type="submit" value="登录">
            </form>
            <a class="button1" href="register.jsp">注册</a>
        </div>
</body>
</html>