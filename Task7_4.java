import java.util.Random;

public class Task7_4 {

    public static void main(String[] args) {

        // 1. Задаем размеры матрицы
        int m = 4; // Количество строк, можно менять
        int n = 5; // Количество столбцов, можно менять

        // 2. Создаем матрицу
        double[][] matrix = new double[m][n];

        // 3. Заполняем матрицу случайными вещественными числами от 0.0 до 10.0
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextDouble() * 10; // Случайное число от 0.0 до 10.0
            }
        }

        // 4. Выводим исходную матрицу (чтобы видеть, что получилось)
        System.out.println("Исходная матрица:");
        printMatrix(matrix, m, n); // Используем функцию для вывода матрицы

        // 5. Ищем среднее значение, максимальный и минимальный элементы в каждой строке
        for (int i = 0; i < m; i++) {
            double sum = 0; // Сумма элементов в текущей строке
            double max = matrix[i][0]; // Предполагаем, что первый элемент - максимальный
            double min = matrix[i][0]; // Предполагаем, что первый элемент - минимальный

            // Проходим по всем элементам текущей строки
            for (int j = 0; j < n; j++) {
                double element = matrix[i][j]; // Текущий элемент
                sum += element; // Добавляем к сумме

                if (element > max) {
                    max = element; // Обновляем максимум, если нашли больше
                }

                if (element < min) {
                    min = element; // Обновляем минимум, если нашли меньше
                }
            }

            // 6. Вычисляем среднее значение для текущей строки
            double average = sum / n;

            // 7. Выводим результаты для текущей строки
            System.out.println("\nСтрока " + (i + 1) + ":");
            System.out.println("  Среднее значение: " + String.format("%.2f", average)); //Форматируем вывод до двух знаков после запятой
            System.out.println("  Максимальный элемент: " + String.format("%.2f", max));
            System.out.println("  Минимальный элемент: " + String.format("%.2f", min));
        }
    }

    // Функция для вывода матрицы на экран (чтобы было красиво)
    public static void printMatrix(double[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%.2f  ", matrix[i][j])); // Форматируем вывод до двух знаков после запятой
            }
            System.out.println(); // Переходим на новую строку после каждой строки матрицы
        }
    }
}