package ir.mostafa.semnani.springsecuritymodule.security.controller;

import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppRole;
import ir.mostafa.semnani.springsecuritymodule.security.model.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/roles")
public class AppRoleController {
    private final AppRoleService appRoleService;

    @Autowired
    public AppRoleController(AppRoleService appRoleService) {
        this.appRoleService = appRoleService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<AppRole>> findAll() {
        return ResponseEntity.ok(appRoleService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AppRole> save(@RequestBody AppRole appRole) {
        return new ResponseEntity<>(appRoleService.save(appRole), HttpStatus.CREATED);
    }
}
