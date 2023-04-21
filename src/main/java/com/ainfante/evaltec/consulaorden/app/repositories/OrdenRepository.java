package com.ainfante.evaltec.consulaorden.app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ainfante.evaltec.consulaorden.app.models.Orden;

public interface OrdenRepository extends MongoRepository<Orden, String>{
	Page<Orden> findAll(Pageable pageable);
}
