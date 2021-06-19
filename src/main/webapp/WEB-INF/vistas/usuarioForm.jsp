<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        body{
            background: linear-gradient(to top right, #fc2c77 0%, #6c4079 100%);
        }
        .bg {
            background-puntaje: url("/images/barats.jpg");
            background-position: center center;
        }
    </style>
    <title>Crear Usuario</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col bg">

        </div>
        <div class="col">
            <div class="text-end">
                <img src="/images/barats.jpg" alt="logo"/>
            </div>
        </div>
    </div>
    <div id="loginbox" style="margin:auto;" class="mainbox col-md-8 col-md-offset-4 col-sm-8 col-sm-offset-2 bg-light" >
        <form:form action="crear-usuario" method="POST" modelAttribute="usuario" style="padding:3em; margin-top:2em;">
            <h1 class="fw-bold text-center py-5">Crear Usuario</h1>
            <hr class="colorgraph">
            <br>
            <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
            <form:label path="email" class="form-label"> Correo electrónico </form:label>
            <br>
            <form:input path="email" id="email" type="text" class="form-control"/>
            <br>
            <form:label path="password" class="form-label"> Contraseña </form:label>
            <br>
            <form:input path="password" type="password" id="password" class="form-control"/>
            <br>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <form:label path="nombre" for="nombre" class="form-label"> Nombre </form:label>
                    <br>
                    <form:input path="nombre" id="nombre" type="text" class="form-control"/>
                    <br>
                </div>
                <div class="form-group col-md-6">
                    <form:label path="apellido" for="apellido" class="form-label"> Apellido </form:label>
                    <br>
                    <form:input path="apellido" id="apellido" type="text" class="form-control"/>
                    <br>
                </div>
            </div>

            <form:label path="codigo" class="form-label"> Codigo Usuario </form:label>
            <br>
            <form:input path="codigo" id="codigo" type="text" class="form-control"/>
            <br>

            <form:label path="direccion" class="form-label"> Dirección </form:label>
            <br>
            <form:input path="direccion" id="direccion" type="text" class="form-control"/>
            <br>
            <form:label path="telefono" class="form-label"> Teléfono </form:label>
            <br>
            <form:input path="telefono" id="telefono" type="text" class="form-control"/>
            <br>
            <button class="btn btn-lg btn-primary btn-block" Type="Submit">Registrarme</button>
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


