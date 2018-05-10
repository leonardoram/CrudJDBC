<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta individual</title>
</head>
<body>
<h1> Realizar consulta individual </h1>
<form action="ConsultaIndividualServlet" method="get">

<label for="txtidautor">ID autor </label><input name="txtidautor" type ="text">
<input type="submit" value="mostrar">

</form>
<p>
	<a href="index.jsp"><input type="button" value="Regresar"></a>
</p>

</body>
</html>