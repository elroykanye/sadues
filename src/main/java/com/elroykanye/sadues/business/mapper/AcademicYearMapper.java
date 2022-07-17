package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.AcademicYearDto;
import com.elroykanye.sadues.data.entity.AcademicYear;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AcademicYearMapper {
    AcademicYear academicYearDtoToAcademicYear(AcademicYearDto academicYearDto);

    AcademicYearDto academicYearToAcademicYearDto(AcademicYear academicYear);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AcademicYear updateAcademicYearFromAcademicYearDto(AcademicYearDto academicYearDto, @MappingTarget AcademicYear academicYear);
}
