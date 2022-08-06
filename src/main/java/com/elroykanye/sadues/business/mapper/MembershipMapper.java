package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.MembershipDto;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.composite.MembershipKey;
import com.elroykanye.sadues.data.entity.relation.Membership;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MembershipMapper {
    @Mapping(target = "key", expression = "java(mapKey(memberDto.key()))")
    Membership memberDtoToMember(MembershipDto membershipDto);

    @Mapping(target = "key", expression = "java(inverseMapKey(member.getKey()))")
    MembershipDto memberToMemberDto(Membership membership);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Membership updateMemberFromMemberDto(MembershipDto membershipDto, @MappingTarget Membership membership);

    default Set<Long> associationsToAssociationIds(Set<Association> associations) {
        return associations.stream().map(Association::getId).collect(Collectors.toSet());
    }

    default MembershipKey mapKey(MembershipDto.MemberKeyDto keyDto) {
        return new MembershipKey(keyDto.userId(), keyDto.associationId());
    }

    default MembershipDto.MemberKeyDto inverseMapKey(MembershipKey key) {
        return new MembershipDto.MemberKeyDto(key.getUserId(), key.getAssociationId());
    }
}
