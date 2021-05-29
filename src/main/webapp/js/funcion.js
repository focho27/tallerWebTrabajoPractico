function mostrarPassword() {
    var cambio1 = document.getElementById("txtPassword1");
    var cambio2 = document.getElementById("txtPassword2");
    var cambio3 = document.getElementById("txtPassword3");
    if (cambio1.type == "password") {
    cambio1.type = "text";
    $('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
} else {
    cambio1.type = "password";
    $('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
}
    if (cambio2.type == "password") {
    cambio2.type = "text";
    $('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
} else {
    cambio2.type = "password";
    $('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
}
    if (cambio3.type == "password") {
    cambio3.type = "text";
    $('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
} else {
    cambio3.type = "password";
    $('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
}
}
function validarEmail(elemento){

    var texto = document.getElementById(elemento.id).value;
    var regex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
    if (!regex.test(texto)) {
        document.getElementById("resultado").innerHTML = "Correo invalido";
    } else {
        document.getElementById("resultado").innerHTML = "";
    }

}