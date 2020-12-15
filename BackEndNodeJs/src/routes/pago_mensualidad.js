const express = require('express');
const router = express.Router();

const mysqlConnection = require('../database');

router.post('/rest/pagoMensualidad/:cod_men/:cod_alu', (req, res) => {
    const {cod_men, cod_alu} = req.params;
    mysqlConnection.query('call sp_pagoMensualidad(?,?);', [cod_men, cod_alu], (err, rows, fields) => {
        if(!err){ 
            res.json('Pago de Mensualidad Realizado Exitosamente.');
        }else{
            console.log(err);
        }
    });
});

module.exports = router;