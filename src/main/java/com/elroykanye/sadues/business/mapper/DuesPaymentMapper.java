package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.DuesPaymentDto;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.DuesPayment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DuesPaymentMapper {
    @Mapping(source = "memberKey", target = "key")
    DuesPayment duesPaymentDtoToDuesPayment(DuesPaymentDto duesPaymentDto);

    @Mapping(source = "key", target = "memberKey")
    DuesPaymentDto duesPaymentToDuesPaymentDto(DuesPayment duesPayment);

    @Mapping(source = "memberKey", target = "key")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DuesPayment updateDuesPaymentFromDuesPaymentDto(DuesPaymentDto duesPaymentDto, @MappingTarget DuesPayment duesPayment);

    default Set<Long> associationsToAssociationIds(Set<Association> associations) {
        return associations.stream().map(Association::getId).collect(Collectors.toSet());
    }
}
