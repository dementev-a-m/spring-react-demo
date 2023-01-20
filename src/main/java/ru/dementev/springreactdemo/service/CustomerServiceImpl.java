package ru.dementev.springreactdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.dementev.springreactdemo.domain.Customer;
import ru.dementev.springreactdemo.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Mono<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Flux<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> upsertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public Mono<Void> deleteCustomerById(Long id) {
        return customerRepository.deleteById(id);
    }
}
