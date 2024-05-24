package ir.mostafa.semnani.springsecuritymodule.security.model.repository;

import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppPermissionRepository extends JpaRepository<AppPermission, Long> {
    @Query(value = "SELECT ap.* " +
            " FROM tbl_app_permission ap " +
            "   JOIN roles_permissions rp " +
            "       ON ap.id = rp.app_permission_id " +
            " WHERE rp.app_role_id = :roleId ",
            nativeQuery = true)
    List<AppPermission> findByRoleId(@Param("roleId") Long roleId);
}
