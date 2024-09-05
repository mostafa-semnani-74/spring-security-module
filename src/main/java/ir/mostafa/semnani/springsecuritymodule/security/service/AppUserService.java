package ir.mostafa.semnani.springsecuritymodule.security.service;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AppUserDTO;
import ir.mostafa.semnani.springsecuritymodule.security.entity.AppUser;
import ir.mostafa.semnani.springsecuritymodule.security.mapper.AppUserMapper;
import ir.mostafa.semnani.springsecuritymodule.security.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<AppUserDTO> findAll() {
        List<AppUser> appUsers = appUserRepository.findAll();
        return AppUserMapper.toDTOs(appUsers);
    }

    @Transactional(readOnly = true)
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public AppUserDTO save(AppUserDTO appUserDTO) {
        appUserDTO.setPassword(passwordEncoder.encode(appUserDTO.getPassword()));
        AppUser savedAppUser = appUserRepository.save(AppUserMapper.toEntity(appUserDTO));
        return AppUserMapper.toDTO(savedAppUser);
    }

}
