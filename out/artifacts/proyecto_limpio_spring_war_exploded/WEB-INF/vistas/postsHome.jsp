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
            background-image: url("/images/barats.jpg");
            background-position: center center;
        }
    </style>
    <title>Servicios</title>
</head>
<body>
<div class = "container">
    <img src = "TW-nos /../ images/barats.jpg "/>
    <div id="loginbox" style="margin:auto;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <h1 class="fw-bold text-center py-5">Servicios publicados</h1>
        <hr class="colorgraph"><br>

        <form action="/proyecto_limpio_spring_war_exploded/create/post" method="get">
            <button class="btn btn-primary text-end" type="submit" >Postear</button>
        </form>

<c:if test="${not empty posts}">
    <div class="select">
        <form method="GET" action="/proyecto_limpio_spring_war_exploded/posts/filtro/especialidad">
        <select name="especialidad" id="filtro" onchange="this.form.submit()">
            <option value="-" name="-">-</option>
            <option value="All" name="All">All</option>
            <option value="Admin" name="Admin">Admin</option>
            <option value="User" name="User">User</option>

        </select>
        </form>
    </div>
    <ul>
        <c:forEach var="post" items="${posts}">
            <br>
            <form:label path="nombre" class="form-label"> Nombre </form:label>
            <a href="/proyecto_limpio_spring_war_exploded/usuario/${post.matricula}"><h4  readonly class="form-control-plaintext text-left">${post.nombre}</h4></a>
            <form:label path="especialidad" class="form-label"> Especialidad </form:label>
            <h4>${post.especialidad}</h4>
            <form:label path="matricula" class="form-label"> Matrícula </form:label>
            <h4 readonly class="form-control-plaintext">${post.matricula}</h4>
            <form:label path="fecha" class="form-label"> Fecha de publicación </form:label>
            <h4>${post.fecha}</h4>
            <form:label path="descripcion" class="form-label">Descripción del servicio </form:label>
            <h4>${post.descripcion}</h4>
            <img src = "TW-nos /../ images/${post.imagen} "/>
            <a href="/proyecto_limpio_spring_war_exploded/post/delete/${post.id}"> <button class="btn btn-primary mb-2" Type="Submit">Borrar</button></a>
            <a href="/proyecto_limpio_spring_war_exploded/post/${post.id}"> <button class="btn btn-primary mb-2" Type="Submit">Ver Detalle</button></a>
            <a href="/proyecto_limpio_spring_war_exploded/post/form/${post.id}"> <button class="btn btn-primary mb-2" Type="Submit">Editar</button></a>
            <a href="/proyecto_limpio_spring_war_exploded/contratar/${post.id}">
                <button class="btn btn-primary mb-2" Type="Submit">Contratar</button></a>
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
