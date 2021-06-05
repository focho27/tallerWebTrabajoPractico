<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;ISO-8859-1;charset=UTF-8" language="java" %>
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
            background-image: url("/images/logo/barats.jpg");
            background-position: center center;
        }
    </style>
    <title>Publicar Servicio</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col bg"></div>
        <div class="col">
            <div class="text-end">
                <img src="/images/barats.jpg" alt="logo"/>
            </div>
        </div>
    </div>

    <c:if test="${not empty error}">
    <h2>${error}</h2>
    </c:if>
    <div id="loginbox" style="margin:auto;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="/proyecto_limpio_spring_war_exploded/create/post" method="POST" modelAttribute="post" enctype="multipart/form-data">
            <h1 class="fw-bold text-center py-5">Publique su servicio</h1>
            <hr class="colorgraph">
            <br>
            <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
            <form:label path="nombre" class="form-label"> Nombre </form:label>
            <br>
            <form:input path="nombre" id="nombre" type="text" class="form-control"/>
            <br>
            <form:label path="especialidad" class="form-label"> Especialidad </form:label>
            <br>
            <form:input path="especialidad" type="text" id="especialidad" class="form-control"/>
            <br>
            <form:label path="matricula" class="form-label"> Matrícula </form:label>
            <br>
            <form:input path="matricula" id="matricula" type="text" class="form-control"/>
            <br>
            <form:label path="descripcion" class="form-label"> Descripción del servicio </form:label>
            <br>
            <form:textarea path="descripcion" id="descripcion" type="textarea" class="from-control"  rows="10" cols="72"/>
            <br>
            <input id="file" type="file" class="form-control" name="file" />
            <br>
            <button class="btn btn-lg btn-primary btn-block" Type="Submit">Publicar servicio</button>
            <br>
        </form:form>
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


