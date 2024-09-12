package ir.mostafa.semnani.springsecuritymodule.security.mapper;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AppPermissionDTO;
import ir.mostafa.semnani.springsecuritymodule.security.entity.AppPermission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppPermissionMapper {
    AppPermission toEntity(AppPermissionDTO appPermissionDTO);

    AppPermissionDTO toDTO(AppPermission appPermission);

    List<AppPermissionDTO> toDTOs(List<AppPermission> appPermissions);

}
