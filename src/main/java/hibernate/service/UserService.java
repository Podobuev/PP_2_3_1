package hibernate.service;

import hibernate.model.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(Long id);
    void edit(User user);

}
