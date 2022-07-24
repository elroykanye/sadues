package com.elroykanye.sadues.business.service.impl;

import com.elroykanye.sadues.api.dto.UserDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.UserService;
import com.elroykanye.sadues.data.entity.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @NotNull
    @Override
    public SaResponse create(@NotNull UserDto userDto) {
        return null;
    }

    @NotNull
    @Override
    public User getEntity(long id) {
        return null;
    }

    @NotNull
    @Override
    public UserDto getDto(long id) {
        return null;
    }

    @NotNull
    @Override
    public List<User> getAllEntities() {
        return null;
    }

    @NotNull
    @Override
    public List<UserDto> getAllDto() {
        return null;
    }

    @NotNull
    @Override
    public SaResponse update(@NotNull UserDto userDto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
