<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>
	<p>Connexion :</p>
	<form action="${pageContext.request.contextPath}/Login" method="post">
		<input type="text" id="login" name="login">
		<br><br>
		<input type="password" id="password" name="password">
		<br><br>
		<button type="submit" name="btnCnx">Connexion</button>
	</form>
</body>
</html>