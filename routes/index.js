var express = require('express');
var router = express.Router();

//compileX
var compiler = require('compilex');
var option = {stats: true};
compiler.init(option);

/* GET home page. */
router.get('/', function (req, res, next) {
    res.sendfile('index.html');
});

router.post('/compilecode', function (req, res) {
    var code = req.body.code;

    var envData = {OS: "windows"};
    console.log(code);
    compiler.compileJava(envData, code, function (data) {
        console.log(data);
        res.render('index', data);
    });
});

module.exports = router;
