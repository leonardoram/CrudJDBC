<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear registro</title>
</head>
<body>
<h1> Bienvenido al registro de autores de leoxenon</h1>
<form action="AltaServlet" method="get">
<!-- <p> -->
<!-- 	<label for ="txtidautor">idautor </label><input  name="txtidautor" id="txtidautor" type="text" > -->
<!-- </p> -->
<!-- omitimos la parte del idautor por que lo declaramos como autoincremental dentro de nuesta BD -->
<p>
	<label for ="txtnombre">Nombre </label><input name="txtnombre"  id="txtnombre" type="text" >
</p>
<p>
	<label for ="txtapellido">Apellido </label><input name="txtapellido" id="txtapellido" type="text" >
</p>
<p>
	<label for ="txtdomicilio">Domicilio </label><input name="txtdomicilio" id="txtdomicilio" type="text" >
</p>
<p>
	<label for ="txtsalario">Salario: </label><input name="txtsalario" id="txtsalario" type="text" >
</p>
<p>
	<input id="enviar" type="submit" value="Guardar autor">
</p>
</form>
<p>
	<a href="index.jsp"><input type="button" value="Regresar"></a>
</p>

</body>
</html>