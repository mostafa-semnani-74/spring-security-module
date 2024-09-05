package ir.mostafa.semnani.springsecuritymodule.security.service;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AppRoleDTO;
import ir.mostafa.semnani.springsecuritymodule.security.entity.AppRole;
import ir.mostafa.semnani.springsecuritymodule.security.mapper.AppRoleMapper;
import ir.mostafa.semnani.springsecuritymodule.security.repository.AppRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class AppRoleService {
    private final AppRoleRepository appRoleRepository;

    @Transactional(readOnly = true)
    public List<AppRoleDTO> findAll() {
        List<AppRole> appRoles = appRoleRepository.findAll();
        return AppRoleMapper.toDTOs(appRoles);
    }

    @Transactional(readOnly = true)
    public AppRole findById(Long id) {
        Optional<AppRole> appRole = appRoleRepository.findById(id);
        if (appRole.isPresent())
            return appRole.get();
        else
            throw new RuntimeException("app role not found with id : " + id);
    }

    @Transactional(readOnly = true)
    public List<AppRole> findByUserId(Long userId) {
        List<AppRole> appRoles = appRoleRepository.findByUserId(userId);
        return appRoles;
    }

    public AppRoleDTO save(AppRoleDTO appRoleDTO) {
        AppRole savedAppRole = appRoleRepository.save(AppRoleMapper.toEntity(appRoleDTO));
        return AppRoleMapper.toDTO(savedAppRole);
    }

}
