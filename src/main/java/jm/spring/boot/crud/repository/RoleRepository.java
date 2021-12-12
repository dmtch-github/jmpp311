package jm.spring.boot.crud.repository;

import jm.spring.boot.crud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findRoleByName(String name);
}
