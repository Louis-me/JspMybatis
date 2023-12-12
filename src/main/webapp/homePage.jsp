<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>主页</title>
		<style>

		</style>
	</head>
	<body>
		<h1>欢迎登录，${username}！</h1>
		<div>
			<a href="logout">注销</a>
		</div>

		<a href="add.jsp">添加</a>
		<table>
			<tr>
				<td>id</td>
				<td>用户名</td>
				<td>状态</td>
				<td>操作</td>
			</tr>
			<c:forEach var="item" items="${userList}">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>
						<a href="userFind?id=${item.id}">修改</a>
					<td>
						<a href="<%=request.getContextPath()%>/userDel?id=${item.id}">删 除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>