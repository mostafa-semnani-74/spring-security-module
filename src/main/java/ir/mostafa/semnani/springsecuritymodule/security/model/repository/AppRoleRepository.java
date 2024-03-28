package ir.mostafa.semnani.springsecuritymodule.security.model.repository;

import ir.mostafa.semnani.springsecuritymodule.security.model.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    @Query(value = "SELECT ar.* " +
            " FROM tbl_app_role ar " +
            "   JOIN users_roles u " +
            "       ON ar.id = u.app_role_id " +
            " WHERE u.app_user_id = :userId ",
            nativeQuery = true)
    List<AppRole> findByUserId(@Param("userId") Long userId);

    @Modifying
    @Query(value = "INSERT INTO users_roles(app_role_id, app_user_id) " +
            " values (:roleId, :userId) ",
            nativeQuery = true)
    void joinRoleToUser(@Param("roleId") Long roleId, @Param("userId") Long userId);
}
