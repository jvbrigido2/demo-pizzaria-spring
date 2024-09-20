package com.brigido.pizzaria.mappers;

import com.brigido.pizzaria.dtos.BairroCreateDto;
import com.brigido.pizzaria.dtos.BairroDto;
import com.brigido.pizzaria.models.Bairro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface BairroMapper {

    @Mapping(target = "id", ignore = true)
    Bairro toEntity(BairroCreateDto bairroCreateDto);
    BairroDto toDto(Bairro bairro);
    Bairro toEntity(BairroDto bairroDto);
}
