package de.tobi.springbootlearning.Controller;


import de.tobi.springbootlearning.entity.Customer;
import de.tobi.springbootlearning.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
