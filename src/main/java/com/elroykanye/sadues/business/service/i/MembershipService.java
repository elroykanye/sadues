package com.elroykanye.sadues.business.service.i;

import com.elroykanye.sadues.api.dto.MembershipDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.data.entity.relation.Membership;

import java.util.List;

public interface MembershipService {
    
    SaResponse create( MembershipDto dto);

    
    Membership getEntity(MembershipDto.MembershipKeyDto keyDto);

    
    MembershipDto getDto(MembershipDto.MembershipKeyDto keyDto);

    
    List<Membership> getAllEntities();

    
    List<MembershipDto> getAllDto();

    
    SaResponse update( MembershipDto dto);

    void delete(MembershipDto.MembershipKeyDto keyDto);
}
