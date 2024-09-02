package ir.mostafa.semnani.springsecuritymodule.security.enums;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static ir.mostafa.semnani.springsecuritymodule.security.enums.AppUserPermission.PERSON_READ;

@RequiredArgsConstructor
public enum AppUserRole {
    ADMIN(Set.of(AppUserPermission.PERSON_WRITE, PERSON_READ)),
    PERSON(Set.of(PERSON_READ));

    private final Set<AppUserPermission> permissions;

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }
}
