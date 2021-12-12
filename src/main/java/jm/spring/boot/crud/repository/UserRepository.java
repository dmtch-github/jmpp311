package jm.spring.boot.crud.repository;

import jm.spring.boot.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findUserByEmail(String email);
}
