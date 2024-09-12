package ir.mostafa.semnani.springsecuritymodule.security.service;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AppPermissionDTO;
import ir.mostafa.semnani.springsecuritymodule.security.entity.AppPermission;
import ir.mostafa.semnani.springsecuritymodule.security.mapper.AppPermissionMapper;
import ir.mostafa.semnani.springsecuritymodule.security.repository.AppPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AppPermissionService {
    private final AppPermissionRepository appPermissionRepository;

    private final AppPermissionMapper appPermissionMapper;

    @Transactional(readOnly = true)
    public List<AppPermissionDTO> findAll() {
        return appPermissionMapper.toDTOs(appPermissionRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<AppPermission> findByRoleId(Long roleId) {
        return appPermissionRepository.findByRoleId(roleId);
    }

    public AppPermissionDTO save(AppPermissionDTO appPermissionDTO) {
        return appPermissionMapper.toDTO(appPermissionRepository.save(appPermissionMapper.toEntity(appPermissionDTO)));
    }
}
