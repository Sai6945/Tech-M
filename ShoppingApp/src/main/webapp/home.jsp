<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function checkLogin(){
	var UserLoggedIn=sessionStorage.getItem("UserLoggedIn");
	if(!UserLoggedIn){
		alert("No access without login");
		window.location.href="login.jsp";
	}else{
		var Udata=JSON.parse(localStorage.getItem("id"+UserLoggedIn));
		document.getElementById("wel").innerText="Welcome! "UData.username;
		document.getElementById("email").innerText=""+userdata.email;
	}
}
function logout(){
	sessionStorage.removeItem("UserLoggedIn");
	window.location.href="login.jsp";
}
</script>
</head>
<body onload="checkLogin()">
<h1>Get a look on trendy insights!! </h1>
<h2 id="wel"></h2>
	<p id="email"></p>
	<button onclick="logout()">Logout</button>
	<div>
	<%
	
	%>

</body>
</html>