<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Client" %>
<%@ page import="Model.Compte" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="Inter.inter" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="${language}">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Liste des comptes</title>
	</head>
	<body>
	
		<ul>
			<li><a href="${pageContext.request.contextPath}/NewCompte">Nouveau Compte</a></li>
			<li><a href="${pageContext.request.contextPath}/Password">Changer de mot de passe</a></li>
		</ul>
		
		<form>
            <select id="language" name="language" onchange="submit()">
            	<option value="fr" ${language == 'fr' ? 'selected' : ''}>Français</option>
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
            </select>
        </form>
		<br>
		<br>
		<fmt:message key="Nom" />
		Liste des comptes pour <c:out value="${client.nom}"/> <c:out value="${client.prenom}"/> :	
		<br>
			<table>
				<tr>
					<th>Numéro</th>
					<th>Nom</th>
					<th>Solde</th>
					<th>Consulter</th>
				</tr>
				<c:forEach items="${client.lesComptes}" var="item">
					<tr>
						<td><c:out value="${item.numero}" /></td>
						<td><c:out value="${item.libelle}" /></td>
						<td><c:out value="${item.solde}" /></td>
						<td>
						<form action="${pageContext.request.contextPath}/Transaction/${item.numero}" method="post">
							<button type="submit" name="btnConsulter">-></button>
						</form>	
						</td>
					</tr>
				</c:forEach>
			</table>
		
	</body>
</html>