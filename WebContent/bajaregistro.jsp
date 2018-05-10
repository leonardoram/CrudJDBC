<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- incluimos un poco de css para darle mejor visualizacion a nuestro proyecto -->

<link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dar de baja un registro</title>
</head>
<body>
<h1> Dar de baja un registro</h1>

<!-- utilizando el tag form mandamos un request a nuestro servlet de tipo get para que ejecute la accion de borrado -->
<form action="BorrarServlet" method="get">

<label for="txtidautor">ID autor </label><input name="txtidautor" type ="text">
<input type="submit" value="borrar">

</form>
<p>
	<a href="index.jsp"><input type="button" value="Regresar"></a>
</p>

</body>
</html>