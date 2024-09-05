package ir.mostafa.semnani.springsecuritymodule.security.repository;

import ir.mostafa.semnani.springsecuritymodule.security.entity.AppPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppPermissionRepository extends JpaRepository<AppPermission, Long> {

    @Query(value = "SELECT ap " +
            " FROM AppPermission ap " +
            "   JOIN FETCH ap.appRoles ar " +
            " WHERE ar.id = :roleId ")
    List<AppPermission> findByRoleId(@Param("roleId") Long roleId);

}
