package service.user;

import model.User;

import java.util.HashMap;

public interface UserService {
    User authorization(User user);

    void registration();

    void setAdminStatus(int id);

    void logOut(User user);

    HashMap<Integer, User> getUserStorage();
}
