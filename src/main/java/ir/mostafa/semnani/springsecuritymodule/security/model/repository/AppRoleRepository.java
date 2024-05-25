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

    @Query(value = "SELECT ar " +
            " FROM AppRole ar " +
            "   JOIN FETCH ar.users u " +
            " WHERE u.id = :userId ")
    List<AppRole> findByUserId(@Param("userId") Long userId);

}
