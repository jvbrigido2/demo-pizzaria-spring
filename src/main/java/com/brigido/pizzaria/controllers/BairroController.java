package com.brigido.pizzaria.controllers;

import com.brigido.pizzaria.dtos.BairroCreateDto;
import com.brigido.pizzaria.dtos.BairroDto;
import com.brigido.pizzaria.services.BairroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/bairros")
public interface BairroController {

    @GetMapping
    public List<BairroDto> findALl();

    @PostMapping
    public ResponseEntity<Void> createBairro(@Valid @RequestBody BairroCreateDto bairroCreateDto);

    @GetMapping("/bairro")
    public ResponseEntity<BairroDto> getBairroByName(@RequestParam String name);

    @DeleteMapping("/bairro/{id}")
    public ResponseEntity<Void> deleteBairroById(@PathVariable String id);

    @PutMapping("/bairro/{id}")
    public ResponseEntity<BairroDto> updateBairro(@PathVariable String id, @Valid @RequestBody BairroDto bairroDto);
}
