package ir.mostafa.semnani.springsecuritymodule.security.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppPermissionDTO {
    private Long id;
    @NotNull
    private String name;
}
