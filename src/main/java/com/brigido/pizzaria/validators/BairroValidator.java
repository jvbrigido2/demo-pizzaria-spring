package com.brigido.pizzaria.validators;

import com.brigido.pizzaria.exceptions.BairroAlreadyExistsException;
import com.brigido.pizzaria.repositories.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BairroValidator {

    @Autowired
    private BairroRepository bairroRepository;

    public void validateUniqueName(String name) {
        var existingBairro = bairroRepository.findByName(name);

        if(existingBairro != null){
            throw new BairroAlreadyExistsException("Bairro com o nome '" +
                    name + "' já existe.");
        }
    }
}
