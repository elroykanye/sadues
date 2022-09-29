package com.elroykanye.sadues.business.service.i;

import com.elroykanye.sadues.api.dto.UniversityDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.data.entity.University;

import java.util.List;

public interface UniversityService {
    SaResponse create( UniversityDto dto);
    University getEntity(long id);
    UniversityDto getDto(long id);
    List<University> getAllEntities();
    List<UniversityDto> getAllDto();
    SaResponse update( UniversityDto dto);
    void delete(long id);
}
