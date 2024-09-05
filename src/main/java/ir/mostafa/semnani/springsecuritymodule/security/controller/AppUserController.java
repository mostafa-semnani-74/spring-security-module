package ir.mostafa.semnani.springsecuritymodule.security.controller;

import ir.mostafa.semnani.springsecuritymodule.security.dto.AppUserDTO;
import ir.mostafa.semnani.springsecuritymodule.security.service.AppUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/users")
@RequiredArgsConstructor
@Validated
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<AppUserDTO>> findAll() {
        return ResponseEntity.ok(appUserService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AppUserDTO> save(@Valid @RequestBody AppUserDTO appUserDTO) {
        return new ResponseEntity<>(appUserService.save(appUserDTO), HttpStatus.CREATED);
    }

}
