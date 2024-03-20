package ir.mostafa.semnani.springsecuritymodule.security.model.dto;

public record AuthenticationRequest(String username,
                                    String password) {
}
