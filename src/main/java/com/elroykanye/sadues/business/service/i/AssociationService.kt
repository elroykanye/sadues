package com.elroykanye.sadues.business.service.i

import com.elroykanye.sadues.api.dto.AssociationDto
import com.elroykanye.sadues.api.dto.response.SaResponse
import com.elroykanye.sadues.data.entity.Association

interface AssociationService {
    fun create(associationDto: AssociationDto): SaResponse

    fun getEntity(id: Long): Association

    fun getDto(id: Long): AssociationDto

    fun getAllEntities(): List<Association>

    fun getAllDto(): List<AssociationDto>

    fun update(associationDto: AssociationDto): SaResponse

    fun delete(id: Long)
}
