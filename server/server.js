const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');
const http = require('http');


const app = express();

// API file for interacting with MongoDB
const api = require('./api/api');

// Parsers
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false}));

// API location
app.use('/api', api);

app.listen(3000,function(){
    console.log("listen to port 3000");
});