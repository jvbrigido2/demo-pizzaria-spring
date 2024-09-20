package com.brigido.pizzaria.controllers;

import com.brigido.pizzaria.dtos.BairroResponse;
import com.brigido.pizzaria.dtos.CreateBairroRequest;
import com.brigido.pizzaria.dtos.UpdateBairroRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/bairros")
public interface BairroController {

    @GetMapping
    public ResponseEntity<List<BairroResponse>> findALl();

    @PostMapping
    public ResponseEntity<Void> createBairro(@Valid @RequestBody final CreateBairroRequest request);

    @GetMapping("/bairro")
    public ResponseEntity<BairroResponse> getBairroByName(@RequestParam final String name);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBairroById(@PathVariable(name = "id") final String id);

    @PutMapping("/{id}")
    public ResponseEntity<BairroResponse> updateBairro(
            @PathVariable(name="id") final String id,
            @Valid @RequestBody final UpdateBairroRequest request
    );
}
