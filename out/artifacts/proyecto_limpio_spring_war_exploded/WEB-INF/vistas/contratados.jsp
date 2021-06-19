<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .bg {
            background-puntaje: url("/images/barats.jpg");
            background-position: center center;
        }
    </style>
    <title>Contratados</title>
</head>
<body>
<div class = "container">

    <div id="loginbox" style="margin:auto;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <h1 class="fw-bold text-center py-5">Servicios contratados</h1>
        <hr class="colorgraph">
        <br>
        <a href="/proyecto_limpio_spring_war_exploded/posts">
            <button class="btn btn-primary mb-2" Type="Submit">Volver a Posts</button></a>
        <br>

        <c:if test="${not empty contratados}">
            <ul>
                <c:forEach var="contratado" items="${contratados}">
                    <br>
                    <form:label path="nombre" class="form-label"> Nombre </form:label>
                    <h4  readonly class="form-control-plaintext text-left">${contratado.nombre}</h4>
                    <form:label path="especialidad" class="form-label"> Especialidad </form:label>
                    <h4>${contratado.especialidad}</h4>
                    <form:label path="matricula" class="form-label"> Matrícula </form:label>
                    <h4 readonly class="form-control-plaintext">${contratado.matricula}</h4>
                    <form:label path="fecha" class="form-label"> Fecha de publicación </form:label>
                    <h4>${contratado.fecha}</h4>
                    <form:label path="descripcion" class="form-label">Descripción del servicio </form:label>
                    <h4>${contratado.descripcion}</h4>
                    <br>
                    <form action="/proyecto_limpio_spring_war_exploded/puntuar" method="GET"  style="padding:3em; margin-top:2em;">
                        <input type="hidden" value="${contratado.matricula}" name="matricula"/>
                        <input type="hidden" value="${contratado.especialidad}" name="especialidad"/>
                        <input type="number" min="1" max="5" name="puntaje"/>
                        <button class="btn btn-lg btn-primary btn-block" Type="Submit">Enviar</button>
                    </form>
                    <br>
                    <a href="/proyecto_limpio_spring_war_exploded/contratados/${contratado.id}">
                        <button class="btn btn-primary mb-2" Type="Submit">Ver Detalle</button></a>
                    <a href="/proyecto_limpio_spring_war_exploded/cancelacion/${contratado.id}">
                        <button class="btn btn-primary mb-2" Type="Submit">Cancelar servicio</button></a>
                    <br>

                </c:forEach>
            </ul>

        </c:if>



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
