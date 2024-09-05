package ir.mostafa.semnani.springsecuritymodule.security.service;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AuthenticationRequest;
import ir.mostafa.semnani.springsecuritymodule.security.dto.AuthenticationResponse;
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
        var user = userDetailsService.loadUserByUsername(request.username());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        var token = jwtService.generateToken(user);
        log.info("user with username: {} successfully authenticated and has authorities: {}",
                user.getUsername(), user.getAuthorities());
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

}
