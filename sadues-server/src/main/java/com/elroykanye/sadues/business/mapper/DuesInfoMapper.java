package com.elroykanye.sadues.business.mapper;

import com.elroykanye.sadues.api.dto.DuesInfoDto;
import com.elroykanye.sadues.data.entity.composite.DuesInfoKey;
import com.elroykanye.sadues.data.entity.relation.DuesInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DuesInfoMapper {
    @Mapping(target = "key", expression = "java(mapKey(duesInfoDto.key()))")
    DuesInfo duesInfoDtoToDuesInfo(DuesInfoDto duesInfoDto);

    default DuesInfoKey mapKey(DuesInfoDto.DuesInfoKeyDto keyDto) {
        return new DuesInfoKey(keyDto.academicYearId(), keyDto.associationId());
    }

    default DuesInfoDto.DuesInfoKeyDto inverseMapKey(DuesInfoKey key) {
        return new DuesInfoDto.DuesInfoKeyDto(key.getAcademicYearId(), key.getAssociationId());
    }

    @InheritInverseConfiguration(name = "duesInfoDtoToDuesInfo")
    @Mapping(target = "key", expression = "java(inverseMapKey(duesInfo.getKey()))")
    DuesInfoDto duesInfoToDuesInfoDto(DuesInfo duesInfo);

    @InheritConfiguration(name = "duesInfoDtoToDuesInfo")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DuesInfo updateDuesInfoFromDuesInfoDto(DuesInfoDto duesInfoDto, @MappingTarget DuesInfo duesInfo);
}
