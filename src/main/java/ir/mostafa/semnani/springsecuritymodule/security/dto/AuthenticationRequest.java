package ir.mostafa.semnani.springsecuritymodule.security.dto;

import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
        @NotNull
        String username,
        @NotNull
        String password
) {
}
