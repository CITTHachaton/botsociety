<%-- 
    Document   : index.jsp
    Created on : 08-jun-2018, 22:47:27
    Author     : benja
--%>

<%@page import="conexion.ControladorCorreo"%>
<%@page import="dao.ComunaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Comuna"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
      
        <%   ArrayList<Comuna> comunas = new ArrayList(); 
        
             comunas = (new ComunaDAO()).Listar();
        
             int x = (new ControladorCorreo()).enviar("benja.mora.torres@gmail.com","Hola", "Hola");
        %>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            if(!comunas.isEmpty()){
                 for (Comuna xx: comunas) {
                %>
                <p><%=xx.getNombreComuna() %></p>
        <%
            }
            }

        %>
        
           
        
    </body>
</html>
