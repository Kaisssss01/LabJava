import java.util.Arrays;
import java.util.Scanner;

class Student {
    String lastName;
    String firstName;
    int grade;

    public Student(String lastName, String firstName, int grade) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + ", класс: " + grade;
    }
}

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество учеников: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Очистка после числа

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Ученик #" + (i + 1));
            System.out.print("Фамилия: ");
            String lastName = scanner.nextLine();
            System.out.print("Имя: ");
            String firstName = scanner.nextLine();
            System.out.print("Класс: ");
            int grade = scanner.nextInt();
            scanner.nextLine(); // Очистка после числа

            students[i] = new Student(lastName, firstName, grade);
        }

        // Сортировка по фамилии
        Arrays.sort(students, (s1, s2) -> s1.lastName.compareToIgnoreCase(s2.lastName));

        // Вывод отсортированного списка
        System.out.println("\nСписок учеников (отсортирован по фамилии):");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}