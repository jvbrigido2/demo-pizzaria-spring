package com.brigido.pizzaria.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BairroDto(String id,
                        @NotBlank(message = "O nome do bairro não pode ser vazio")
                        String name,
                        @NotNull(message = "A taxa não pode ser nula")
                        @Positive(message = "A taxa deve ser um valor positivo")
                        double tax) {
}
