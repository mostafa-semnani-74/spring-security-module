package ir.mostafa.semnani.springsecuritymodule.security.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUserRolesDTO {
    private Long id;
    private String name;
}
