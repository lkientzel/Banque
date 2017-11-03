<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Liste des transactions pour le compte <c:out value="${compte.numero}"/> :
	<br>
	<table>
		<tr>
			<th>date</th>
			<th>libelle</th>
			<th>Montant</th>
		</tr>
			<c:forEach items="${compte.lesTransaction}" var="item">
			<tr>
				<td><c:out value="${item.date}" /></td>
				<td><c:out value="${item.libelle}" /></td>
				<td><c:out value="${item.montant}" /></td>
			</tr>
			</c:forEach>
	</table>
</body>
</html>