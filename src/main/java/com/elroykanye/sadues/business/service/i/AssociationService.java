package com.elroykanye.sadues.business.service.i;

import com.elroykanye.sadues.api.dto.AssociationDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.data.entity.Association;
import java.util.List;

public interface AssociationService {
    
    SaResponse create( AssociationDto dto);

    
    Association getEntity(long id);

    
    AssociationDto getDto(long id);

    
    List<Association> getAllEntities();

    
    List<AssociationDto> getAllDto();

    
    SaResponse update( AssociationDto dto);

    void delete(long id);
}
