package com.brigido.pizzaria.repositories;

import com.brigido.pizzaria.models.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
    Optional<Bairro> findByName(String name);
}
