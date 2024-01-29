package storage.user;

import model.User;
import exception.Exception;

import java.util.HashMap;

public class UserStorage {


    public HashMap<Integer, User> getUsers() {
        return users;
    }

    private final HashMap<Integer, User> users = new HashMap<>();
    private int id = 0;

    private int generateId() {
        return ++id;
    }

    public void add(User user) {
        user.setId(generateId());
        users.put(user.getId(), user);
    }

    public User getById(int id) {
        if (users.containsKey(id)) {
            return users.get(id);
        } else throw new Exception("User not found.");
    }

}