
import java.util.*;

public class Task8_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        String[] words = input.split("\\s+");
        int minLength = Arrays.stream(words).mapToInt(String::length).min().orElse(0);

        System.out.println("Слова минимальной длины:");
        for (String word : words) {
            if (word.length() == minLength) {
                System.out.println(word);
            }
        }
    }
}