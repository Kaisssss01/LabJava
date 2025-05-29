import java.util.Scanner;

public class Task8_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первую строку: ");
        String str1 = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String str2 = scanner.nextLine();

        boolean contains = str1.toLowerCase().contains(str2.toLowerCase());

        if (contains) {
            System.out.println("Вторая строка входит в первую (без учёта регистра).");
        } else {
            System.out.println("Вторая строка не входит в первую.");
        }
    }
}