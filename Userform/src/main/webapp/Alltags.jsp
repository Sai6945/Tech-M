<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="models.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>

	<div id="coretags">
		<jsp:include page="tags.jsp" />
		
		 <!-- Ensure header.jsp exists -->
		<c:out value="hello world"/>
		<c:set var="age" value="18"/>  
		<c:out value="${age}" />
		<c:remove var="age"/>
		
		<!-- Conditional Execution -->
		<c:set var="name" value="admin"/>
		<c:if test="${name=='admin'}">
			<p>You are an admin</p>
		</c:if>

		<c:set var="per" value="90"/>
		<c:if test="${per>=80}">
			<p>You scored Great! :)</p>
		</c:if>

		<!-- Switch Case -->
		<c:set var="per" value="50"/>
		<c:choose>
			<c:when test="${per>=90}"><p>A grade</p></c:when>
			<c:when test="${per>=80}"><p>B grade</p></c:when>
			<c:when test="${per>=60}"><p>C grade</p></c:when>
			<c:otherwise><p>Fail</p></c:otherwise>
		</c:choose>

		<!-- Iterate Over List -->
		<c:set var="items" value="10,20,30,40,50"/>
<c:forEach var="item" items="${fn:split(items, ',')}">
    <p>${item}</p>
</c:forEach>
		
		<!-- Iterate Over Tokens -->
		<c:set var="fruits" value="mango,banana,grapes,orange"/>
		<c:forEach var="word" items="${fn:split(fruits, ',')}">
			<p>${word}</p>
		</c:forEach>
	</div>

	<!-- Functional Tags -->
	<div id="functionaltags">
		<p>Length: ${fn:length("hello world")}</p>
		<p>Length: ${fn:length(fn:split(items, ','))}</p>
		<p>${fn:toUpperCase("abcdef")}</p>
		<c:if test="${fn:contains('hello world','world')}">
			<p>Word found</p>
		</c:if>
	</div>

	<!-- User List Table -->
	<c:if test="${not empty userlist}">
		<table>
			<tr>
				<th>Name</th>
				<th>Email</th>
			</tr>
			<c:forEach var="user" items="${userlist}">
				<tr>
					<td>${user.name}</td>
<td>${user.email}</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>
