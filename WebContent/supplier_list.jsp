<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suppliers</title>
</head>
<body>
<table border= "1">
		<tr>
			
			<th>
			
				<form action="SupplierController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>CompanyName</th>
			 <th>ContactName</th>
			  <th>ContactTitle</th>
			  <th>Address</th>
			
		</tr>
			<c:forEach var="supplier" items="${suppliers}">
		
		<tr>
			<td>
				<form action= "SupplierController">
					<input type = "hidden" name = "id" value= "${supplier.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${supplier.id}</td>
			<td> ${supplier.company}</td>
			<td> ${supplier.name}</td>
			<td> ${supplier.title}</td>
			<td> ${supplier.address}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>


</body>
</html>