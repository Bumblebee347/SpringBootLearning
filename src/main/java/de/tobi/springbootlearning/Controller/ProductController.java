package de.tobi.springbootlearning.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    //Returning a List of all products in this case just a String
    //Run Application and access http://localhost:8080/api/products to see the result
    @GetMapping
    public String getProducts() {
        return "This is a list of all products";
    }

    //GetMapping with a PathVariable to return a product with a specific ID
    //Run Application and access http://localhost:8080/api/products/1 to see the result
    @GetMapping("/{id}")
    public String getProductByID(@PathVariable int id) {
        return "This is a product with the ID " + id;
    }


    // ---- All the following methods are for creating, updating and deleting products ----
    // ---------  To access them use a REST client, or use the API-Test.http file ---------

    //PostMapping to create a new product
    @PostMapping
    public String createProduct(@RequestBody String product) {
        return "Created product " + product;
    }

    //PutMapping to update a product with a specific ID and with a new product "name"
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody String product) {
        return "Updated product " + product + " with ID " + id;
    }

    //DeleteMapping to delete a product with a specific ID
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return "Deleted product with ID " + id;
    }
}
