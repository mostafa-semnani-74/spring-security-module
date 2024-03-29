package ir.mostafa.semnani.springsecuritymodule.security.controller;

import ir.mostafa.semnani.springsecuritymodule.security.model.dto.AppRoleDTO;
import ir.mostafa.semnani.springsecuritymodule.security.model.service.AppRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/roles")
@RequiredArgsConstructor
public class AppRoleController {
    private final AppRoleService appRoleService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<AppRoleDTO>> findAll() {
        return ResponseEntity.ok(appRoleService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AppRoleDTO> save(@RequestBody AppRoleDTO appRoleDTO) {
        return new ResponseEntity<>(appRoleService.save(appRoleDTO), HttpStatus.CREATED);
    }
}
