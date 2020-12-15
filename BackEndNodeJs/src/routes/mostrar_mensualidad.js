const express = require('express');
const router = express.Router();

const mysqlConnection = require('../database');

router.get('/rest/mostrarMensualidad/:cod_men/:cod_alu', (req, res) => { 
    const {cod_men, cod_alu} = req.params;
    mysqlConnection.query('call sp_mostrarMensualidad(?,?)', [cod_men, cod_alu], (err, rows, fields) => {
        if(!err){ 
            res.json(rows[0]);
        }else{
            console.log(err);
        }
    });
});

module.exports = router; /** exportamos la constante router */