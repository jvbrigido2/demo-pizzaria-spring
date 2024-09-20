package com.brigido.pizzaria.mappers;

import com.brigido.pizzaria.dtos.BairroResponse;
import com.brigido.pizzaria.dtos.CreateBairroRequest;
import com.brigido.pizzaria.dtos.UpdateBairroRequest;
import com.brigido.pizzaria.models.Bairro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface BairroMapper {

    @Mapping(target = "id", ignore = true)
    Bairro toEntity(CreateBairroRequest createBairroRequest);

    BairroResponse toDto(Bairro bairro);

    @Mapping(target = "id", ignore = true)
    Bairro update(UpdateBairroRequest request, @MappingTarget Bairro entity);
}
