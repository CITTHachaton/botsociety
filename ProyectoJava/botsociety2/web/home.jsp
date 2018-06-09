<%-- 
    Document   : home
    Created on : 09-jun-2018, 4:16:24
    Author     : benja
--%>

<%@page import="dao.ComunaDAO"%>
<%@page import="dao.OfertaLaboralDAO"%>
<%@page import="modelo.OfertaLaboral"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="FrWork/Interno/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="FrWork/Interno/bootstrap/css/home.css" rel="stylesheet">
    <%
        ArrayList<OfertaLaboral> ofertas  = new ArrayList<OfertaLaboral>();
        
        ofertas = (new OfertaLaboralDAO()).Listar();
    
    %>
  </head>

  <body class="bg-light">

    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
      <a class="navbar-brand mr-auto mr-lg-0" href="#">Feria Laboral</a>
      <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Inicio <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#mapa">Mapa</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#Crono">Cronograma</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#Empresas">Empresas</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Configuración</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="#">Generar QR</a>
              <a class="dropdown-item" href="#">Ver Oferta</a>
            </div>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">buscar</button>
        </form>
      </div>
    </nav>

    <div class="nav-scroller bg-white box-shadow">
      <nav class="nav nav-underline">
        <a class="nav-link active" href="#">Ofertas Disponibles</a>
        <a class="nav-link" href="#">
          Ofertas para tu perfil
          <span class="badge badge-pill bg-light align-text-bottom">10</span>
        </a>
        <a class="nav-link" href="#">
          Has Postulado a
          <span class="badge badge-pill bg-light align-text-bottom">5</span>
        </a>
      </nav>
    </div>

    <main role="main" class="container">
      <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-primary rounded box-shadow">
        <div class="lh-100">
          <h6 class="mb-0 text-white lh-100">Feria Laboral</h6>
          <small>2018</small>
        </div>
      </div>

      <div class="my-3 p-3 bg-white rounded box-shadow">
        <h6 class="border-bottom border-gray pb-2 mb-0">Nuevas ofertas</h6>
        <%for (OfertaLaboral xx: ofertas) { %>
                
        <div class="media text-muted pt-3">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
          <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
              <strong class="d-block text-gray-dark">@<%=xx.getNombreOferta()%></strong>
            <%=xx.getGlosa()%>
          </p>
          <p><strong><%=(new ComunaDAO()).Leer(xx.getIdComuna()).getNombreComuna()%></strong></p>
          <button class="btn bg-danger">ver</button>
        </div>
        
        <%    }
        %>
        
        
        <small class="d-block text-right mt-3">
          <a href="#">Actualizar</a>
        </small>
      </div>
<div class="container">
    <div class="row" id="Crono">
        <img src="FrWork/programa.jpg" alt="Smiley face" height="auto" width="100%">
    </div>
</div>
      <div class="my-3 p-3 bg-white rounded box-shadow">
        <h6 class="border-bottom border-gray pb-2 mb-0">Suggestions</h6>
        <div class="media text-muted pt-3">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <strong class="text-gray-dark">Full Name</strong>
              <a href="#">Follow</a>
            </div>
            <span class="d-block">@username</span>
          </div>
        </div>
        <div class="media text-muted pt-3">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <strong class="text-gray-dark">Full Name</strong>
              <a href="#">Follow</a>
            </div>
            <span class="d-block">@username</span>
          </div>
        </div>
        <div class="media text-muted pt-3">
          <img data-src="holder.js/32x32?theme=thumb&bg=007bff&fg=007bff&size=1" alt="" class="mr-2 rounded">
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <strong class="text-gray-dark">Full Name</strong>
              <a href="#">Follow</a>
            </div>
            <span class="d-block">@username</span>
          </div>
        </div>
        <small class="d-block text-right mt-3">
          <a href="#">All suggestions</a>
        </small>
      </div>
    </main>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
   
    <script src="FrWork/Interno/bootstrap/js/bootstrap.js"></script>
    
    <script src="FrWork/Interno/bootstrap/js/pooper.js"></script>
    
    <script src="FrWork/Interno/bootstrap/js/holde.js"></script>
    <script>$(function () {
            'use strict'
          
            $('[data-toggle="offcanvas"]').on('click', function () {
              $('.offcanvas-collapse').toggleClass('open')
            })
          })</script>
  </body>
</html>
