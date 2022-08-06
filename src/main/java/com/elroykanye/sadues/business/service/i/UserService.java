package com.elroykanye.sadues.business.service.i;

import com.elroykanye.sadues.api.dto.UserDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.data.entity.User;

import java.util.List;


public interface UserService {
    SaResponse create( UserDto dto);
    User getEntity(long id);
    UserDto getDto(long id);
    List<User> getAllEntities();
    List<UserDto> getAllDto();
    SaResponse update( UserDto dto);
    void delete(long id);
}
