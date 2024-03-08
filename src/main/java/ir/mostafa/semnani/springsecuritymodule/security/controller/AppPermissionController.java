package ir.mostafa.semnani.springsecuritymodule.security.controller;

import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppPermission;
import ir.mostafa.semnani.springsecuritymodule.security.model.service.AppPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/permissions")
public class AppPermissionController {
    private final AppPermissionService appPermissionService;

    @Autowired
    public AppPermissionController(AppPermissionService appPermissionService) {
        this.appPermissionService = appPermissionService;
    }

    @GetMapping
    public ResponseEntity<List<AppPermission>> findAll() {
        return ResponseEntity.ok(appPermissionService.findAll());
    }
}
