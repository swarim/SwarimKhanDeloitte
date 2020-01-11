<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User login</title>

</head>

<body style="background-color: red">
	<h1>Login Verify</h1>
	<form:form action="submitUser.obj" method="post" modelAttribute="user">
		<table border="1">
			<tr>
				<td>User Name</td>
				<td><form:input path="name" /> <form:errors path="name" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" path="pwd" /> <form:errors
						path="pwd" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /> <input type="reset"
					value="Cancel"></td>
				<td><a href="display.obj">Go Home</a><br> <br></td>
			</tr>
		</table>
	</form:form>
</body>
</html>