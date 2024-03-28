package ir.mostafa.semnani.springsecuritymodule.security.model.service;

import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppUserDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppUser;
import ir.mostafa.semnani.springsecuritymodule.security.model.mapper.AppUserMapper;
import ir.mostafa.semnani.springsecuritymodule.security.model.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;

    @Transactional(readOnly = true)
    public List<AppUserDTO> findAll() {
        List<AppUser> appUsers = appUserRepository.findAll();
        return AppUserMapper.toDTOs(appUsers);
    }

    @Transactional(readOnly = true)
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public AppUserDTO save(AppUserDTO appUserDTO) {
        AppUser savedAppUser = appUserRepository.save(AppUserMapper.toEntity(appUserDTO));
        return AppUserMapper.toDTO(savedAppUser);
    }

}
