package org.example.jwtauth.Service.Auth;

import org.example.jwtauth.DTO.LoginDTO;
import org.example.jwtauth.DTO.RegisterDTO;

public interface AuthService {

     String login(LoginDTO loginDTO);
    String signUp(RegisterDTO registerDTO);

}
