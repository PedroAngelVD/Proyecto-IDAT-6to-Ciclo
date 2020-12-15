const express = require('express');
const router = express.Router();

const mysqlConnection = require('../database');

router.get('/rest/usuario', (req, res) => {
    mysqlConnection.query('SELECT * FROM tbl_usuario_alumno', (err, rows, fields) => {
        if(!err){
            res.json(rows);
        }else{
            console.log(err);
        }
    });
});

module.exports = router;