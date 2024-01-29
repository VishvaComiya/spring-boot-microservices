package com.informatics.assignment.User.Management.controllers;

import com.informatics.assignment.User.Management.common.Constant;
import com.informatics.assignment.User.Management.dto.AuthenticationDTO;
import com.informatics.assignment.User.Management.dto.AuthenticationResponse;
import com.informatics.assignment.User.Management.dto.TokenDto;
import com.informatics.assignment.User.Management.entities.UserTokenStore;
import com.informatics.assignment.User.Management.services.UserTokenService;
import com.informatics.assignment.User.Management.services.auth.AuthService;
import com.informatics.assignment.User.Management.services.jwt.UserDetailsServiceImpl;
import com.informatics.assignment.User.Management.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.tokens.Token;

import java.io.IOException;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserTokenService tokenService;



    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationDTO authenticationDTO, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {

        Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationDTO.getUserName(),
                            authenticationDTO.getPassword()));

            final String jwt = jwtUtil.generateJwtToken(authentication);
            String storeToken = tokenService.saveToken(jwt,authenticationDTO.getUserName());

        return ResponseEntity.ok(new AuthenticationResponse(jwt,"Bearer",
                Constant.SUCCESS_RES_CODE,
                Constant.SUCCESS_RES_MSG_LOGIN));

    }



    @PostMapping("/validateToken")
    public String validateToken(@RequestBody TokenDto token){

        jwtUtil.validateJwtToken(token.getToken());

        return "Token is Valid";

    }


}

