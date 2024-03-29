package ir.mostafa.semnani.springsecuritymodule.security.controller;

import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AuthenticationRequest;
import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AuthenticationResponse;
import ir.mostafa.semnani.springsecuritymodule.security.model.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
