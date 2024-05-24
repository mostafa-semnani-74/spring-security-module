package ir.mostafa.semnani.springsecuritymodule.security.model.service;

import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppPermissionDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppPermission;
import ir.mostafa.semnani.springsecuritymodule.security.model.mapper.AppPermissionMapper;
import ir.mostafa.semnani.springsecuritymodule.security.model.repository.AppPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AppPermissionService {
    private final AppPermissionRepository appPermissionRepository;

    @Transactional(readOnly = true)
    public List<AppPermissionDTO> findAll() {
        return AppPermissionMapper.toDTOs(appPermissionRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<AppPermission> findByRoleId(Long roleId) {
        return appPermissionRepository.findByRoleId(roleId);
    }

    public AppPermissionDTO save(AppPermissionDTO appPermissionDTO) {
        return AppPermissionMapper.toDTO(appPermissionRepository.save(AppPermissionMapper.toEntity(appPermissionDTO)));
    }
}
