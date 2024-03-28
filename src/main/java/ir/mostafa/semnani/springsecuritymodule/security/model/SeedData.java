package ir.mostafa.semnani.springsecuritymodule.security.model;

import ir.mostafa.semnani.springsecuritymodule.security.enums.AppUserPermission;
import ir.mostafa.semnani.springsecuritymodule.security.enums.AppUserRole;
import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppPermissionDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppRoleDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppUserDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppPermission;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppRole;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppUser;
import ir.mostafa.semnani.springsecuritymodule.security.model.repository.AppPermissionRepository;
import ir.mostafa.semnani.springsecuritymodule.security.model.repository.AppRoleRepository;
import ir.mostafa.semnani.springsecuritymodule.security.model.repository.AppUserRepository;
import ir.mostafa.semnani.springsecuritymodule.security.model.service.AppPermissionService;
import ir.mostafa.semnani.springsecuritymodule.security.model.service.AppRoleService;
import ir.mostafa.semnani.springsecuritymodule.security.model.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner {
    private final AppUserService appUserService;
    private final AppPermissionService appPermissionService;
    private final AppRoleService appRoleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // create admin
        AppUserDTO adminDTO = new AppUserDTO();
        adminDTO.setUsername("admin");
        adminDTO.setPassword(passwordEncoder.encode("123"));
        adminDTO = appUserService.save(adminDTO);

        // create admin role
        AppRoleDTO adminAppRoleDTO = AppRoleDTO.builder()
                .name("ROLE_" + AppUserRole.ADMIN.name())
                .build();
        adminAppRoleDTO = appRoleService.save(adminAppRoleDTO);

        appRoleService.joinRoleToUser(adminAppRoleDTO.getId(), adminDTO.getId());


        // create user
        AppUserDTO userDTO = new AppUserDTO();
        userDTO.setUsername("user");
        userDTO.setPassword(passwordEncoder.encode("123"));
        userDTO = appUserService.save(userDTO);

        // create user role
        AppRoleDTO userAppRoleDTO = new AppRoleDTO();
        userAppRoleDTO.setName("ROLE_" + AppUserRole.PERSON.name());
        userAppRoleDTO = appRoleService.save(userAppRoleDTO);

        appRoleService.joinRoleToUser(userAppRoleDTO.getId(), userDTO.getId());


        // create person read permission
        AppPermissionDTO personReadDTO = new AppPermissionDTO();
        personReadDTO.setName(AppUserPermission.PERSON_READ.getPermission());
        personReadDTO = appPermissionService.save(personReadDTO);

        appPermissionService.joinPermissionToRoleById(personReadDTO.getId(), adminAppRoleDTO.getId());
        appPermissionService.joinPermissionToRoleById(personReadDTO.getId(), userAppRoleDTO.getId());

        // create person write permission
        AppPermissionDTO personWriteDTO = new AppPermissionDTO();
        personWriteDTO.setName(AppUserPermission.PERSON_WRITE.getPermission());
        personWriteDTO = appPermissionService.save(personWriteDTO);

        appPermissionService.joinPermissionToRoleById(personWriteDTO.getId(), adminAppRoleDTO.getId());
    }
}
