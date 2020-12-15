const express = require('express');
const router = express.Router();

const mysqlConnection = require('../database');

router.get('/rest/datosAlumno/:cod', (req, res) => {
    const {cod} = req.params;
    mysqlConnection.query('call sp_datosAlumno(?)', [cod], (err, rows, fields) => {
        if(!err){ 
            res.json(rows[0]);
        }else{
            console.log(err);
        }
    });
});

module.exports = router;