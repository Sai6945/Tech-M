<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
<script>
	function loginUser(){
		var password = document.getElementById("password").value;
		var email = document.getElementById("email").value;
		var userData= localStorage.getItem("id_"+email);
		if(userData){
				var user = JSON.parse(userData);
				if(user.password===password){
		
					sessionStorage.setItem("loggedInUser",email);
					window.location.href="dashboard.jsp";
				}else{
					alert("Wrong password");
				}
		}else{
			alert("User Not found");
		}
	}
</script>
	<h1>Login Page</h1>
		<form onsubmit="event.preventDefault(); loginUser();">
			E-mail:<input type="email" id="email" required/>
			Password:<input type="password" id="password" required/>
			<input type="submit" value="Login"/>
					</form>
		<p>ALready Logged in ?<a href="dashboard.jsp">Go to Dashboard</a></p>
		<p>Not Registered ?<a href="register.jsp">Register</a></p>
</body>
</html>