package com.elroykanye.sadues.business.service.i

import com.elroykanye.sadues.api.dto.UniversityDto
import com.elroykanye.sadues.api.dto.response.SaResponse
import com.elroykanye.sadues.data.entity.University

interface UniversityService {
    fun create(universityDto: UniversityDto): SaResponse

    fun getEntity(id: Long): University

    fun getDto(id: Long): UniversityDto

    fun getAllEntities(): List<University>

    fun getAllDto(): List<UniversityDto>

    fun update(universityDto: UniversityDto): SaResponse

    fun delete(id: Long)
}
