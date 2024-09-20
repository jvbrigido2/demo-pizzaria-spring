package com.brigido.pizzaria.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BairroCreateDto(
        @NotBlank(message = "O nome do bairro não pode ser vazio")
        @Size(min = 3 , max = 100, message = "O nome tem que possuir entre 5 a 100 caracteres")
        String name,
        @NotNull(message = "A taxa não pode ser nula")
        @Positive(message = "A taxa deve ser um valor positivo")
        double tax
) {}

