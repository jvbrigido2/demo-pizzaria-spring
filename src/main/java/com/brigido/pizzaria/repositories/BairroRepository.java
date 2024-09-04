package com.brigido.pizzaria.repositories;

import com.brigido.pizzaria.models.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
    Bairro findByName(String name);
}
