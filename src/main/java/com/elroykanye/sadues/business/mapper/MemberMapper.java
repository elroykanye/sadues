package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.MemberDto;
import com.elroykanye.sadues.data.entity.Association;
import com.elroykanye.sadues.data.entity.composite.MemberKey;
import com.elroykanye.sadues.data.entity.relation.Member;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MemberMapper {
    @Mapping(target = "key", expression = "java(mapKey(memberDto.key()))")
    Member memberDtoToMember(MemberDto memberDto);

    @Mapping(target = "key", expression = "java(inverseMapKey(member.getKey()))")
    MemberDto memberToMemberDto(Member member);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Member updateMemberFromMemberDto(MemberDto memberDto, @MappingTarget Member member);

    default Set<Long> associationsToAssociationIds(Set<Association> associations) {
        return associations.stream().map(Association::getId).collect(Collectors.toSet());
    }

    default MemberKey mapKey(MemberDto.MemberKeyDto keyDto) {
        return new MemberKey(keyDto.userId(), keyDto.associationId());
    }

    default MemberDto.MemberKeyDto inverseMapKey(MemberKey key) {
        return new MemberDto.MemberKeyDto(key.getUserId(), key.getAssociationId());
    }
}
