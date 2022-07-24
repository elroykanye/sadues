package com.elroykanye.sadues.business.service.i

import com.elroykanye.sadues.api.dto.AcademicYearDto
import com.elroykanye.sadues.api.dto.response.SaResponse
import com.elroykanye.sadues.data.entity.AcademicYear
import org.springframework.http.ResponseEntity

interface AcademicYearService {
    fun create(academicYearDto: AcademicYearDto): SaResponse

    fun getEntity(id: Long): AcademicYear

    fun getDto(id: Long): AcademicYearDto

    fun getAllEntities(): List<AcademicYear>

    fun getAllDto(): List<AcademicYearDto>

    fun update(academicYearDto: AcademicYearDto): SaResponse 

    fun delete(id: Long)
} 
