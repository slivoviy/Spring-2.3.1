package web.service;


import web.model.User;
import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUserById(long id);

    void removeUser(long id);
}
