package com.brigido.pizzaria.mappers;

import com.brigido.pizzaria.dtos.BairroDto;
import com.brigido.pizzaria.models.Bairro;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BairroMapper {
    BairroDto toDto(Bairro bairro);
    Bairro toEntity(BairroDto bairroDto);
}
