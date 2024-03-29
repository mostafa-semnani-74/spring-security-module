package ir.mostafa.semnani.springsecuritymodule.security.model.service;

import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppRoleDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppRole;
import ir.mostafa.semnani.springsecuritymodule.security.model.mapper.AppRoleMapper;
import ir.mostafa.semnani.springsecuritymodule.security.model.repository.AppRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;


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

    public List<AppRole> saveAll(Set<AppRole> roles) {
        return appRoleRepository.saveAll(roles);
    }

    public void joinRoleToUser(Long roleId, Long userId) {
        appRoleRepository.joinRoleToUser(roleId, userId);
    }

}
