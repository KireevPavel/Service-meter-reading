import model.User;
import model.WaterMeter;
import service.UserService;
import service.WaterMeterService;
import storage.user.UserStorage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        WaterMeterService waterMeterService = new WaterMeterService();
        Scanner scanner = new Scanner(System.in);
        User user = null;


        while (true) {
                printMenu();
                int command = scanner.nextInt();

                switch (command) {

                    case 1:
                        if(user == null){
                            System.out.println("требуется авторизация");
                        }else {
                            System.out.println(waterMeterService.getLastMeterReadings(user).toString());
                        }
                        break;
                    case 2:
                        if(user == null){
                            System.out.println("требуется авторизация");
                        }else {
                            waterMeterService.givingEvidence(user);
                        }
                        break;
                    case 3:if(user == null){
                        System.out.println("требуется авторизация");
                    }else {
                        System.out.println("Введите месяц");
                        int month = scanner.nextInt();
                        System.out.println(waterMeterService.getMeterReadingsInMonth(user, month).toString());
                    }
                        break;
                    case 4:
                        if(user == null){
                            System.out.println("требуется авторизация");
                        }else {
                            System.out.println(waterMeterService.getMeterReadings(user).toString());
                        }
                        break;
                    case 5:
                        user = userService.authorization();
                        break;
                    case 6:
                        userService.registration();
                        break;

                    case 0:
                        System.out.println("Программа завершена");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Введено некорректное значение ");
                        printMenu();
                }
            }

    }



    public static void printMenu() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1 - Получить актуальные показания счетчиков");
        System.out.println("2 - Подать показания");
        System.out.println("3 - Показания счетчиков за конкретный месяц");
        System.out.println("4 - История подачи показаний");
        System.out.println("5 - Авторизоваться ");
        System.out.println("6 - Зарегестрироваться");
        System.out.println("0 - Завершение работы");
    }

    }

