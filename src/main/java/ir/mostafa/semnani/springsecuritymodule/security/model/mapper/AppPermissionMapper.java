package ir.mostafa.semnani.springsecuritymodule.security.model.mapper;

import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppPermissionDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppPermission;

public class AppPermissionMapper {
    public static AppPermission toEntity(AppPermissionDTO appPermissionDTO) {
        return AppPermission.builder()
                .id(appPermissionDTO.getId())
                .name(appPermissionDTO.getName())
                .build();
    }

    public static AppPermissionDTO toDTO(AppPermission appPermission) {
        return AppPermissionDTO.builder()
                .id(appPermission.getId())
                .name(appPermission.getName())
                .build();
    }

}
