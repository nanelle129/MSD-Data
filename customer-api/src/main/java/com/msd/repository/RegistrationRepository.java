package com.msd.repository;

import org.springframework.data.repository.CrudRepository;
import com.msd.domain.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {

}
