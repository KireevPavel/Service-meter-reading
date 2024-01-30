package service.user;

import model.User;
import storage.user.UserStorage;

import java.util.HashMap;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    private final UserStorage userStorage;

    public UserServiceImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public User authorization(User user) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Пожалуйста введите логин");
        String login = scanner1.nextLine();
        if (userStorage.getUsers().isEmpty()) {
            System.out.println("Нет пользователей");
        }
        for (User listUser : userStorage.getUsers().values()) {
            if (listUser.getLogin().equals(login)) {
                user = listUser;
            }
        }
        if (user != null) {
            System.out.println("Пожалуйста введите пароль");
            String password = scanner1.nextLine();
            if (!user.getPassword().equals(password)) {
                System.out.println("Неверный пароль");
            } else {
                user.setLoggedIn(true);
                System.out.println("Добро пожаловать");
            }
        }
        return user;
    }

    @Override
    public void registration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста введите логин для регистрации");
        String login = scanner.nextLine();
        if (login == null || login.isBlank()) {
            System.out.println("Логин не может быть пустым");
        } else {
            if (userStorage.getUsers().isEmpty()) {
                System.out.println("Пожалуйста введите пароль для регистрации");
                String password = scanner.nextLine();
                if (password == null || password.isBlank()) {
                    System.out.println("Пароль не может быть пустым");
                } else {
                    User user = new User(0, login, password, false, "user");
                    userStorage.add(user);
                }
            } else {
                for (User userList : userStorage.getUsers().values()) {
                    if (userList.getLogin().equals(login)) {
                        System.out.println("Пользователь с таким логином уже существует");
                    } else {
                        System.out.println("Пожалуйста введите пароль для регистрации");
                        String password = scanner.nextLine();
                        if (password == null || password.isBlank()) {
                            System.out.println("Пароль не может быть пустым");
                        } else {
                            User user = new User(0, login, password, false, "user");
                            userStorage.add(user);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void setAdminStatus(int id) {
        User user = userStorage.getById(id);
        user.setStatus("admin");
    }

    @Override
    public void logOut(User user) {
        user.setLoggedIn(false);
    }

    @Override
    public HashMap<Integer, User> getUserStorage() {
        return userStorage.getUsers();
    }


}
