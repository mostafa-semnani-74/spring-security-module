package ir.mostafa.semnani.springsecuritymodule.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tests")
public class ManualTestController {

    @GetMapping("/roles/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HttpStatus testAdminRole() {
        return HttpStatus.OK;
    }

    @GetMapping("/roles/person")
    @PreAuthorize("hasRole('ROLE_PERSON')")
    public HttpStatus testPersonRole() {
        return HttpStatus.OK;
    }

    @GetMapping("/authorities/person-read")
    @PreAuthorize("hasAuthority('person:read')")
    public HttpStatus testPersonRead() {
        return HttpStatus.OK;
    }

    @GetMapping("/authorities/person-write")
    @PreAuthorize("hasAuthority('person:write')")
    public HttpStatus testPersonWrite() {
        return HttpStatus.OK;
    }

}
