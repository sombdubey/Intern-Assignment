const express = require('express');
const bodyParser = require('body-parser');
const app = express();

app.use(bodyParser.urlencoded({ extended: false }));

app.get('/', (req, res) => {
    res.sendFile(`${__dirname}/index.html`);
});

app.post('/submit-form', (req, res) => {
    const name = req.body.name;
    const email = req.body.email;
    console.log(`Name: ${name}, Email: ${email}`);
    res.send('Form submitted successfully!');
});

app.listen(3000, () => {
    console.log('Server listening on port 3000');
});