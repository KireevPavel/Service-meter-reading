package service;

import model.User;
import storage.user.UserStorage;

import java.util.HashMap;
import java.util.Scanner;

public class UserService {
    UserStorage userStorage = new UserStorage();
    public User authorization(User user) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Пожалуйста введите логин");
        String login = scanner1.nextLine();
        if(userStorage.getUsers().isEmpty()){
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

    public void registration(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста введите логин для регистрации");
        String login = scanner.nextLine();
        System.out.println("Пожалуйста введите пароль для регистрации");
        String password = scanner.nextLine();
        User user = new User(0, login, password, false, "user");
        userStorage.add(user);
    }

    public void setAdminStatus(int id){
        User user = userStorage.getById(id);
        user.setStatus("admin");
    }

    public void logOut(User user){
        user.setLoggedIn(false);
    }

    public HashMap<Integer, User> getUserStorage() {
        return userStorage.getUsers();
    }
}
