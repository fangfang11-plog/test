<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/ajaxServletDemo1" method="post" id="form">
    <h1 id="loginMsg">LOGIN IN</h1>
    <p><label>Username</label><input type="text" name="username" value="${cookie.username.value}"></p>
    <p><label>Password</label><input type="password" name="password" value="${cookie.password.value}"></p>
    <div id="errorMsg">${login_msg} ${register_msg}</div>
    <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
    <div id="subdiv">
        <p><input type="submit" class="button" value="login up"></p>
        <p><input type="reset" class="button" value="reset"></p>
        <a href="/LoginAndRegister/register.html">没有账号?点击注册</a>
    </div>
</form>
</body>
</html>