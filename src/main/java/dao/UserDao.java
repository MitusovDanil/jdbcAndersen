package dao;

import entities.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    int addNewUser(User user);

    int deleteUser(Integer id);

    User getUserById(Integer id);

    int updateConcreteUser(User user);

}
