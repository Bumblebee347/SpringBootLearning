package de.tobi.springbootlearning.repository;

import de.tobi.springbootlearning.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
