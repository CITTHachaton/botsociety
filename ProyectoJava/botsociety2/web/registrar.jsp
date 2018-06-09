<%-- 
    Document   : registro
    Created on : 09-jun-2018, 1:00:32
    Author     : benja
--%>

<%@page import="dao.NivelEstudioDAO"%>
<%@page import="modelo.NivelEstudio"%>
<%@page import="dao.GeneroDAO"%>
<%@page import="dao.SexoDAO"%>
<%@page import="modelo.Genero"%>
<%@page import="modelo.Sexo"%>
<%@page import="dao.EstadoCivilDAO"%>
<%@page import="modelo.EstadoCivil"%>
<%@page import="dao.NacionalidadDAO"%>
<%@page import="modelo.Nacionalidad"%>
<%@page import="dao.TipoDocumentoDAO"%>
<%@page import="modelo.TipoDocumento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ComunaDAO"%>
<%@page import="modelo.Comuna"%>
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

        <%
            HttpSession sesion = request.getSession(true);
            
            ArrayList<Comuna> comunas = new ArrayList<Comuna>();
            ArrayList<TipoDocumento> tiposDoc = new ArrayList<TipoDocumento>();
            ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
            ArrayList<EstadoCivil> estadosCiviles = new ArrayList<EstadoCivil>();
            ArrayList<Sexo> sexos = new ArrayList<Sexo>();
            ArrayList<Genero> generos = new ArrayList<Genero>();
            ArrayList<NivelEstudio> nivel = new ArrayList<NivelEstudio>();

            // ControlUsuario user = sesion.getAttribute("usuario") == null ? null : (ControlUsuario) sesion.getAttribute("usuario");
            String rut = "190553388";
            if (rut.length()>0) {
                
                comunas = (new ComunaDAO()).Listar();
                tiposDoc = (new TipoDocumentoDAO()).Listar();
                nacionalidades = (new NacionalidadDAO()).Listar();
                estadosCiviles = (new EstadoCivilDAO()).Listar();
                sexos = (new SexoDAO()).Listar();
                generos = (new GeneroDAO()).Listar();
                nivel = (new NivelEstudioDAO()).Listar();

            } else {
                response.sendRedirect("login.jsp");
            }
        %>
        <style>
            .container {
                max-width: 960px;
            }

            .border-top { border-top: 1px solid #e5e5e5; }
            .border-bottom { border-bottom: 1px solid #e5e5e5; }
            .border-top-gray { border-top-color: #adb5bd; }

            .box-shadow { box-shadow: 0 .25rem .75rem rgba(0, 0, 0, .05); }

            .lh-condensed { line-height: 1.25; }
        </style>
    </head>
    <body class="bg-light">
        <div class="container">
            <div class="py-5 text-center">
                <img class="d-block mx-auto mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
                <h2>Formulario Curriculum Online</h2>
                <p class="lead">Rellena el formulario con los datos correspondientes</p>
            </div>

            <div class="row">                
                <div class="col-md-12 order-md-1">
                    <h4 class="mb-3">Informacion Personal</h4>
                    <form class="needs-validation" novalidate>
                        <div class="row">                            
                            <div class="col-md-6 mb-3">
                                <label for="username">Rut: <%=rut%></label>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="Tipo">Tipo Documento</label>
                                <select name="tipoDocu" class="color-Azul color-Amarillo-text" required="">
                                    <option value="" disabled selected>Seleccione un tipo</option>                    
                                    <% for (TipoDocumento tt : tiposDoc) {
                                            if (tt.getIdTipoD() != 0) {
                                    %>
                                    <option value="<%=tt.getIdTipoD()%>" >
                                        <%= tt.getNombreTipoD()%>
                                    </option>
                                    <%      }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="firstName">Nombres</label>
                                <input type="text" class="form-control" id="firstName" placeholder="Ingrese sus nombres" name="txtNombres" required>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="lastName">Apellidos</label>
                                <input type="text" class="form-control" id="lastName" placeholder="Ingrese sus apellidos" name="txtApellidos" required>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="fecha">Fecha Nacimiento <span class="text-muted">(Optional)</span></label>
                            <input type="date" class="form-control" id="fecha" name="fechaNacimiento">
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="Comuna">Comuna</label>
                                <select name="Comuna" class="color-Azul color-Amarillo-text" required="">
                                    <option value="" disabled selected>Seleccione un Motivo</option>                    
                                    <% for (Comuna cc : comunas) {
                                            if (cc.getIdComuna() != 0) {
                                    %>
                                    <option value="<%=cc.getIdComuna()%>" >
                                        <%= cc.getNombreComuna()%>
                                    </option>
                                    <%      }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="nacionalidad">Nacionalidad</label>
                                <select name="nacionalidad" class="color-Azul color-Amarillo-text" required="">
                                    <option value="" disabled selected>Seleccione un Motivo</option>                    
                                    <% for (Nacionalidad nn : nacionalidades) {
                                            if (nn.getIdNacionalidad() != 0) {
                                    %>
                                    <option value="<%=nn.getIdNacionalidad()%>" >
                                        <%= nn.getNombreNacionalidad()%>
                                    </option>
                                    <%      }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="nacionalidad">Estado Civil</label>
                                <select name="nacionalidad" class="color-Azul color-Amarillo-text" required="">
                                    <option value="" disabled selected>Seleccione el estado Civil</option>                    
                                    <% for (EstadoCivil nn : estadosCiviles) {
                                            if (nn.getIdEstadoc() != 0) {
                                    %>
                                    <option value="<%=nn.getIdEstadoc()%>" >
                                        <%= nn.getNombreEstadoc()%>
                                    </option>
                                    <%      }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="nacionalidad">Sexo</label>
                                <select name="sexo" class="color-Azul color-Amarillo-text" required="">
                                    <option value="" disabled selected>Seleccione sexo</option>                    
                                    <% for (Sexo nn : sexos) {
                                            if (nn.getIdSexo() != 0) {
                                    %>
                                    <option value="<%=nn.getIdSexo()%>" >
                                        <%= nn.getNombreSexo()%>
                                    </option>
                                    <%      }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="nacionalidad">Genero</label>
                                <select name="genero" class="color-Azul color-Amarillo-text" required="">
                                    <option value="" disabled selected>Seleccione Genero</option>                    
                                    <% for (Genero nn : generos) {
                                            if (nn.getIdGenero() != 0) {
                                    %>
                                    <option value="<%=nn.getIdGenero()%>" >
                                        <%= nn.getNombreGenero()%>
                                    </option>
                                    <%      }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="nacionalidad">Nivel de Estudio</label>
                                <select name="nivel" class="color-Azul color-Amarillo-text" required="">
                                    <option value="" disabled selected>Seleccione Estudio</option>                    
                                    <% for (NivelEstudio nn : nivel) {
                                            if (nn.getIdNivelE() != 0) {
                                    %>
                                    <option value="<%=nn.getIdNivelE()%>" >
                                        <%= nn.getNombreNivelE()%>
                                    </option>
                                    <%      }
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="email">Correo Electronico </label>
                            <input type="email" class="form-control" id="email" name="txtCorreo" placeholder="you@example.com">

                        </div>

                        <div class="mb-3">
                            <label for="address">Direccion</label>
                            <input type="text" class="form-control" id="address" name="txtDireccion" placeholder="1234 Main St" required>

                        </div>
                        <div class="mb-3">
                            <label for="address">Profesion</label><span class="text-muted">(Optional)</span>
                            <input type="text" class="form-control" id="address" name="txtProfesion" required>

                        </div>
                        <div class="row">
                            <div class="col-mb-6 mb-3">
                                <label for="address">Telefono</label><span class="text-muted">(Optional)</span>
                                <input type="tel" class="form-control" id="address" name="txtTelefono" required>

                            </div>
                            <div class="col-mb-6 mb-3">
                                <label for="address">Celular</label><span class="text-muted">(Optional)</span>
                                <input type="tel" class="form-control" id="address" name="txtCelular"  required>

                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="address">Presentacion</label><span class="text-muted">(Optional)</span>
                            <input type="text" class="form-control" id="address" name="txtPresentacion" required>

                        </div>

                        <hr class="mb-4">
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="same-address">
                            <label class="custom-control-label" for="same-address">Shipping address is the same as my billing address</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="save-info">
                            <label class="custom-control-label" for="save-info">Save this information for next time</label>
                        </div>
                        <hr class="mb-4">

                        <hr class="mb-4">
                        <a class="btn btn-primary btn-lg btn-block" href="home.jsp" >Registrar</a>
                    </form>
                </div>
            </div>  

            <footer class="my-5 pt-5 text-muted bg-primary text-center text-small">
                <p class="mb-1">&copy; 2018 botsociety</p>
            </footer>
        </div>



        <script src="FrWork/Interno/bootstrap/js/bootstrap.min.js"></script>

    </body>
</html>
