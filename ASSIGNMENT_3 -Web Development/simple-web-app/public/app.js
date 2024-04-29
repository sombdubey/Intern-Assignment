const form = document.getElementById('my-form');
const output = document.getElementById('output');

form.addEventListener('submit', (e) => {
    e.preventDefault();
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    output.innerHTML = `<p>Name: ${name}</p><p>Email: ${email}</p>`;
});