<%@ page import="controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="css/Login.css">
</head>
<body>
	<header class="contenido">
        <fieldset>
			<legend>BIENVENIDOS A LA TIENDA GENERICA</legend>
            <form action="Login" method="get">
                <label for="">Usuario: 
                    <input type="text" name="user">
                </label>
                <label for="">Contraseña: 
                    <input type="password" name="pass">
                </label>
                <button type="submit" name="btnAceptar">Aceptar</button>
            </form>
        </fieldset>
    </header>
</body>
</html>