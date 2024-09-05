package com.brigido.pizzaria.validators;

import com.brigido.pizzaria.exceptions.BairroAlreadyExistsException;
import com.brigido.pizzaria.exceptions.BairroNotFoundException;
import com.brigido.pizzaria.models.Bairro;
import com.brigido.pizzaria.repositories.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BairroValidator {

    @Autowired
    private BairroRepository bairroRepository;

    public void validateUniqueName(String name) {
        bairroRepository.findByName(name).ifPresent(bairro -> {
            throw new BairroAlreadyExistsException("Bairro com o nome '" + name + "' já existe.");
        });
    }
    public Bairro validateAndReturnExistingBairro(String name) {
        return bairroRepository.findByName(name)
                .orElseThrow(() -> new BairroNotFoundException("Bairro com o nome '" + name + "' não foi encontrado."));
    }
}
