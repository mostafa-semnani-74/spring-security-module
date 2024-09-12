package ir.mostafa.semnani.springsecuritymodule.security.mapper;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AppRoleDTO;
import ir.mostafa.semnani.springsecuritymodule.security.entity.AppRole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppRoleMapper {
    AppRoleDTO toDTO(AppRole appRole);

    AppRole toEntity(AppRoleDTO appRoleDTO);

    List<AppRoleDTO> toDTOs(List<AppRole> appRoles);

}
