package com.elroykanye.sadues.business.service.impl;

import com.elroykanye.sadues.api.dto.UserDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.UserMapper;
import com.elroykanye.sadues.business.service.i.UserService;
import com.elroykanye.sadues.config.constants.EntityName;
import com.elroykanye.sadues.config.constants.ResponseMessage;
import com.elroykanye.sadues.data.entity.User;
import com.elroykanye.sadues.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final String ENTITY_NAME = EntityName.USER;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @NotNull
    @Override
    public SaResponse create(@NotNull UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        user = userRepository.save(user);
        return new SaResponse(user.getId(), ResponseMessage.SUCCESS.created(ENTITY_NAME));
    }

    @NotNull
    @Override
    public User getEntity(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @NotNull
    @Override
    public UserDto getDto(long id) {
        return userMapper.userToUserDto(getEntity(id));
    }

    @NotNull
    @Override
    public List<User> getAllEntities() {
        return userRepository.findAll();
    }

    @NotNull
    @Override
    public List<UserDto> getAllDto() {
        return getAllEntities().stream().map(userMapper::userToUserDto).toList();
    }

    @NotNull
    @Override
    public SaResponse update(@NotNull UserDto userDto) {
        User user = getEntity(userDto.id());
        if (user.getGender() != userDto.gender()) {
            user.setGender(userDto.gender());
        }
        if (!Objects.equals(user.getName(), userDto.name())) {
            user.setName(userDto.name());
        }
        user = userRepository.save(user);
        return new SaResponse(user.getId(), ResponseMessage.SUCCESS.updated(ENTITY_NAME));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
