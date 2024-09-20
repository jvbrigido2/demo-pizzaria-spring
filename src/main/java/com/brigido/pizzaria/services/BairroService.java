package com.brigido.pizzaria.services;

import com.brigido.pizzaria.dtos.BairroResponse;
import com.brigido.pizzaria.dtos.CreateBairroRequest;
import com.brigido.pizzaria.dtos.UpdateBairroRequest;
import com.brigido.pizzaria.exceptions.ResourceNotFoundException;
import com.brigido.pizzaria.mappers.BairroMapper;
import com.brigido.pizzaria.models.Bairro;
import com.brigido.pizzaria.repositories.BairroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BairroService {

    private final BairroRepository repository;

    private final BairroMapper mapper;

    public List<BairroResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public void create(CreateBairroRequest request) {
        verifyIfNameAlreadyExists(request.name(), null);
        repository.save(mapper.toEntity(request));
    }

    public BairroResponse getBairro(final String name) {
        return mapper.toDto(findByName(name));
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public BairroResponse update(final String id, final UpdateBairroRequest request){
        Bairro entity = findById(id);
        verifyIfNameAlreadyExists(request.name(), id);
        entity = entity
                .withName(request.name() != null ? request.name() : entity.getName())
                .withTax(request.tax() != null ? request.tax() : entity.getTax());

        return mapper.toDto(repository.save(entity));
    }

    private void verifyIfNameAlreadyExists(final String name, final String id){
        repository.findByName(name)
                .filter(user -> !user.getId().equals(id))
                .ifPresent(user ->{
                    throw new DataIntegrityViolationException("Bairro já existe");
                });

    }
    private Bairro findByName(final String name){
        return repository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Bairro nao encontrado"
                ));
    }
    private Bairro findById(final String id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Bairro nao encontrado"
                ));
    }
}
