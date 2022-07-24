package com.elroykanye.sadues.business.service.i

import com.elroykanye.sadues.api.dto.UserDto
import com.elroykanye.sadues.api.dto.response.SaResponse
import com.elroykanye.sadues.data.entity.User

interface UserService {
    fun create(userDto: UserDto): SaResponse

    fun getEntity(id: Long): User

    fun getDto(id: Long): UserDto

    fun getAllEntities(): List<User>

    fun getAllDto(): List<UserDto>

    fun update(userDto: UserDto): SaResponse

    fun delete(id: Long)
}
