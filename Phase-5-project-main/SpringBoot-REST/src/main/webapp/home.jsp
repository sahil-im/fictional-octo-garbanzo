<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Spring Boot AWS Demo</h1>
<form action="addStudent">
ID <input type="text" name="id" placeholder="ID"><br></br>
Name <input type="text" name="name" placeholder="Name"><br></br>
<input type="submit" value="add data">
</form>

------------------------------------------------------------------

<form action="getData">
ID <input type="text" name="id" placeholder="ID"><br></br>
<input type="submit" value="fetch data">
</form>
</body>
</html>