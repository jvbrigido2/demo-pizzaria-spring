package com.brigido.pizzaria.controllers;

import com.brigido.pizzaria.dtos.BairroDto;
import com.brigido.pizzaria.services.BairroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bairros")
public class BairroController {

    @Autowired
    private BairroService bairroService;

    @GetMapping
    public List<BairroDto> findALl(){
     return bairroService.findAll();
    }
    @PostMapping
    public ResponseEntity<BairroDto> createBairro(@Valid @RequestBody BairroDto bairroDto){
        BairroDto createdBairroDto = bairroService.create(bairroDto);
        return new ResponseEntity<>(createdBairroDto, HttpStatus.CREATED);
    }
    @GetMapping("/bairro")
    public ResponseEntity<BairroDto> getBairroByName(@RequestParam String name){
        BairroDto bairroDto = bairroService.getBairroByName(name);
        return ResponseEntity.ok(bairroDto);
    }
}
