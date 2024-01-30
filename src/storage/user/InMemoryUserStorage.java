package storage.user;

import exception.Exception;
import model.User;

import java.util.HashMap;

public class InMemoryUserStorage implements UserStorage {

    private final HashMap<Integer, User> users = new HashMap<>();
    private int id = 0;

    private int generateId() {
        return ++id;
    }

    @Override
    public void add(User user) {
        user.setId(generateId());
        users.put(user.getId(), user);
    }

    @Override
    public User getById(int id) {
        if (users.containsKey(id)) {
            return users.get(id);
        } else throw new Exception("User not found.");
    }

    @Override
    public HashMap<Integer, User> getUsers() {
        return users;
    }

}