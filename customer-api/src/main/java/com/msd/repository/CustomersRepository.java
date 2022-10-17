package com.msd.repository;

import org.springframework.data.repository.CrudRepository;
import com.msd.domain.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {


}
