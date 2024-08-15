package org.example.jwtauth.Controller;

import org.example.jwtauth.DTO.JWTAuthResponse;
import org.example.jwtauth.DTO.LoginDTO;
import org.example.jwtauth.DTO.RegisterDTO;
import org.example.jwtauth.Service.Auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity Login(@RequestBody LoginDTO loginDTO)
    {
        String token = authService.login(loginDTO);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccesstoken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity signUp(@RequestBody RegisterDTO registerDTO)
    {
        String result = authService.signUp(registerDTO);
        return ResponseEntity.ok(result);
    }

}
