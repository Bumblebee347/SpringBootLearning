function loadData() {
    fetch('/api/products')
        .then(response => response.text())
        .then(data => {
            document.getElementById('output').innerHTML = data;
        });
}

function sayHallo() {
    fetch('/hello')
        .then(response => response.text())
        .then(data => {
            document.getElementById('output').innerHTML = data;
        });
}
