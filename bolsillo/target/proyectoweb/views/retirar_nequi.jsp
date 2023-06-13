<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <link rel="shortcut icon" href="img/sinfondonequi.png">


  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <title>RETIRAR</title>
  <link rel="stylesheet" href="main1.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous"></script>
</head>



<body>
  <h1 style="text-align: center;">RETIRAR DINERO</h1>

  <header class="nequi">
    <p>NEQUI</p>
  </header>


  <!-- MENÚ -->


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
          <a class="nav-link" href="usuario?vista=inicio">INICIO <span class="sr-only">(current)</span></a>
        </li>

      

        <li class="nav-item active">
          <a class="nav-link" href="usuario?vista=interN">ATRAS <span class="sr-only">(current)</span></a>
        </li>

      </ul>
    </div>
  </nav>

  <!-- FORMULARIO -->

  <main>
    <form class="formulario" action="#" method="POST">


      <br>
      <br>
      <br>
      <br>



      <h3>Retirar</h1>

        <div>
          <input type="number" class="input" placeholder="Mínimo 5.000" name="retiro">
          <label>¿Cuanto desea retirar?</label>
        </div>


        <button class="botonnequi" type="submit" name="" value="">Retirar</button>

    </form>
  </main>

  <br>

  <!-- FOOTER   -->

  <footer class="footernequi">


    <p>Daviplata. &copy; Todos Los Derechos Reservados 2023 </p>
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

</body>

</html>