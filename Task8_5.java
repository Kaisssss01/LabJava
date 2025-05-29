import java.util.Scanner;

public class Task8_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите фамилию, имя и отчество: ");
        String input = scanner.nextLine();

        String[] parts = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            if (part.length() > 0) {
                String normalized = part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase();
                result.append(normalized).append(" ");
            }
        }

        System.out.println("Нормализованное ФИО: " + result.toString().trim());
    }
}