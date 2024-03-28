package ir.mostafa.semnani.springsecuritymodule.security.model.mapper;

import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppRoleDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppUserRolesDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppRole;

public class AppRoleMapper {
    public static AppRoleDTO toDTO(AppRole appRole) {
        return AppRoleDTO.builder()
                .id(appRole.getId())
                .name(appRole.getName())
                .build();
    }

    public static AppUserRolesDTO toAppUserRolesDTO(AppRole appRole) {
        return AppUserRolesDTO.builder()
                .id(appRole.getId())
                .name(appRole.getName())
                .build();
    }

    public static AppRole toEntity(AppRoleDTO appRoleDTO) {
        return AppRole.builder()
                .id(appRoleDTO.getId())
                .name(appRoleDTO.getName())
                .build();
    }

}
