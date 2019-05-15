<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="search">
<input type="text" placeholder="search medicine" name="search" required>
</form>
<table>
    <tr>
        <th>name</th>
        <th>type</th>
        <th>unit</th>
        <th>unit value</th>
        <th>unit price</th>
        <th>expiry date</th>
        <th>stock status</th>
    </tr>
    <c:forEach var="medicine" items="${list}" >
        <tr>
          <td><c:out value="${medicine.name}"> </c:out></td>
          <td><c:out value="${medicine.type}"></c:out></td>
          <td><c:out value="${medicine.unit}"></c:out></td>
          <td><c:out value="${medicine.unitValue}"></c:out></td>
          <td><c:out value="${medicine.unitPrice}"></c:out></td>
          <td><c:out value="${medicine.expDate}"></c:out></td>
          <td><c:out value="${medicine.stockStatus}"></c:out></td>
          <td> 
          <a href="edit?id=<c:out value='${medicine.id}' />">Edit</a>
          <a href="delete?id=<c:out value='${medicine.id}' />">Delete</a>
          </td>
        </tr>
      </c:forEach>
      
</table>
</body>
</html>