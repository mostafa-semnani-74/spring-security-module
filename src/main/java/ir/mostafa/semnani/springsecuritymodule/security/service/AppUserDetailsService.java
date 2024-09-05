package ir.mostafa.semnani.springsecuritymodule.security.service;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AppUserDetails;
import ir.mostafa.semnani.springsecuritymodule.security.entity.AppRole;
import ir.mostafa.semnani.springsecuritymodule.security.entity.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final AppUserService appUserService;
    private final AppRoleService appRoleService;
    private final AppPermissionService appPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.findByUsername(username);
        List<AppRole> appRoles = appRoleService.findByUserId(appUser.getId());

        List<GrantedAuthority> authorities = appRoles.stream()
                .map(appRole -> new SimpleGrantedAuthority(appRole.getName()))
                .collect(Collectors.toList());

        List<GrantedAuthority> permissions = new ArrayList<>();
        appRoles.forEach(appRole ->
                permissions.addAll(appPermissionService.findByRoleId(appRole.getId())
                        .stream().map(appPermission -> new SimpleGrantedAuthority(appPermission.getName()))
                        .collect(Collectors.toList())));

        authorities.addAll(permissions);

        AppUserDetails appUserDetails = new AppUserDetails(
                appUser.getUsername(), appUser.getPassword(), authorities,
                true, true, true, true
        );

        return appUserDetails;
    }
}
