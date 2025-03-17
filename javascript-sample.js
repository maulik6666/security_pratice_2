const express = require('express');
const app = express();

// Hardcoded secret (vulnerability)
const API_KEY = '12345-secret-key';

// Reflected XSS vulnerability
app.get('/search', (req, res) => {
  const query = req.query.q;
  res.send(`<h1>Search Results for: ${query}</h1>`);
});

app.listen(3000, () => {
  console.log('Server is running on port 3000');
});