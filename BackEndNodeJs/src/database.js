const mysql = require('mysql'); /** utilizar modulo mysql y lo guardamos en la constante mysql */

const mysqlConnection = mysql.createConnection({ /** creamos la cadena de conexion y lo almacenamos en la constante mysqlConnection*/
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'db_colegio_2'
});

mysqlConnection.connect(function (err){ /** conectamos la base de datos */
    if(err){ /** si sucede un error, lo mostramos en consola */
        console.log(err);
        return;
    }else{ /** si no sucede ningun error que muestre el mensaje */
        console.log('La Base de Datos esta Conectada');
    }
})

module.exports = mysqlConnection; /** exportamos el modulo para poder utilizarlo despues */
