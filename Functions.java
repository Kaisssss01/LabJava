import java.util.Scanner;

public class Functions {

    // 5.5
    public static boolean triangle(double x, double y, double z) {
        return (x + y > z) && (x + z > y) && (y + z > x);
    }

    // 5.14
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод шести координат для трех точек
        System.out.print("Введите координаты первой точки (x1, y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.print("Введите координаты второй точки (x2, y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.print("Введите координаты третьей точки (x3, y3): ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        // Вычисляем расстояния между точками
        double sideA = distance(x1, y1, x2, y2); // Расстояние между первой и второй точками
        double sideB = distance(x2, y2, x3, y3); // Расстояние между второй и третьей точками
        double sideC = distance(x1, y1, x3, y3); // Расстояние между первой и третьей точками

        // Проверяем, могут ли стороны образовать треугольник
        if (triangle(sideA, sideB, sideC)) {
            System.out.println("Стороны могут образовать треугольник.");
        } else {
            System.out.println("Стороны не могут образовать треугольник.");
        }

        // Вывод расстояний
        System.out.println("Расстояние между первой и второй точками: " + sideA);
        System.out.println("Расстояние между второй и третьей точками: " + sideB);
        System.out.println("Расстояние между первой и третьей точками: " + sideC);

        scanner.close();
    }
}
