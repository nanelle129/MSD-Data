package com.msd.repository;

import org.springframework.data.repository.CrudRepository;
import com.msd.domain.Events;

public interface EventRepository extends CrudRepository<Events, Long>{
	
}
