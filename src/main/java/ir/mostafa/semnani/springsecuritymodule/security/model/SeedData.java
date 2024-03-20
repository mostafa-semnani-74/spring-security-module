package ir.mostafa.semnani.springsecuritymodule.security.model;

import ir.mostafa.semnani.springsecuritymodule.security.enums.AppUserPermission;
import ir.mostafa.semnani.springsecuritymodule.security.enums.AppUserRole;
import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppUserDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppPermission;
import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppRole;
import ir.mostafa.semnani.springsecuritymodule.security.model.service.AppPermissionService;
import ir.mostafa.semnani.springsecuritymodule.security.model.service.AppRoleService;
import ir.mostafa.semnani.springsecuritymodule.security.model.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        AppUserDTO admin = new AppUserDTO();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("123"));

        AppRole adminAppRole = new AppRole();
        adminAppRole.setName("ROLE_" + AppUserRole.ADMIN.name());
        admin.setRoles(Set.of(adminAppRole));

        appUserService.save(admin);

        // create user
        AppUserDTO user = new AppUserDTO();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("123"));

        AppRole userAppRole = new AppRole();
        userAppRole.setName("ROLE_" + AppUserRole.PERSON.name());
        user.setRoles(Set.of(userAppRole));

        appUserService.save(user);

        List<AppRole> appRoles = appRoleService.findAll();
        for (AppRole appRole : appRoles) {
            if (appRole.getName().equals(adminAppRole.getName()))
                adminAppRole.setId(appRole.getId());
            else if (appRole.getName().equals(userAppRole.getName()))
                userAppRole.setId(appRole.getId());
        }

        // create person read permission for person
        AppPermission personReadUser = new AppPermission();
        personReadUser.setName(AppUserPermission.PERSON_READ.getPermission());
        appPermissionService.save(personReadUser, userAppRole.getId());

        // create person read permission for admin
        AppPermission personRead = new AppPermission();
        personRead.setName(AppUserPermission.PERSON_READ.getPermission());
        appPermissionService.save(personRead, adminAppRole.getId());

        // create person write permission for admin
        AppPermission personWrite = new AppPermission();
        personWrite.setName(AppUserPermission.PERSON_WRITE.getPermission());
        appPermissionService.save(personWrite, adminAppRole.getId());

    }
}
