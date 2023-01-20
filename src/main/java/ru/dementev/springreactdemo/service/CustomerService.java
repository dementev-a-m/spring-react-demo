package ru.dementev.springreactdemo.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.dementev.springreactdemo.domain.Customer;


public interface CustomerService {
    Mono<Customer> getCustomerById(Long id);

    Flux<Customer> getCustomerList();

    Mono<Customer> upsertCustomer(Customer customer);

    Mono<Void> deleteCustomerById(Long id);


}
