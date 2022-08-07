package com.elroykanye.sadues.business.service.impl;

import com.elroykanye.sadues.api.dto.UserDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.mapper.UserMapper;
import com.elroykanye.sadues.business.service.i.AuthService;
import com.elroykanye.sadues.data.entity.User;
import com.elroykanye.sadues.data.enums.Role;
import com.elroykanye.sadues.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public SaResponse register(UserDto.UserRegister userRegister) {
        if (!Objects.equals(userRegister.email(), userRegister.user().email())) {
            throw new IllegalStateException("Incorrect username");
        }
        User user = userMapper.userDtoToUser(userRegister.user());
        user.setPassword(passwordEncoder.encode(userRegister.password()));
        user.setRole(Role.USER);
        user.setId(null);
        return new SaResponse(userRepository.save(user).getEmail(), "Successfully created account");
    }

    @Override
    public SaResponse login(UserDto.UserLogin userLogin, HttpSession httpSession) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userLogin.email(), userLogin.password()
        );
        authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        httpSession.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext()
        );
        return new SaResponse(userLogin.email(), httpSession.getId());
    }
}
