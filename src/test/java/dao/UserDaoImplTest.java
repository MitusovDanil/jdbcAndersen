package dao;

import entities.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
    private static UserDaoImpl userDao;
    private static User  user;

    @BeforeAll
    static void init() {
        userDao = new UserDaoImpl();
        user = new User(4,"Serg", "123@mail.ru", "qwerty");
    }

    @Test
    void getAllUsers() {
        List<User> users = userDao.getAllUsers();
        assertFalse(users.isEmpty());
    }

    @Test
    void addNewUser() {
        assertEquals(1,userDao.addNewUser(user));
    }

    @Test
    void deleteUser() {
        List<User> users = userDao.getAllUsers();
        assertFalse(users.contains(userDao.deleteUser(5)));
    }

    @Test
    void getUserById() {
        List<User> users = userDao.getAllUsers();
        assertTrue(users.contains(userDao.getUserById(6)));
    }

    @Test
    void updateConcreteUser() {
        assertEquals(1,userDao.updateConcreteUser(user));
    }
}