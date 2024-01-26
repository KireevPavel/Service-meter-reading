package service;

import model.User;
import storage.user.UserStorage;

import java.util.Scanner;

public class UserService {
    UserStorage userStorage = new UserStorage();
    public void authorization() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста введите логин");
        String login = scanner.nextLine();
        User userLogin = null;
        for (User user : userStorage.getUsers().values()) {
            if (!user.getLogin().equals(login)) {
                System.out.println("Пользователь не найден");
            } else {
                userLogin = user;
            }
        }
        if (userLogin != null) {
            System.out.println("Пожалуйста введите пароль");
            String password = scanner.nextLine();
            if (!userLogin.getPassword().equals(password)) {
                System.out.println("Неверный пароль");
            } else {
                System.out.println("Добро пожаловать");
            }
        }
    }

    public void registration(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста введите логин");
        String login = scanner.nextLine();
        System.out.println("Пожалуйста введите пароль");
        String password = scanner.nextLine();
        User user = new User(0,login, password, "new");
        userStorage.add(user);
    }
}
