<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="main1.css">
    <title>CONSULTAR USUARIOS NEQUI</title>
    <link rel="shortcut icon" href="img/sinfondonequi.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
  <!-- HEADER -->

  <header class="nequi_inter">
    <p>CONSULTAR USUARIOS NEQUI</p>
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
          <a class="nav-link" href="usuario?vista=inicio">INICIO <span class="sr-only">(current)</span></a>
        </li>

        <li class="nav-item active">
            <a class="nav-link" href="usuario?vista=interN">ATRAS <span class="sr-only">(current)</span></a>
          </li>
        
    
        </li>
      </ul>
    </div>
  </nav>

        <table class="table">
            <thead class="">
                <tr>
                    <td>Id</td>
                    <td>Nombre</td>
                    <td>Apellido</td>
                    <td>Número</td>
                    <td>Contraseña</td>
                    <td>Acción</td>
                </tr>
            </thead>
            <tbody> 
                <c:forEach var="registro" items="${usuarios}">
                    <form action="usuarionequi" method="POST">
                        <tr>
                            <td><input type="number" name="idUsuario" value="${registro.getIdUsuario()}" hidden>${registro.getIdUsuario()}</td>
                            <td><input type="text" name="nombreUsuario" value="${registro.getNombreUSuario()}"></td>
                            <td><input type="text" name="apellidoUsuario" value="${registro.getApellidoUsuario()}"></td>
                            <td><input type="text" name="numero" value="${registro.getNumero()}"></td>
                            <td><input type="text" name="password" value="${registro.getPassword()}"></td>
                            <td>
                                <button type="submit" name="accion" value="actualizar">Actualizar</button>
                            </td>
                        </tr>
                    </form>
                </c:forEach>

            </tbody>            
        </table>

<!-- FOOTER -->

<footer class="footernequi">
    <p>Nequi. &copy; Todos Los Derechos Reservados 2023 </p>
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




