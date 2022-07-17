package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.ExecutiveDto;
import com.elroykanye.sadues.data.entity.Executive;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExecutiveMapper {
    @Mapping(source = "associationId", target = "association.id")
    Executive executiveDtoToExecutive(ExecutiveDto executiveDto);

    @Mapping(source = "association.id", target = "associationId")
    ExecutiveDto executiveToExecutiveDto(Executive executive);

    @Mapping(source = "associationId", target = "association.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Executive updateExecutiveFromExecutiveDto(ExecutiveDto executiveDto, @MappingTarget Executive executive);
}
