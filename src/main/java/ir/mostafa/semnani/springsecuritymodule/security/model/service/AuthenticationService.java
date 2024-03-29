package ir.mostafa.semnani.springsecuritymodule.security.model.service;

import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AuthenticationRequest;
import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final AppUserDetailsService userDetailsService;
    private final JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        var user = userDetailsService.loadUserByUsername(request.username());
        var token = jwtService.generateToken(user);
        log.info("user with username: {} successfully authenticated and has authorities: {}",
                user.getUsername(), user.getAuthorities());
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

}
