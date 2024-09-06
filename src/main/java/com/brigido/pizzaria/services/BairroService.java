package com.brigido.pizzaria.services;

import com.brigido.pizzaria.dtos.BairroCreateDto;
import com.brigido.pizzaria.dtos.BairroDto;
import com.brigido.pizzaria.mappers.BairroMapper;
import com.brigido.pizzaria.models.Bairro;
import com.brigido.pizzaria.repositories.BairroRepository;
import com.brigido.pizzaria.validators.BairroValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;
    @Autowired
    private BairroMapper bairroMapper;
    @Autowired
    private BairroValidator bairroValidator;

    public List<BairroDto> findAll(){
        return bairroRepository.findAll()
                .stream()
                .map(bairroMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public BairroDto create(BairroCreateDto bairroCreateDto){
        bairroValidator.validateUniqueName(bairroCreateDto.name());

        Bairro bairro = bairroMapper.toEntity(bairroCreateDto);
        Bairro savedBairro = bairroRepository.save(bairro);
        return bairroMapper.toDto(savedBairro);
    }
    public BairroDto getBairroByName(String name) {
        Bairro bairro = bairroValidator.validateAndReturnExistingBairro(name);
        return bairroMapper.toDto(bairro);
    }

    @Transactional
    public BairroDto updateBairro(Long id, BairroDto bairroDto) {
        Bairro bairro = bairroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bairro não encontrado"));

        bairro.setName(bairroDto.name());
        bairro.setTax(bairroDto.tax());

        Bairro updatedBairro = bairroRepository.save(bairro);
        return bairroMapper.toDto(updatedBairro);
    }

    @Transactional
    public void deleteBairroById(Long id) {
        Bairro bairro = bairroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bairro não encontrado"));
        bairroRepository.delete(bairro);
    }
}
