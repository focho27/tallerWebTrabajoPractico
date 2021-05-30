<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            background-image: url("/images/barats.jpg");
            background-position: center center;
        }
        .formContent {
            -webkit-border-radius: 10px 10px 10px 10px;
            border-radius: 10px 10px 10px 10px;
            background: #fff;
            padding: 30px;
            margin-inside: 10px;
            width: 90%;
            max-width: 450px;
            position: relative;
            -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
            box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
        }
    </style>
    <title>Login</title>
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
    <div id="loginbox" style="margin:auto;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 formContent">
        <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
        <%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
        <%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
        <form:form action="validar-login" method="POST" modelAttribute="usuario">
            <h1 class="fw-bold text-center py-5">Bienvenido</h1>
            <hr class="colorgraph">
            <br>

            <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
            <div class="mb-4">
                <form:label path="email" class="form-label"> Correo electronico </form:label>
                <form:input path="email" id="email" type="email" class="form-control"/>
                <small id="emailHelp" class="form-text text-muted">No compartiremos tu correo electronico con nadie mas</small>
            </div>
            <div class="mb-4">
                <form:label path="password" class="form-label"> Contrasena </form:label>
                <form:input path="password" type="password" id="password" class="form-control"/>
            </div>
            <div class="mb-4 form-check text-center">
                <form:checkbox path="connected" value="connected" id="connected" class="form-check-label"/>
                <form:label path="connected" for="connected" class="form-check-label"> Mantenerme conectado </form:label>
            </div>
            <div class="d-grid text-center">
                <button class="btn btn-primary btn-block" Type="Submit">Iniciar sesion</button>
            </div>
        </form:form>
            <div class="my-3 text-center">
                <span>No tenes cuenta? <a href="/proyecto_limpio_spring_war_exploded/crear-usuario"> Registrarme </a></span> <br>
                <span><a href="/proyecto_limpio_spring_war_exploded/recuperar-contrasena/${usuario.matricula}"> Recuperar contrasena</a></span>
            </div>


        <%--Bloque que es visible si el elemento error no está vacío	--%>
        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
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

