package ir.mostafa.semnani.springsecuritymodule.security.model.dto;

import lombok.Builder;

@Builder
public record RegisterRequest(String username,
                              String password) {
}
