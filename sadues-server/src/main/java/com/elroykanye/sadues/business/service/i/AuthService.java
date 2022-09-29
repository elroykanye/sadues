package com.elroykanye.sadues.business.service.i;

import com.elroykanye.sadues.api.dto.UserDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;

import javax.servlet.http.HttpSession;

public interface AuthService {

    SaResponse register(UserDto.UserRegister userRegister);

    SaResponse login(UserDto.UserLogin userLogin, HttpSession httpSession);
}
