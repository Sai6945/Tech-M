<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function Registeruser(){
	var username=document.getElementById("uname").value;
	var email=document.getElementById("email").value;
	var password=document.getElementById("password").value;
	localStorage.setItem("id"+email,JSON.stringify({
		username:username,
	password:password,
	email:email
	}))
	alert("Register done Successfully!!");
	window.location.href="login.jsp";
}
</script>
</head>
<body>
<form onsubmit="event.preventDefault();Registeruser();">
Username: <input type="text" id="uname" required>
<br>
<br>
Email:	 <input type="email" id="email" required>
<br>
<br>
Password:    <input type="password" id="password" required>
<br>
<br>
Contact:  <input type="number" id="number">
<br>
<br>

<button id="submit">Register</button>
<p>Already have an account?<a href="login.jsp">Login here</a></p>

</form>
</body>
</html>