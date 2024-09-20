package com.brigido.pizzaria.dtos;

import java.io.Serial;
import java.io.Serializable;

public record BairroResponse(
        String id,
        String name,
        double tax
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
