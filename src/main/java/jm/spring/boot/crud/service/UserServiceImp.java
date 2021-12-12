package jm.spring.boot.crud.service;

import jm.spring.boot.crud.dao.UserDao;
import jm.spring.boot.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.loadUserByUsername(username);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public User getUser(int id) {
        return userDao.getUser(id);
    }

    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
