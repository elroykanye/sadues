package com.elroykanye.sadues.business.service.i

import com.elroykanye.sadues.api.dto.MemberDto
import com.elroykanye.sadues.api.dto.response.SaResponse
import com.elroykanye.sadues.data.entity.relation.Member

interface MemberService {
    fun create(memberDto: MemberDto): SaResponse

    fun getEntity(userId: Long, associationId: Long): Member

    fun getDto(userId: Long, associationId: Long): MemberDto

    fun getAllEntities(): List<Member>

    fun getAllDto(): List<MemberDto>

    fun update(memberDto: MemberDto): SaResponse

    fun delete(userId: Long, associationId: Long)

} 
