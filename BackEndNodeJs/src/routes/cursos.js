const express = require('express'); /** estamos llamando el modulo express */
const router = express.Router(); /**  utilizamos este metodo de express que nos permitira tener diferntes rutas en el servidor*/

const mysqlConnection = require('../database'); /** llamamos al modulo de conexion ubicado en ../database */

router.get('/rest/cursos', (req, res) => { /** definimos la ruta */
    mysqlConnection.query('SELECT * FROM tbl_curso', (err, rows, fields) => { /** establecemos un query para hacer una consulta */
        if(!err){ /** si no hay error retornara las columnas o filas */
            res.json(rows);
        }else{ /** si hay error, lo mostrara en la consola */
            console.log(err);
        }
    });
});

router.get('/rest/cursos/:id', (req, res) => { /** creamos la ruta para buscar curso a traves del id */
    const {id} = req.params; /** almacenamos el id recibido en req.parms */
    mysqlConnection.query('SELECT * FROM tbl_curso WHERE id_curso = ?', [id], (err, rows, fields) => { /** establecemos el query y utilizamos la constante [id] para hacer la busqueda */
        if(!err){ 
            res.json(rows);
        }else{
            console.log(err);
        }
    });
});

router.put('/rest/cursos/:id', (req, res) => {
    const {curso} = req.body;
    const {id} = req.params;
    const query = `
    UPDATE tbl_curso SET curso = ? WHERE id_curso = ?
    `;
    mysqlConnection.query(query, [curso, id], (err, rows, fields) => {
        if(!err){ 
            res.json({Status: 'Curso Actualizado'});
        }else{
            console.log(err);
        }
    });
});

router.post('/rest/cursos', (req, res) => {
    const {curso} = req.body; /** Para hacer un POST necesitamos que el parametro sea de tipo req.body */
    const query = `
    INSERT INTO tbl_curso(curso) VALUES(?)
    `;
    mysqlConnection.query(query, [curso], (err, rows, fields) => {
        if(!err){ 
            res.json({Status: 'Curso Guardado'});
        }else{
            console.log(err);
        }
    });
});


router.delete('/rest/cursos/:id', (req, res) => { 
    const {id} = req.params;
    mysqlConnection.query('DELETE FROM tbl_curso WHERE id_curso = ?', [id], (err, rows, fields) => { 
        if(!err){ 
            res.json({Status: 'Curso Eliminado'});
        }else{
            console.log(err);
        }
    });
});

router.get('/rest/cursos/:id/:curso', (req, res) => { 
    const {id, curso} = req.params;
    mysqlConnection.query('SELECT * FROM tbl_curso WHERE id_curso = ? AND curso = ?', [id, curso], (err, rows, fields) => {
        if(!err){ 
            res.json(rows);
        }else{
            console.log(err);
        }
    });
});

module.exports = router; /** exportamos la constante router */