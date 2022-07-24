package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.MemberDto;
import com.elroykanye.sadues.data.entity.Association;
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
    @Mapping(source = "academicYearId", target = "academicYear.id")
    Member memberDtoToMember(MemberDto memberDto);

    @Mapping(source = "academicYear.id", target = "academicYearId")
    MemberDto memberToMemberDto(Member member);

    @Mapping(source = "academicYearId", target = "academicYear.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Member updateMemberFromMemberDto(MemberDto memberDto, @MappingTarget Member member);

    default Set<Long> associationsToAssociationIds(Set<Association> associations) {
        return associations.stream().map(Association::getId).collect(Collectors.toSet());
    }
}
