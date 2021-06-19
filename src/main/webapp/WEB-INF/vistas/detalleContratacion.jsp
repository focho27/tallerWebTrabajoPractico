<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 22/5/2021
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .bg {
            background-puntaje: url("/images/barats.jpg");
            background-position: center center;
        }
    </style>
    <title>Detalle contratación</title>
</head>
<body>
<div class = "container">
    <div class="row">
        <div class="col bg">

        </div>
        <div class="col">
            <div class="text-end">
                <img src="/images/barats.jpg" alt="logo"/>
            </div>
        </div>
    </div>
    <div id="loginbox" style="margin:auto;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <h1 class="fw-bold text-center py-5">¡Especialista contratado!</h1>
        <hr class="colorgraph"><br>

<br>
<p>Ya contrató a su especialista. A continuación, comuníquese para coordinar. Puede además enviar una consulta de su problema</p>
<h2>Datos de contacto:</h2>
<br>
<label >Nombre</label>
<h4 >${usuario.nombre}</h4>
<label>Codigo</label>
<h4 >${usuario.codigo}</h4>
<label>Email</label>
<h4 >${usuario.email}</h4>
<label>Dirección</label>
<h4 >${usuario.direccion}</h4>
<label>Teléfono</label>
<h4 >${usuario.telefono}</h4
<label>Enviar un mensaje al especialista</label>
<br>


    <form:form action="/proyecto_limpio_spring_war_exploded/contratar/mensaje" method="GET"  style="padding:3em; margin-top:2em;">
       <input type="hidden" value="${usuario.nombre}" name="nombre"></input>
        <textarea class="form-control"  id="mensaje" name="mensaje" rows="4" cols="50"></textarea>
        <br>
        <button class="btn btn-lg btn-primary btn-block" Type="Submit">Enviar</button>
    </form:form>
        <a href="/proyecto_limpio_spring_war_exploded/contratados">
            <button class="btn btn-primary mb-2" Type="Submit">Ver contratados</button></a>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
