/*Задача 1. Проверка доступа к ресурсу

  В этом задании мы напишем программу для проверки доступа к ресурсу.
     Во время запуска программы нужно запросить логин или пароль пользователя.
     Если один из введеных параметров не совпадает (логин/пароль), то нужно выбросить
      checked исключение exception.UserNotFoundException. Если возраст пользователя менее 18 лет,
      то нужно выбросить исключение exception.AccessDeniedException, а если 18 и больше лет -
       вывести сообщение "Доступ предоставлен".

    Массив пользователей для авторизации нужно описать до запуска программы. Каждая запись
    пользователя содержит поля: login, password, age (возраст) и email.

    Функционал программы
   Создание Scanner для чтения логина и пароля пользователя из консоли;
   Создание checked исключения exception.UserNotFoundException;
    Создание checked исключения exception.AccessDeniedException;
    Выбрасывать ошибку exception.UserNotFoundException, если логин или пароль введены не верно;
    Выбрасывать ошибку exception.AccessDeniedException, если возраст пользователя меньше 18 лет;
    Если ошибок не возникло, вывести сообщение "Доступ предоставлен".
    Процесс реализации
    Создадим класс entity.User, в котором будем хранить инфомрацию о логине, пароле и возрасте пользователя:
    class entity.User, login, password, email, age;
    Создадим класс исключение exception.UserNotFoundException на основе базового класса Exception. Это исключение
    будем использовать, если пользователь ввел неверный логин или пароль:
    public class exception.UserNotFoundException extends Exception {
        public exception.UserNotFoundException(String message) {
            super(message);
        }
    }
    Аналогичным образом создадим класс исключения exception.AccessDeniedException
    Создадим класс Main, в котором создадим метод getUsers, этот метод должен возвращать список заранее
    созданных пользователей:
    public static entity.User[] getUsers() {
        entity.User user1 = new entity.User("jhon", "jhon@gmail.com", "pass", 24);
        ...
        return new entity.User[]{user1, ...};
    }
 TODO   Создадим в классе Main метод getUserByLoginAndPassword(String login, String password), в этом методе нужно
 TODO   найти соответствие пары логина и пароля пользователя из массива, возвращаемого методом getUsers. Если
 TODO   пользователь не найден, выбрасываем исключение exception.UserNotFoundException, если найден - возвращаем найденного
 TODO   пользователя:
 TODO   public static entity.User getUserByLoginAndPassword(String login, String password) throws exception.UserNotFoundException {
 TODO       entity.User[] users = getUsers();
 TODO       for (entity.User user : users) {
 TODO           ...
 TODO       }
 TODO       throw new exception.UserNotFoundException("entity.User not found");
 TODO   }
 TODO   Создадим к классу Main еще один метод validateUser для проверки возрастра пользователя. Если возраст менее
 TODO    18 лет, метод должен выбросить исключение exception.AccessDeniedException:
 TODO   public static void validateUser(entity.User user) throws exception.AccessDeniedException
 TODO   Добавим последний метод в классе Main для запуска программы public static void main(String[] args)
 TODO   throws exception.UserNotFoundException, exception.AccessDeniedException В нем нужно запросить логин и пароль пользователя,
 TODO    проверить есть ли данная пара "логин и пароль" в массиве пользователей и последним шагом провалидировать
 TODO    возраст.
 TODO   public static void main(String[] args) throws exception.UserNotFoundException, exception.AccessDeniedException {
 TODO
 TODO       Scanner scanner = new Scanner(System.in);
 TODO
 TODO       System.out.println("Введите логин");
 TODO       String login = scanner.nextLine();
 TODO       System.out.println("Введите пароль");
 TODO       String password = scanner.nextLine();
 TODO
 TODO       //Проверить логин и пароль
 TODO
 TODO       //Вызвать методы валидации пользователя
 TODO
 TODO       System.out.println("Доступ предоставлен");
 TODO   }
 TODO   Программа завершена. Отличная работа!
 TODO   */

import entity.User;
import exception.AccessDeniedException;
import exception.UserNotFoundException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AccessDeniedException {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Введите логин");
                String login = scanner.nextLine();
                System.out.println("Введите пароль");
                String password = scanner.nextLine();


                User user = getUserByLoginAndPassword(login, password);
                if (user != null) {
                    validateUser(user);
                    break;

                } else throw new UserNotFoundException();
            }catch (UserNotFoundException e ) {
                System.out.println("Пользователь не найден - попробуйте снова");
            }

        }
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException();
        } else {
            System.out.println("доступ предоставлен");
        }
    }


    public static User[] getUsers() {
        User user1 = new User("jhon", "passw", "jhon@gmail.com", 24);
        User user2 = new User("Mike", "123", "mike@mail.ru", 29);
        User firstUser = new User("log", "pass", "LK@fjdfh.ru", 4);
        return new User[]{user1, user2, firstUser};
    }

    public static User getUserByLoginAndPassword(String login, String password) {

        for (User user : getUsers()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("Вход выполнен!");
                return user;
            }
        }

        return null;
    }


}
