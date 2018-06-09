<%-- 
    Document   : login.jsp
    Created on : 09-jun-2018, 0:29:31
    Author     : benja
--%>

<%@page import="modelo.ControlUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="FrWork/Interno/bootstrap/images/favicon.ico">

    <title>Registrar Usuario</title>

    <!-- Bootstrap core CSS -->
    <link href="FrWork/Interno/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="FrWork/Interno/bootstrap/css/login.css" rel="stylesheet">
    <% 
            HttpSession sesion = request.getSession(true);
           // ControlUsuario user = sesion.getAttribute("usuario") == null ? null : (ControlUsuario) sesion.getAttribute("usuario");
            sesion.invalidate();
    %>
  </head>
  <body class="text-center">
      <form class="form-signin" method="post" action="ControladorLogin">        
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <img class="mb-4" src="" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Registrar Cuenta</h1>
      
      <label for="inputEmail" class="sr-only">Rut o Pasaporte</label>
      <input type="text" id="inputEmail" class="form-control" placeholder="Rut o pasaporte" name="txtUsuario" required autofocus>
      <br><br>
      <a class="btn btn-lg btn-danger btn-block" href="registrar.jsp" ></a>
      <a class="btn btn-lg btn-danger btn-block" href="index.jsp" >Volver</a>
       
      <p class="mt-5 mb-3 text-muted">&copy; botsociety 2018</p>
    </form>
  </body>
</html>
