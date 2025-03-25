<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First JSP File</title>
</head>
<body>

<h1>This is a dynamic web page</h1>

<!-- Include header.jsp -->
<%@ include file="header.jsp" %>

<!-- Retrieve request method -->
<% String type = request.getMethod(); %>
<p>Method: <%= type %></p>

<!-- Retrieve parameter 'hello' -->
<% String name = request.getParameter("hello"); %>
<p>Parameter is: <%= (name != null) ? name : "No parameter received" %></p>

<!-- Java scriptlet loop -->
<% for (int i = 0; i < 10; i++) { %>
    <p>i = <%= i %></p>
<% } %> 

<!-- Simple arithmetic operation -->
<% int a = 10, b = 20, sum = a + b; %>
<p>Sum is: <%= sum %></p>

<!-- Corrected form syntax -->
<form action="HelloServlets" method="post">
    <label>Name:</label>
    <input type="text" name="username"/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>