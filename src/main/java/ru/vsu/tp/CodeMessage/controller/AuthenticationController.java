package ru.vsu.tp.CodeMessage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import ru.vsu.tp.CodeMessage.config.jwt.TokenUtil;
import ru.vsu.tp.CodeMessage.dto.UserAuthData;
import ru.vsu.tp.CodeMessage.entity.Account;
import ru.vsu.tp.CodeMessage.service.AccountsService;

@RestController
@CrossOrigin
@RequestMapping(value = "/authenticate")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenUtil tokenUtil;
    private final AccountsService accountsService;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    TokenUtil tokenUtil,
                                    AccountsService accountsService) {
        this.authenticationManager = authenticationManager;
        this.tokenUtil = tokenUtil;
        this.accountsService = accountsService;
    }

    @PostMapping
    public ResponseEntity<String> createAuthenticationToken(@RequestBody UserAuthData authenticationRequest) {
        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            Account user = accountsService.getByUsername(authenticationRequest.getUsername());
            final String token = tokenUtil.generateToken(user);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

    }

}