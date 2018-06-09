<%-- 
    Document   : index.jsp
    Created on : 08-jun-2018, 19:35:13
    Author     : benja
--%>

<%@page import="dao.ComunaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Comuna"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <%   ArrayList<Comuna> comunas = new ArrayList<>(); 
        
             comunas = (new ComunaDAO()).Listar();
        
        %>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%for (Comuna xx: comunas) {
                %>
                <p><%=xx.getNombreComuna() %></p>
        <%
            }
        %>
        
    </body>
</html>
