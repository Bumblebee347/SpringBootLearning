//link this funktion to the button to call the GET request in the product controller
function loadData() {
    fetch('/api/products')
        .then(response => response.text())
        .then(data => {
            document.getElementById('output').innerHTML = data;
        });
}


//link this function to the button if you want the output to say hello
function sayHallo() {
    fetch('/hello')
        .then(response => response.text())
        .then(data => {
            document.getElementById('output').innerHTML = data;
        });
}

//This function is used to get a product by its ID
//If the input is empty, the output will say: "Please enter a product ID"
function getProduct() {
    const productID = document.getElementById('input').value;

    if(!productID){
        document.getElementById('output').innerHTML = "Please enter a product ID";
        return;
    }

    fetch('/api/products/' + productID)
        .then(response => response.text())
        .then(data => {
            document.getElementById('output').innerHTML = data;
        });
}