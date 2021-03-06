package jm.spring.boot.crud.dao;

import jm.spring.boot.crud.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDao {

    public UserDetails loadUserByUsername(String username);

    public List<User> getUsers();

    public void saveUser(User user);

    public void deleteUser(int id);

    public User getUser(int id);

    public User getUserByName(String username);
}
