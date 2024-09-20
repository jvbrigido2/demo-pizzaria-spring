package com.brigido.pizzaria.controllers.impl;

import com.brigido.pizzaria.controllers.BairroController;
import com.brigido.pizzaria.dtos.BairroCreateDto;
import com.brigido.pizzaria.dtos.BairroDto;
import com.brigido.pizzaria.services.BairroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BairroControllerImpl implements BairroController {

    private final BairroService service;

    @Override
    public List<BairroDto> findALl() {
        return service.findAll();
    }

    @Override
    public ResponseEntity<Void> createBairro(@Valid @RequestBody BairroCreateDto bairroCreateDto) {
        service.create(bairroCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

    @Override
    public ResponseEntity<BairroDto> getBairroByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteBairroById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<BairroDto> updateBairro(String id, BairroDto bairroDto) {
        return null;
    }
}
