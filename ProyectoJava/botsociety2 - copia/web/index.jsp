<!DOCTYPE html>
<html lang="es">
    
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            #map {
                height: 400px;
                width: 100%;
            }
        </style>
        <meta charset="utf-8">a
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Feria Laboral </title>

        <!-- Bootstrap core CSS -->
        <link href="FrWork/Externo/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="FrWork/Externo/css/one-page-wonder.min.css" rel="stylesheet">

    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Feria Laboral </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="ingresar.jsp">Ingresar</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Registrarse</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <section>
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 order-lg-2">
                        <div class="p-5">
                            <img class="img-fluid rounded-pill" src="FrWork/Externo/img/01.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6 order-lg-1">
                        <div class="p-5">
                            <h2 class="display-4">Informacion sobre la feria...</h2>
                            <p>Encuentra todo lo que necesitas saber sobre la feria laboral como 
                                horarios,stand,invitados etc. </p>
                            <a href="#" class="btn btn-primary btn-xl rounded-circle mt-5">Ver...</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section>
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6">
                        <div class="p-5">
                            <h3>Google maps</h3>
                            <div id="map"></div>
                            <script>
                                function initMap() {
                                    var uluru = {lat: -33.4453186, lng: -70.6375783};
                                    var map = new google.maps.Map(document.getElementById('map'), {
                                        zoom: 14,
                                        center: uluru
                                    });
                                    var marker = new google.maps.Marker({
                                        position: uluru,
                                        map: map
                                    });
                                }
                            </script>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="p-5">
                            <h2 class="display-4">Anfiteatro Parque bustamante</h2>
                            <p>Direccion en donde se realizara la feria labora.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <footer class="py-5 bg-black">
            <div class="container">
                <p class="m-0 text-center text-white bg-black small">Feria de Empleabilidad Regional Website 2018</p>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="FrWork/Externo/vendor/jquery/jquery.min.js"></script>
        <script src="FrWork/Externo/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCPT3DqGjoL0elnKMsFH9de3PrAoEYAsgE&callback=initMap">
        </script>

    </body>

</html>
