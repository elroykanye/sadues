package com.elroykanye.sadues.business.service.impl;

import com.elroykanye.sadues.api.dto.UserDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.UserMapper;
import com.elroykanye.sadues.business.service.i.UniversityService;
import com.elroykanye.sadues.business.service.i.UserService;
import com.elroykanye.sadues.config.constants.EntityName;
import com.elroykanye.sadues.config.constants.ResponseMessage;
import com.elroykanye.sadues.data.entity.University;
import com.elroykanye.sadues.data.entity.User;
import com.elroykanye.sadues.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final String ENTITY_NAME = EntityName.USER;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UniversityService universityService;
    
    @Override
    public SaResponse create( UserDto dto) {
        User user = userMapper.userDtoToUser(dto);
        if (dto.universityId() != null) {
            University university = universityService.getEntity(dto.universityId());
            user.setUniversity(university);
        }
        user = userRepository.save(user);
        return new SaResponse(user.getId(), ResponseMessage.SUCCESS.created(ENTITY_NAME));
    }

    
    @Override
    public User getEntity(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    
    @Override
    public UserDto getDto(long id) {
        return userMapper.userToUserDto(getEntity(id));
    }

    
    @Override
    public List<User> getAllEntities() {
        return userRepository.findAll();
    }

    
    @Override
    public List<UserDto> getAllDto() {
        return getAllEntities().stream().map(userMapper::userToUserDto).toList();
    }

    
    @Override
    public SaResponse update( UserDto dto) {
        User user = getEntity(dto.id());
        if (user.getGender() != dto.gender()) {
            user.setGender(dto.gender());
        }
        if (!Objects.equals(user.getName(), dto.name())) {
            user.setName(dto.name());
        }
        user = userRepository.save(user);
        return new SaResponse(user.getId(), ResponseMessage.SUCCESS.updated(ENTITY_NAME));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User with usernme '%s' does not exist", username))
        );

        return org.springframework.security.core.userdetails.User.withUsername(user.getName())
                .password(user.getPassword()).authorities(user.getRole().name()).build();
    }
}
