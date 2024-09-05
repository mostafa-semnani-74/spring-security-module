package ir.mostafa.semnani.springsecuritymodule.security.mapper;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AppUserDTO;
import ir.mostafa.semnani.springsecuritymodule.security.entity.AppUser;

import java.util.List;
import java.util.stream.Collectors;

public class AppUserMapper {
    public static AppUser toEntity(AppUserDTO appUserDTO) {
        return AppUser.builder()
                .id(appUserDTO.getId())
                .username(appUserDTO.getUsername())
                .password(appUserDTO.getPassword())
                .build();
    }

    public static AppUserDTO toDTO(AppUser appUser) {
        return AppUserDTO.builder()
                .id(appUser.getId())
                .username(appUser.getUsername())
                .build();
    }

    public static List<AppUserDTO> toDTOs(List<AppUser> appUsers) {
        return appUsers.stream()
                .map(AppUserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
