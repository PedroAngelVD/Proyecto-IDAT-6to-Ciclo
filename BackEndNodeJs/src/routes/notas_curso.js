const express = require('express');
const router = express.Router();

const mysqlConnection = require('../database');

router.get('/rest/notasCurso/:cod_alu/:cod_cur', (req, res) => { 
    const {cod_alu, cod_cur} = req.params;
    mysqlConnection.query('call sp_notasCurso(?,?);', [cod_alu, cod_cur], (err, rows, fields) => {
        if(!err){ 
            res.json(rows[0]);
        }else{
            console.log(err);
        }
    });
});

module.exports = router;