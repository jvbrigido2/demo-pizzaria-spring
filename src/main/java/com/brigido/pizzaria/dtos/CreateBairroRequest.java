package com.brigido.pizzaria.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.With;

@With
public record CreateBairroRequest(
        @Schema(description = "Bairro name" , example = "meier")
        @NotBlank()
        @Size(min = 3 , max = 100, message = "O nome tem que possuir entre 5 a 100 caracteres")
        String name,
        @Schema(description = "Tax value for delivery", example = "45")
        @NotNull(message = "A taxa não pode ser nula")
        @Positive(message = "A taxa deve ser um valor positivo")
        double tax
) {}

