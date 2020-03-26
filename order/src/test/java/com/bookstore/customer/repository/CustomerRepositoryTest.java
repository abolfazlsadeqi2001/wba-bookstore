package com.bookstore.customer.repository;

import com.bookstore.customer.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    void findByEmail() {
        Optional<Customer> optionalCustomer = repository.findByEmail("john.doe@gmail.com");
        assertTrue(optionalCustomer.isPresent());
    }
}
