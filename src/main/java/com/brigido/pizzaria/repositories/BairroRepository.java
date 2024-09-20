package com.brigido.pizzaria.repositories;

import com.brigido.pizzaria.models.Bairro;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface BairroRepository extends MongoRepository<Bairro, String> {
    Optional<Bairro> findByName(final String name);
}
