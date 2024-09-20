package com.brigido.pizzaria.services;

import com.brigido.pizzaria.dtos.BairroCreateDto;
import com.brigido.pizzaria.dtos.BairroDto;
import com.brigido.pizzaria.mappers.BairroMapper;
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

    public List<BairroDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public void create(BairroCreateDto request) {
        verifyIfNameAlreadyExists(request.name(), null);
        repository.save(mapper.toEntity(request));
    }

    private void verifyIfNameAlreadyExists(final String name, final String id){
        repository.findByName(name)
                .filter(user -> !user.getId().equals(id))
                .ifPresent(user ->{
                    throw new DataIntegrityViolationException("Name [" + name + "] já existe");
                });

    }
}
