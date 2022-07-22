package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.UniversityDto;
import com.elroykanye.sadues.data.entity.University;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UniversityMapper {
    University universityDtoToUniversity(UniversityDto universityDto);

    UniversityDto universityToUniversityDto(University university);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    University updateUniversityFromUniversityDto(UniversityDto universityDto, @MappingTarget University university);
}
