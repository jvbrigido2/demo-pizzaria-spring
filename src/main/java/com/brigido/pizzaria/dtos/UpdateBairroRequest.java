package com.brigido.pizzaria.dtos;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.With;

import java.util.Optional;

@With
public record UpdateBairroRequest(

        @Size(min = 3 , max = 100, message = "O nome tem que possuir entre 5 a 100 caracteres")
        String name,
        @Positive(message = "A taxa deve ser um valor positivo")
        Double tax

) { }
