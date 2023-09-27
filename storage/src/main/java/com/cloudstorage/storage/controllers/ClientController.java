package com.cloudstorage.storage.controllers;

import com.cloudstorage.storage.models.Account;
import com.cloudstorage.storage.models.Login;
import com.cloudstorage.storage.services.AuthorizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
        origins = "${origins.clients}",
        allowCredentials = "true"
)
@RequestMapping("/")
public class ClientController {

    public AuthorizationService service;

    public ClientController(AuthorizationService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<Login> login(@RequestBody Account account) {
        final Login login = service.login(account);
        return ResponseEntity.ok(login);
    }

    @PostMapping("/logout")
    public void logout(@RequestHeader("auth-token") String authToken) {
        service.logout(authToken);
    }

}
