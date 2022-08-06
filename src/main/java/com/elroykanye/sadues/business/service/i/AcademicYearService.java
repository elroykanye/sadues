package com.elroykanye.sadues.business.service.i;

import com.elroykanye.sadues.api.dto.AcademicYearDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.data.entity.AcademicYear;
import java.util.List;

public interface AcademicYearService {
    
    SaResponse create( AcademicYearDto dto);
    AcademicYear getEntity(long id);
    AcademicYearDto getDto(long id);
    List<AcademicYear> getAllEntities();
    List<AcademicYearDto> getAllDto();
    SaResponse update( AcademicYearDto dto);
    void delete(long id);
}
