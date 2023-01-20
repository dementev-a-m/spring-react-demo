package ru.dementev.springreactdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.dementev.springreactdemo.domain.Customer;
import ru.dementev.springreactdemo.service.CustomerService;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public Mono<Customer> getUser(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }


    @GetMapping()
    public Flux<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }

    @PostMapping
    public Mono<Customer> addNewCustomer(@RequestBody Customer customer) {
        return customerService.upsertCustomer(customer);
    }

    @PutMapping
    public Mono<Customer> updateCustomer(@RequestBody Customer customer) {
        return customerService.upsertCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomerById(id);
    }

}
