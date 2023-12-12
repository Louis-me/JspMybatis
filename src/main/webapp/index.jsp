<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>主页</title>
</head>
<body>
    <%
	    String user=(String)session.getAttribute("username");
        if (user != null) {
            // 用户已登录
             //response.sendRedirect("homePage.jsp");
             out.println("<a href=\"homePage.jsp\">");
             out.println("登录成功主页");
             out.println("</a>");
        } else {
            // 用户未登录
            out.println("<a href=\"login.jsp\">");
            out.println("登录界面");
            out.println("</a>");
        }
    %>
</body>
</html>


