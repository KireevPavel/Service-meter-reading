import model.User;
import service.UserService;
import service.UserServiceImpl;
import service.WaterMeterService;
import service.WaterMeterServiceImpl;
import storage.user.InMemoryUserStorage;
import storage.user.UserStorage;
import storage.waterMeter.InMemoryWaterMeterStorage;
import storage.waterMeter.WaterMeterStorage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        WaterMeterStorage waterMeterStorage = new InMemoryWaterMeterStorage();
        WaterMeterService waterMeterService = new WaterMeterServiceImpl(waterMeterStorage);
        UserStorage userStorage = new InMemoryUserStorage();
        UserService userService = new UserServiceImpl(userStorage);
        Scanner scanner = new Scanner(System.in);
        User user = null;

        while (true) {
            if (user == null || !user.isLoggedIn()) {
                printStartMenu();
                int command = scanner.nextInt();

                switch (command) {
                    case 1:
                        user = userService.authorization(user);
                        break;
                    case 2:
                        userService.registration();
                        break;
                    case 0:
                        System.out.println("Программа завершена");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Введено некорректное значение ");

                }
            } else {
                printMenu();
                int command = scanner.nextInt();

                switch (command) {
                    case 1:
                        if (user.getStatus().equals("admin")) {
                            System.out.println(waterMeterService.getLastMeterReadingsForAdmin());
                        } else {
                            System.out.println(waterMeterService.getLastMeterReadings(user));
                        }
                        break;
                    case 2:
                        waterMeterService.givingEvidence(user);
                        break;
                    case 3:
                        if (user.getStatus().equals("admin")) {
                            System.out.println("Введите месяц");
                            int month = scanner.nextInt();
                            System.out.println(waterMeterService.getMeterReadingsInMonthForAdmin(month));
                        } else {
                            System.out.println("Введите месяц");
                            int month = scanner.nextInt();
                            System.out.println(waterMeterService.getMeterReadingsInMonth(user, month));
                        }
                        break;
                    case 4:
                        if (user.getStatus().equals("admin")) {
                            System.out.println(waterMeterService.getMeterReadingsForAdmin());
                        } else {
                            System.out.println(waterMeterService.getMeterReadings(user));
                        }
                        break;

                    case 5:
                        if (user.getStatus().equals("user")) {
                            System.out.println("Правами может управлять только администратор");
                        } else {
                            System.out.println("Введите id пользователя, которому хотите предоставить права администратора");
                            int id = scanner.nextInt();
                            userService.setAdminStatus(id);
                        }
                        break;

                    case 0:
                        userService.logOut(user);
                        System.out.println("Программа завершена");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Введено некорректное значение ");
                }
            }
        }
    }

    public static void printStartMenu() {
        System.out.println("Выберите действие");
        System.out.println("1 - Авторизоваться");
        System.out.println("2 - Зарегестрироваться");
        System.out.println("0 - Завершение работы");
    }

    public static void printMenu() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1 - Получить актуальные показания счетчиков");
        System.out.println("2 - Подать показания");
        System.out.println("3 - Показания счетчиков за конкретный месяц");
        System.out.println("4 - История подачи показаний");
        System.out.println("5 - Управление првами администратора");
        System.out.println("0 - Завершение работы");
    }

}

