package storage.user;

import model.User;
import exception.NotFoundException;

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

    public User add(User user) {
        user.setId(generateId());
        users.put(user.getId(), user);
        return user;
    }

    public User getById(int id) {
        if (users.containsKey(id)) {
            return users.get(id);
        } else throw new NotFoundException("User not found.");
    }

}