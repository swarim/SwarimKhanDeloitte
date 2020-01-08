<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<script>
	function checklogin(valuser) {
		user = "";
		xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) {
				user = xmlhttp.responseText;
				alert("user: " + user);
			}
		}
		xmlhttp.open("GET", "usercheck?login=" + valuser, true);
		xmlhttp.send(null); // value only for PUT, req is async by default
	}
</script>
</head>
<body>
	<%
		String user = (String) session.getAttribute("user");
		if (user == null || !user.equals("admin")) {
	%>a
	<h1>You are not logged in as ADMINISTRATOR</h1>
	<a href="index.html">Log in</a>
	<%
		} else {
	%>
	<h3>${usertype}Admin</h3>

	<form action="create" method="post">
		Login: <input type="text" name="login" onblur="checklogin(this.value)"
			value="" /><br> Password <input type="password" name="pswd"
			value="" /><br> User Type <input type="text" name="type"
			value="" /></br> <input type="submit" value="CREATE USER" />
	</form>

	<a href="logout">LOG OUT</a>
	<%
		}
	%>
</body>
</html>