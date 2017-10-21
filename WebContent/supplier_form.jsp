<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suppliers</title>
</head>
<body>
	<form action="SupplierController">
		<label>CompanyName:</label><br>
		<input type = "text" name= "company" value = "${supplier.company}" /><br>
		
		<label>ContactName:</label><br>
		<input type = "text" name= "name" value = "${supplier.name}" /><br>
		
		<label>ContactTitle:</label><br>
		<input type = "text" name= "title" value = "${supplier.title}" /><br>
		
		<label>Address:</label><br>
		<input type = "text" name= "address" value = "${supplier.address}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>