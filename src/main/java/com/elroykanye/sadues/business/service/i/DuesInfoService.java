package com.elroykanye.sadues.business.service.i;

import com.elroykanye.sadues.api.dto.DuesInfoDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.data.entity.relation.DuesInfo;

import java.util.List;

public interface DuesInfoService {
    SaResponse create(DuesInfoDto dto);


    DuesInfo getEntity(DuesInfoDto.DuesInfoKeyDto keyDto);


    DuesInfoDto getDto(DuesInfoDto.DuesInfoKeyDto keyDto);


    List<DuesInfo> getAllEntities();


    List<DuesInfoDto> getAllDto();


    SaResponse update( DuesInfoDto dto);

    void delete(DuesInfoDto.DuesInfoKeyDto keyDto);
}
