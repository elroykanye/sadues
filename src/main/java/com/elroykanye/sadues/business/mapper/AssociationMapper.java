package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.api.dto.AssociationDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssociationMapper {
    @Mapping(source = "universityId", target = "university.id")
    Association associationDtoToAssociation(AssociationDto associationDto);

    @Mapping(source = "university.id", target = "universityId")
    AssociationDto associationToAssociationDto(Association association);

    @Mapping(source = "universityId", target = "university.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Association updateAssociationFromAssociationDto(AssociationDto associationDto, @MappingTarget Association association);
}
