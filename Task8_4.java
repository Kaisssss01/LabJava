
import java.util.Scanner;

public class Task8_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++; // чтобы не считать три подряд как два удвоения
            }
        }

        System.out.println("Количество удвоенных букв: " + count);
    }
}