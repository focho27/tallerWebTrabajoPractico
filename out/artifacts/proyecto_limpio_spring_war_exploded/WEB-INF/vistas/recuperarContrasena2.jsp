<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



<script src="/js/funcion.js"></script>
    <style>
        .formContent {
            -webkit-border-radius: 10px 10px 10px 10px;
            border-radius: 10px 10px 10px 10px;
            background: #fff;
            padding: 30px;
            width: 90%;
            max-width: 450px;
            position: relative;
            -webkit-box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
            box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
    <title>Reestablecer contrasena</title>
</head>

<body>
<div class="form-gap"></div>
<div class="container">
    <div class="row">
        <div class="col-md-5 col-md-offset-4">
            <div class="panel formContent">
                <div class="panel-body">
                    <div class="text-center">
                        <h3><i class="fa fa-lock fa-4x"></i></h3>
                        <h2 class="text-center"> Restablecer contraseña </h2>
                        <p>Ingresa la contraseña que recibiste en tu correo electrónico e ingresa una clave nueva
                        </p>

                        <div class="panel-body">
                            <form:form action="/proyecto_limpio_spring_war_exploded/recuperar-contrasena" class="form" method="POST" modelAttribute="usuario">

                                <div class="form-row">
                                    <div class="form-group col-md-10">
                                        <input  id="txtPassword1" type="Password" Class="form-control"
                                               placeholder="Contraseña actual"/>
                                    </div>
                                    <div class="form-group col-md-2">

                                        <button  class="btn btn-primary" type="button"
                                                 onclick="mostrarPassword()"> <span
                                                class="fa fa-eye-slash icon"></span> </button>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-10">
                                        <form:input path="password" ID="txtPassword2" type="Password" Class="form-control"
                                               placeholder="Contraseña nueva"/>
                                    </div>
                                    <div class="form-group col-md-2">

                                        <button class="btn btn-primary" type="button"
                                        onclick="mostrarPassword()"> <span
                                            class="fa fa-eye-slash icon"></span> </button>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-10">
                                        <input ID="txtPassword3" type="Password" Class="form-control"
                                               placeholder="Contraseña duplicada">
                                    </div>
                                    <div class="form-group col-md-2">

                                        <button  class="btn btn-primary" type="button"
                                                 onclick="mostrarPassword()"> <span
                                                class="fa fa-eye-slash icon"></span> </button>
                                    </div>
                                </div>
                                <br>


                                <form:input path="email" id="email" type="hidden" class="form-control"/>
                                <form:input path="nombre" id="nombre" type="hidden" class="form-control"/>
                                <form:input path="apellido" id="apellido" type="hidden" class="form-control"/>
                                <form:input path="matricula" id="matricula" type="hidden" class="form-control"/>
                                <form:input path="direccion" id="direccion" type="hidden" class="form-control"/>
                                <form:input path="telefono" id="telefono" type="hidden" class="form-control"/>


                                <div class="form-group">




                                    <button class="btn btn-lg btn-primary btn-block" Type="Submit">Aceptar</button>
                                </div>
                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous">
</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous">
</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous">
</script>
</body>

</html>
