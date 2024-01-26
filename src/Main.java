import storage.user.UserStorage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            switch (command) {

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

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
        System.out.println("0 - Завершение работы");
    }

}
