package service;

import model.User;
import storage.user.UserStorage;

import java.util.Scanner;

public class UserService {
    UserStorage userStorage = new UserStorage();
    public User authorization() {
        User userLogin = null;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Пожалуйста введите логин");
        String login = scanner1.nextLine();
        if(userStorage.getUsers().isEmpty()){
            System.out.println("Нет пользователей");
        }
        for (User user : userStorage.getUsers().values()) {
            if (!user.getLogin().equals(login)) {
                System.out.println("Пользователь не найден");
            } else {
                userLogin = user;
            }
        }
        if (userLogin != null) {
            System.out.println("Пожалуйста введите пароль");
            String password = scanner1.nextLine();
            if (!userLogin.getPassword().equals(password)) {
                System.out.println("Неверный пароль");
            } else {
                userLogin.setLoggedIn(true);
                System.out.println("Добро пожаловать");
            }
        }
        return userLogin;
    }

    public User registration(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста введите логин для регистрации");
        String login = scanner.nextLine();
        System.out.println("Пожалуйста введите пароль для регистрации");
        String password = scanner.nextLine();
        User user = new User(0,login, password,false, "user");
        userStorage.add(user);
        return user;
    }
}
