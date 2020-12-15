const express = require('express'); /* guardamos las funcionalidades que tenemos de Express en esta constante express */
const app = express(); /** guardamos el objeto express en la constante app */
const cors = (require('cors'));

// Configuraciones
app.set('port', 3000); /** guardamos el puerto 3000 en app.set() */

app.use(cors());

// Middlewares
app.use(express.json()); /** este metodo convierte el json recibido y lo interpreta a traves de express*/

//Routes
app.use(require('./routes/cursos')); /** define la ruta de cursos*/

app.use(require('./routes/usuario_alumnos')); 
app.use(require('./routes/datos_alumnos'));
app.use(require('./routes/cursos_alumnos'));
app.use(require('./routes/mostrar_reinscripcion'));
app.use(require('./routes/pago_reinscripcion'));
app.use(require('./routes/fechas_mensualidad'));
app.use(require('./routes/mostrar_mensualidad'));
app.use(require('./routes/pago_mensualidad'));
app.use(require('./routes/detalle_cursos_alumnos'));
app.use(require('./routes/notas_curso'));

//Inciar Servidor
app.listen(app.get('port'), () =>{ /** inicializamos el servidor y llamamos al puerto a traves de app.get() */
    console.log('Server on port', app.get('port'));
});