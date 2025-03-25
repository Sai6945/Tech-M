<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShoppingApp</title>
<script>
function Loginuser(){
	var username=document.getElementById("uname").value;
	var email=document.getElementById("email").value;
	var password=document.getElementById("password").value;
	var UData=localstorage.getItem("id"+email);
	if(UData){
		var user=JSON.parse(UData);
		if(user.password===password){
			sessionStorage.setItem("UserLoggedIn",email);
		}
		else{
			alert("wrong password");
		}
		else{
			alert("Invalid Credentials");
		}
	}
	alert("Login success");
	window.location.href="register.jsp";
	}
</script>
</head>
<body>
<h1>Welcome to Shopping App</h1>
<form onsubmit="event.preventDefault();Loginuser();">
Username: <input type="text" id="uname" required>
<br>
<br>
Email:	 <input type="email" id="email" required>
<br>
<br>
Password:    <input type="password" id="password" required>
<br>
<br>
<button id="submit">Login</button>
</form>


</body>
</html>