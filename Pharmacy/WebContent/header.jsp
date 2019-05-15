<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.menu {
	display: inline-block;
	background-color: black;
	width: 100%;
} 
#heading {
	float: left;
	color: white;
	margin-left: 10px;
	margin-top: 10px;
	font-size: 25px;
} 
</style>
</head>
<body>
<jsp:include page="editMedicine.jsp" />
<jsp:include page="List.jsp" />
<jsp:include page="Login.jsp" />
<jsp:include page="search.jsp" />
<div class="menu">
		<h3 id="heading">Best Online Pharmacy</h3>
		<ul>
 		    <li><a href="#logout">Logout</a></li>
  			<li><a href="#Username">Username</a></li>
  			<li><a href="#Cart">Cart</a></li>
  			<li><a class="active" href="#Home">Home</a></li>
		</ul>
	</div>  

</body>
</html>