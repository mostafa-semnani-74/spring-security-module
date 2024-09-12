package ir.mostafa.semnani.springsecuritymodule.security.mapper;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AppUserDTO;
import ir.mostafa.semnani.springsecuritymodule.security.entity.AppUser;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUser toEntity(AppUserDTO appUserDTO);

    AppUserDTO toDTO(AppUser appUser);

    List<AppUserDTO> toDTOs(List<AppUser> appUsers);
}
