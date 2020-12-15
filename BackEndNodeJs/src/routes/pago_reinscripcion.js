const express = require('express');
const router = express.Router();

const mysqlConnection = require('../database');

router.post('/rest/pagoReinscripcion/:cod', (req, res) => {
    const {cod} = req.params;
    mysqlConnection.query('call sp_pagoReinscripcion(?)', [cod], (err, rows, fields) => {
        if(!err){ 
            res.json('Pago de Reinscripcion Realizado Exitosamente.');
        }else{
            console.log(err);
        }
    });
});

module.exports = router;