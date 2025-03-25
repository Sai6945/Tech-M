<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="models.Product"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<style>
    section {
        display: flex; /* Aligns cards in a row */
        gap: 20px; /* Adds spacing between cards */
        flex-wrap: wrap; /* Wraps to next line if space is insufficient */
    }
 
    .card {
        background-color: gray;
        padding: 15px;
        border-radius: 10px;
        width: 250px;
        text-align: center;
        color: white;
    }
 
    button {
        background-color: black;
        color: white;
        padding: 8px 12px;
        border: none;
        cursor: pointer;
        margin-top: 10px;
    }
 
    button:hover {
        background-color: darkgray;
    }
</style>
 
<script>
	function checkLogin(){
		var loggedInUser = sessionStorage.getItem("loggedInUser");
		if(!loggedInUser){
			alert("You must login first");
			window.location.href="index.jsp";
		}else{
			var userdata = JSON.parse(localStorage.getItem("id_"+loggedInUser));
			document.getElementById("wel").innerText="Welcome! "+userdata.username;
			document.getElementById("email").innerText=""+userdata.email;
		}
	}
	
	function logout(){
		sessionStorage.removeItem("loggedInUser");
		window.location.href="index.jsp";
	}
</script>
</head>
<body onload="checkLogin()">
 
	<h1>Dashboard</h1>
	<h2 id="wel"></h2>
	<p id="email"></p>
	<button onclick="logout()">Logout</button>
	<div>
		<%
			List<Product> products = new ArrayList<>();
			products.add(new Product(1,"Phone 19x","This phone is nice",10.0));
			products.add(new Product(2,"Phone 29x","This phone is also nice",12.0));
			products.add(new Product(3,"Charger","This is a charger",2.0));
		%>
	
		<section>
			<% for(Product product : products) { %>
				<div class="card">
					<h3>Product Name: <%= product.getName() %></h3>
					<h3>Product Desc: <%= product.getDesc() %></h3>
					 <h3>Product Price: $<%= product.getPrice() %></h3>
			
					
					<button >Add to Cart</button>
				</div>
			<% } %>
		</section>
	</div>
		
</body>
</html>