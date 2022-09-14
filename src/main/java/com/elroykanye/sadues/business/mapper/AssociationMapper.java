package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.AssociationDto;
import com.elroykanye.sadues.data.entity.Association;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssociationMapper {
    @Mapping(source = "universityId", target = "university.id")
    @Mapping(source = "headAssociationId", target = "headAssociation.id")
    @Mapping(source = "creatorId", target = "creator.id")
    Association associationDtoToAssociation(AssociationDto associationDto);

    @InheritInverseConfiguration(name = "associationDtoToAssociation")
    AssociationDto associationToAssociationDto(Association association);

    @InheritConfiguration(name = "associationDtoToAssociation")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Association updateAssociationFromAssociationDto(AssociationDto associationDto, @MappingTarget Association association);
}
