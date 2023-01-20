package ru.dementev.springreactdemo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.dementev.springreactdemo.domain.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

}
