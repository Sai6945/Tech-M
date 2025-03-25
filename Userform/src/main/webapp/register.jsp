<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body>
		<script>
			function registerUser(){
				var username = document.getElementById("username").value;
				var password = document.getElementById("password").value;
				var email = document.getElementById("email").value;
				
				localStorage.setItem("id_"+email,JSON.stringify({
					username:username,
					password:password,
					email:email
				}))
				alert("Registration Successful!");
				window.location.href="index.jsp";
				
			}
		</script>
		<h1>Register Page</h1>
		<form onsubmit="registerUser(); return true;">
			Username:<input type="text" id="username" required/>
			E-mail:<input type="email" id="email" required/>
			Password:<input type="password" id="password" required/>
			<input type="submit" value="Register"/>
		</form>
		<p>Already Registered ?<a href="index.jsp">Login</a></p>
</body>
</html>