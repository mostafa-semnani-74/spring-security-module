package ir.mostafa.semnani.springsecuritymodule.security.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDTO {
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
}
