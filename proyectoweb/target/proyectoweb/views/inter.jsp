<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

  <!DOCTYPE html>
  <html lang="en">

  <head>

    <link rel="shortcut icon" href="img/logo.png">

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>BOLSILLOS</title>
    <link rel="stylesheet" href="css/main1.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"></script>

  </head>

  <body>
    <h1 style="text-align: center;">BOLSILLOS </h1>


    <!-- HEADER -->

    <header class="nequi_inter">
      <p>Bienvenido</p>
    </header>


    <!-- NAVEGAVILIDAD -->

    <nav class="navbar navbar-expand-lg navbar-light bg-light p-3" id="menu">
      <a class="navbar-brand" href="#">


        <span class="text-primary fs-5 fw-bold"> MENÚ</span>

      </a>



      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

          <li class="nav-item active">
            <a class="nav-link" href="index?vista=inicio">INICIO <span class="sr-only">(current)</span></a>
          </li>

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false">
              BOLSILLO
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="bolsillo?vista=registrarBolsillo">Registrar Bolsillo</a>
              <a class="dropdown-item" href="bolsillo?vista=listar">Consultar Bolsillo</a>
              





            </div>
          </li>

        </ul>


      </div>
    </nav>


    </div>
    </div>

    </div>

    <!-- CONTENIDO -->

    <section class="seccion">

      <!-- PRIMER BLOQUE -->

      <div class="contenido1">

        <section class="contenido1_1_nequi">

          <h1>Nequi</h1>

          <img class="imagen" src="img/nequifoto.png" alt="NEQUI">

          <br>
          <br>

          <p>Nequi nació en 2016 como una propuesta construida a partir de soluciones financieras para todos los
            colombianos,
            sin distinción alguna, que les permitan conocer el sistema financiero del país, interactuar con él y usar
            sus
            servicios para
            mejorar su calidad de vida. Por eso, el neobanco defiende que su propósito es mejorar la relación de las
            personas con el
            dinero, acompañándolas en su día a día y empoderándolas para que logren todo lo que se proponen.

          </p>

          <p>

            Para Nequi es indispensable entender, por ejemplo, a los usuarios que desconfiaban de los servicios
            financieros. Asimismo, el neobanco
            estableció que la autogestión es la columna vertebral de su estrategia de servicio al usuario

          </p>


        </section>


      </div>

      <!-- SEGUNDO BLOQUE -->

      <div class="contenido2">

        <section class="contenido1_1_nequi">

          <h1>DAVIPLATA</h1>

          <p>Daviplata es una aplicación móvil de Davivienda que permite
             manejar el dinero desde el celular de forma fácil, rápida y segura. 
             Con Daviplata, puedes pasar plata de celular a celular desde cualquier lugar
              en Colombia, recibir giros nacionales e internacionales, 
            hacer el pago de servicios públicos o privados con tan solo
             tomarle una foto al código de barras de la factura

          </p>

          <p>

            manejar de forma fácil y gratis la plata desde su celular
             sin necesidad de tener una cuenta bancaria o tarjeta débito.

          </p>
          
          <img class="imagen2_nequi" src="img/daviplata.png" alt="DAVIPLATA">
        </section>
      </div>




    </section>


    <!-- FOOTER   -->

    <footer class="footernequi2">


      <p>Bolsillos. &copy; Todos Los Derechos Reservados 2023 </p>
      <div id="iconos">
        <a href="#"><i class="bi bi-facebook"></i></a>
        <a href="#"><i class="bi bi-github"></i></a>
      </div>
    </footer>



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
      integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
      crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
      crossorigin="anonymous"></script>



  </body>

  </html>