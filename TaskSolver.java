import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задача 4.2
        System.out.println("Задача 4.2: Введите натуральное число a:"); // Выводим подсказку для пользователя
        int a42 = scanner.nextInt(); // Читаем введенное число a
        solve42(a42); // Вызываем метод для решения задачи 4.2

        // Задача 4.5
        System.out.println("Задача 4.5: Введите натуральное число N:"); // Выводим подсказку для пользователя
        int n45 = scanner.nextInt(); // Читаем введенное число N
        solve45(n45); // Вызываем метод для решения задачи 4.5

        // Задача 4.7
        System.out.println("Задача 4.7: Введите натуральное число N:"); // Выводим подсказку для пользователя
        int n47 = scanner.nextInt(); // Читаем введенное число N
        solve47(n47); // Вызываем метод для решения задачи 4.7

        // Задача 4.8
        System.out.println("Задача 4.8: Введите два натуральных числа P и R:"); // Выводим подсказку для пользователя
        int p48 = scanner.nextInt(); // Читаем введенное число P
        int r48 = scanner.nextInt(); // Читаем введенное число R
        solve48(p48, r48); // Вызываем метод для решения задачи 4.8

        // Задача 4.13
        System.out.println("Задача 4.13: Введите натуральное число N:"); // Выводим подсказку для пользователя
        int n413 = scanner.nextInt(); // Читаем введенное число N
        solve413(n413); // Вызываем метод для решения задачи 4.13

        // Задача 4.14
        System.out.println("Задача 4.14: Введите натуральное число N:"); // Выводим подсказку для пользователя
        int n414 = scanner.nextInt(); // Читаем введенное число N
        solve414(n414); // Вызываем метод для решения задачи 4.14

        // Задача 4.15
        System.out.println("Задача 4.15: Введите натуральное число N:"); // Выводим подсказку для пользователя
        int n415 = scanner.nextInt(); // Читаем введенное число N
        solve415(n415); // Вызываем метод для решения задачи 4.15

        // Задача 4.16
        System.out.println("Задача 4.16: Введите последовательность чисел (заканчивающуюся 0):"); // Выводим подсказку для пользователя
        solve416(scanner); // Вызываем метод для решения задачи 4.16

    }

    // Задача 4.2: 1! + 2! + 3! + ... > a
    public static void solve42(int a) {
        long sum = 0; // Инициализируем переменную для суммы
        long factorial = 1; // Инициализируем переменную для факториала
        int i = 1; // Инициализируем счетчик

        while (sum <= a) { // Пока сумма меньше или равна a
            factorial *= i;
            sum += factorial;
            i++; // Увеличиваем счетчик
        }

        System.out.println("Номер слагаемого, на котором сумма превзойдет " + a + ": " + (i - 1));
        System.out.println("Слагаемое: " + factorial);
        System.out.println("Сумма: " + sum);
    }

    // Задача 4.5: Количество единиц в двоичной записи числа N
    public static void solve45(int n) {
        int count = 0; // Инициализируем счетчик единиц
        while (n > 0) { // Пока n больше 0
            if (n % 2 == 1) { // Если остаток от деления на 2 равен 1 (т.е., последний бит равен 1)
                count++; // Увеличиваем счетчик
            }
            n /= 2; // Делим n на 2 (сдвигаем биты вправо)
        }
        System.out.println("Количество единиц в двоичной записи числа " + n + ": " + count); // Выводим количество единиц
    }

    // Задача 4.7: Числа Фибоначчи, не превосходящие N
    public static void solve47(int n) {
        int a = 1; // Первое число Фибоначчи
        int b = 1; // Второе число Фибоначчи

        System.out.print("Числа Фибоначчи, не превосходящие " + n + ": "); // Выводим сообщение
        System.out.print(a + " "); // Выводим первое число
        if (n >= b) { // Если N больше или равно второму числу
            System.out.print(b + " "); // Выводим второе число
        }

        while (true) { // Бесконечный цикл
            int next = a + b; // Вычисляем следующее число Фибоначчи
            if (next > n) { // Если следующее число больше N
                break; // Выходим из цикла
            }
            System.out.print(next + " "); // Выводим следующее число
            a = b; // Сдвигаем a
            b = next; // Сдвигаем b
        }
        System.out.println(); // Переходим на новую строку
    }

    // Задача 4.8: Проверка допустимости пин-кода (одна ошибка)
    public static void solve48(int p, int r) {
        String pStr = String.valueOf(p); // Преобразуем P в строку
        String rStr = String.valueOf(r); // Преобразуем R в строку

        if (pStr.length() != rStr.length()) { // Если длины строк не равны
            System.out.println("Недопустимый пин-код (разная длина)."); // Выводим сообщение
            return; // Выходим из метода
        }

        int diffCount = 0; // Инициализируем счетчик различий
        for (int i = 0; i < pStr.length(); i++) { // Проходим по строкам
            if (pStr.charAt(i) != rStr.charAt(i)) { // Если символы не равны
                diffCount++; // Увеличиваем счетчик различий
            }
        }

        if (diffCount <= 1) { // Если количество различий не больше 1
            System.out.println("Допустимый пин-код."); // Выводим сообщение
        } else { // Иначе
            System.out.println("Недопустимый пин-код (более одной ошибки)."); // Выводим сообщение
        }
    }

    // Задача 4.13: Построить новое число удалением нечетных цифр
    public static void solve413(int n) {
        String nStr = String.valueOf(n); // Преобразуем число в строку
        StringBuilder result = new StringBuilder(); // Создаем StringBuilder для построения нового числа

        for (int i = 0; i < nStr.length(); i++) { // Проходим по строке
            char c = nStr.charAt(i); // Получаем символ
            if (Character.isDigit(c)) { // Если символ - цифра
                int digit = Character.getNumericValue(c); // Преобразуем символ в цифру
                if (digit % 2 == 0) { // Если цифра четная
                    result.append(c); // Добавляем цифру в StringBuilder
                }
            }
        }

        System.out.println("Новое число после удаления нечетных цифр: " + result.toString()); // Выводим результат
    }

    // Задача 4.14: Определить, является ли число палиндромом
    public static void solve414(int n) {
        String nStr = String.valueOf(n); // Преобразуем число в строку
        String reversedNStr = new StringBuilder(nStr).reverse().toString(); // Переворачиваем строку

        if (nStr.equals(reversedNStr)) { // Если строка равна перевернутой строке
            System.out.println(n + " является палиндромом."); // Выводим сообщение
        } else { // Иначе
            System.out.println(n + " не является палиндромом."); // Выводим сообщение
        }
    }

    // Задача 4.15: Построить из цифр числа N натуральное число «удалением» всех четных цифр
    public static void solve415(int n) {
        String nStr = String.valueOf(n); // Преобразуем число в строку
        StringBuilder result = new StringBuilder(); // Создаем StringBuilder для построения нового числа

        for (int i = 0; i < nStr.length(); i++) { // Проходим по строке
            char c = nStr.charAt(i); // Получаем символ
            if (Character.isDigit(c)) { // Если символ - цифра
                int digit = Character.getNumericValue(c); // Преобразуем символ в цифру
                if (digit % 2 != 0) { // Если цифра нечетная
                    result.append(c); // Добавляем цифру в StringBuilder
                }
            }
        }

        System.out.println("Новое число после удаления четных цифр: " + result.toString()); // Выводим результат
    }

    // Задача 4.16: Вводить последовательность чисел (до 0), найти максимум и минимум и их индексы
    public static void solve416(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>(); // Создаем список для хранения чисел
        int number; // Переменная для хранения введенного числа



        while (true) { // Бесконечный цикл
            number = scanner.nextInt(); // Читаем введенное число
            if (number == 0) { // Если число равно 0
                break; // Выходим из цикла
            }
            numbers.add(number); // Добавляем число в список
        }

        if (numbers.isEmpty()) { // Если список пуст
            System.out.println("Последовательность пуста."); // Выводим сообщение
            return; // Выходим из метода
        }

        int max = numbers.get(0); // Инициализируем максимум первым элементом списка
        int min = numbers.get(0); // Инициализируем минимум первым элементом списка
        int maxIndex = 1; // Инициализируем индекс максимума
        int minIndex = 1; // Инициализируем индекс минимума

        for (int i = 1; i < numbers.size(); i++) { // Проходим по списку
            int current = numbers.get(i); // Получаем текущий элемент
            if (current > max) { // Если текущий элемент больше максимума
                max = current; // Обновляем максимум
                maxIndex = i+1; // Обновляем индекс максимума
            }
            if (current < min) { // Если текущий элемент меньше минимума
                min = current; // Обновляем минимум
                minIndex = i; // Обновляем индекс минимума
            }
        }

        System.out.println("Максимальное число: " + max + ", индекс: " + maxIndex); // Выводим максимум и его индекс
        System.out.println("Минимальное число: " + min + ", индекс: " + minIndex); // Выводим минимум и его индекс
    }
}
