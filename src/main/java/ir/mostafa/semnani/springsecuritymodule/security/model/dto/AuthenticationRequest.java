package ir.mostafa.semnani.springsecuritymodule.security.model.dto;

import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
        @NotNull
        String username,
        @NotNull
        String password
) {
}
