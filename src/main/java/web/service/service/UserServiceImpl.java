package web.service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.service.repository.UserDAO;
import web.service.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userRepository) {
        this.userDAO = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void createOrUpdateUser(User user) {
        if (0 == user.getId()) {
            createUser(user);
        } else {
            updateUser(user);
        }
    }

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User readUser(long id) {
        return userDAO.readUser(id);
    }

    @Override
    public User deleteUser(long id) {
        User user = null;
        user = userDAO.deleteUser(id);
        return user;
    }
}
