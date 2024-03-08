package ir.mostafa.semnani.springsecuritymodule.security.model.repository;

import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
