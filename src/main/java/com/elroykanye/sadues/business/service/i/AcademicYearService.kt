package com.elroykanye.sadues.business.service

import com.elroykanye.sadues.api.dto.AcademicYearDto
import com.elroykanye.sadues.api.dto.response.SaResponse
import org.springframework.http.ResponseEntity

interface AcademicYearService {
    fun create(academicYearDto: AcademicYearDto): ResponseEntity<SaResponse> {
        TODO("Not yet implemented")
    }

    fun getDto(id: Long): ResponseEntity<AcademicYearDto> {
        TODO("Not yet implemented")
    }
    
    fun getAllDto(): ResponseEntity<List<AcademicYearDto>> {
        TODO("Not yet implemented")
    }

    fun update(academicYearDto: AcademicYearDto): ResponseEntity<SaResponse> {
        TODO("Not yet implemented")
    }

    fun delete(id: Long): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }
} 
