package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
    userDAO.addUser(user);
    }

    @Override
    public void editUser(User user) {
    userDAO.editUser(user);
    }

    @Override
    public void removeUserById(long id) {
    userDAO.removeUserById(id);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
