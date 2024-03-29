package ir.mostafa.semnani.springsecuritymodule.security.model.mapper;

import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppPermissionDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppPermission;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<AppPermissionDTO> toDTOs(List<AppPermission> appPermissions) {
        return appPermissions.stream()
                .map(AppPermissionMapper::toDTO)
                .collect(Collectors.toList());
    }

}
