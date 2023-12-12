<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
</head>
<body>
    <div><a href="login">主页</a></div>
   <form action="userAdd" method="post">
       用户名:<br>
       <input type="text" name="username">
       <br>
       密码:<br>
       <input type="password" name="password">
       <br><br>
       <input type="submit" value="提交" >
   </form>

</body>
</html>


