package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.DuesPaymentDto;
import com.elroykanye.sadues.api.dto.MembershipDto;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.DuesPayment;
import com.elroykanye.sadues.data.entity.composite.MembershipKey;
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
    @Mapping(target = "member", ignore = true)
    DuesPayment duesPaymentDtoToDuesPayment(DuesPaymentDto duesPaymentDto);

    @Mapping(target = "memberKey", expression = "java(mapMemberKey(duesPayment.getMember().getKey()))")
    DuesPaymentDto duesPaymentToDuesPaymentDto(DuesPayment duesPayment);

    @Mapping(target = "member", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DuesPayment updateDuesPaymentFromDuesPaymentDto(DuesPaymentDto duesPaymentDto, @MappingTarget DuesPayment duesPayment);

    default Set<Long> associationsToAssociationIds(Set<Association> associations) {
        return associations.stream().map(Association::getId).collect(Collectors.toSet());
    }

    default MembershipDto.MemberKeyDto mapMemberKey(MembershipKey key) {
        return new MembershipDto.MemberKeyDto(key.getUserId(), key.getAssociationId());
    }
}
