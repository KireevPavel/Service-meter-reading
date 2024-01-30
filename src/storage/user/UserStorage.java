package storage.user;

import model.User;

import java.util.HashMap;

public interface UserStorage {

    void add(User user);

    User getById(int id);

    HashMap<Integer, User> getUsers();
}
