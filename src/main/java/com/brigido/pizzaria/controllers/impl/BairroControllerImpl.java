package com.brigido.pizzaria.controllers.impl;

import com.brigido.pizzaria.controllers.BairroController;
import com.brigido.pizzaria.dtos.CreateBairroRequest;
import com.brigido.pizzaria.dtos.BairroResponse;
import com.brigido.pizzaria.dtos.UpdateBairroRequest;
import com.brigido.pizzaria.services.BairroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BairroControllerImpl implements BairroController {

    private final BairroService service;

    @Override
    public ResponseEntity<List<BairroResponse>> findALl() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<Void> createBairro(final CreateBairroRequest request) {
        service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

    @Override
    public ResponseEntity<BairroResponse> getBairroByName(final String name) {
       return ResponseEntity.ok().body(service.getBairro(name));
    }

    @Override
    public ResponseEntity<Void> deleteBairroById(final String id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

    @Override
    public ResponseEntity<BairroResponse> updateBairro(final String id, final UpdateBairroRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }
}
