import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();

        directory.add("Ефимов", "+79118880687");
        directory.add("Бершадский", "+79214567890");
        directory.add("Ботев", "+79304567890");
        directory.add("Чермных", "+71234567890");
        directory.add("Ефимов", "+79118880687");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Показать полный список телефонов");
            System.out.println("2. Найти телефон по фамилии");
            System.out.println("3. Добавить номер");
            System.out.println("4. Выйти");
            System.out.print("Введите номер действия: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\nПолный справочник:");
                    directory.printDirectory();
                    break;
                case "2":
                    System.out.print("Введите фамилию для поиска номеров: ");
                    String surname = scanner.nextLine();
                    Set<String> numbers = directory.get(surname);
                    if (numbers.isEmpty()) {
                        System.out.println("Номеров для фамилии " + surname + " не найдено.");
                    } else {
                        System.out.println("Номера для фамилии " + surname + ": " + numbers);
                    }
                    break;

                case "3":
                    System.out.print("Введите фамилию для добавления номера: ");
                    String newSurname = scanner.nextLine();
                    System.out.print("Введите номер телефона в формате +7XXXXXXXXXX: ");
                    String newPhoneNumber = scanner.nextLine();
                    directory.add(newSurname, newPhoneNumber);
                    break;

                case "4":
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите 1, 2, 3 или 4.");
            }
        }
    }
}
