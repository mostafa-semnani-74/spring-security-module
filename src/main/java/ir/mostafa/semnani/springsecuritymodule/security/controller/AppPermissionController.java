package ir.mostafa.semnani.springsecuritymodule.security.controller;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AppPermissionDTO;
import ir.mostafa.semnani.springsecuritymodule.security.service.AppPermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/permissions")
@RequiredArgsConstructor
public class AppPermissionController {
    private final AppPermissionService appPermissionService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<AppPermissionDTO>> findAll() {
        return ResponseEntity.ok(appPermissionService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AppPermissionDTO> save(@Valid @RequestBody AppPermissionDTO appPermissionDTO) {
        return new ResponseEntity<>(appPermissionService.save(appPermissionDTO), HttpStatus.CREATED);
    }

}
