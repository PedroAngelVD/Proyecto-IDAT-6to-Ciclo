if(localStorage.getItem('usuario')==null){
    console.log('Inicie Sesion..')
}else 
    {

function confirmarCierre() {
    //le doy un tiempo a la funcion cerrar sesion para que el usuario tenga un tiempo para confirmar, sino lo hizo en el tiempo se cerrara la sesion automaticamente
    var cerrar = setTimeout(cerrarSesion,5000);//5 segs de prueba
    alertify.confirm(
        'Cierre de Sesión',
        'Su Sesión Expirara, presione OK para prolongar la Sesión 10 segundos', 
        function(){
            //si presiona OK
            clearTimeout(cerrar); //elimino el tiempo a la funcion cerrarSesion
            clearTimeout(temp); //elimino el tiempo a la funcion confirmarCierre
            temp = setTimeout(confirmarCierre, 20000); //y aca le doy un nuevo tiempo a la funcion confirmarCierre (5 segs)
            alertify.success('Su sesión ha sido prolongada 10 segundos');
        },
        function(){
            cerrarSesion(); //si presiono Cancel, pues ejecuta la funcion cerrarSesion y posteriormente la cierra.
        }
    );
}

function cerrarSesion() {
    //window.location = "/logout";
    alertify.error('CERRANDO SESIÓN ...'); //coloco una notificacion para observar el momento en el q se ejecuta
    //NOTA: esto no va solo es de demostracion
    localStorage.removeItem('usuario');
    location.href='/';//Redirige a login.html una vez activada la function cerrarSesion.
}

// se llamará a la función que confirmar Cierre después de 10 segundos
var temp = setTimeout(confirmarCierre, 20000);

// hacemos que al pulsar en los botones de Alertify no se propaguen los eventos
$("body").on("click", ".ajs-button", function(e) {
  e.stopPropagation();
});

// cuando se detecte actividad en cualquier parte de la app
$( document ).on('click keyup keypress keydown blur change', function(e) {
    // borrar el temporizador de la funcion confirmarCierre
    clearTimeout(temp);
    // y volver a iniciarlo con 10segs
    temp = setTimeout(confirmarCierre,20000);
    console.log('actividad detectada');
});

}