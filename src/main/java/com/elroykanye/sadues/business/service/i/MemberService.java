package com.elroykanye.sadues.business.service.i;

import com.elroykanye.sadues.api.dto.MemberDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.data.entity.relation.Member;

import java.util.List;

public interface MemberService {
    
    SaResponse create( MemberDto dto);

    
    Member getEntity(long userId, long associationId);

    
    MemberDto getDto(long var1, long var3);

    
    List<Member> getAllEntities();

    
    List<MemberDto> getAllDto();

    
    SaResponse update( MemberDto dto);

    void delete(long userId, long associationId);
}
