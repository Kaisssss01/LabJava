import java.util.Random;

public class Task7_1 {

    public static void main(String[] args) {
        int n = 5; // Размер матрицы
        double[][] matrix = new double[n][n];

        // Заполнение матрицы случайными числами из диапазона [0.0; 10.0]
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextDouble() * 10;
            }
        }

        // Вывод матрицы
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // Вычисление суммы элементов ниже главной диагонали
        double sumBelowDiagonal = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                sumBelowDiagonal += matrix[i][j];
            }
        }

        // Вычисление суммы элементов выше главной диагонали
        double sumAboveDiagonal = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sumAboveDiagonal += matrix[i][j];
            }
        }

        System.out.println("Сумма элементов ниже диагонали: " + sumBelowDiagonal);
        System.out.println("Сумма элементов выше диагонали: " + sumAboveDiagonal);

        // Транспонирование матрицы, если необходимо
        if (sumBelowDiagonal < sumAboveDiagonal) {
            System.out.println("Сумма ниже диагонали меньше, чем выше. Транспонируем матрицу.");
            transposeMatrix(matrix);
        } else {
            System.out.println("Сумма ниже диагонали больше или равна, чем выше. Транспонирование не требуется.");
        }

        // Вывод матрицы после (возможного) транспонирования
        System.out.println("Матрица после (возможного) транспонирования:");
        printMatrix(matrix);
    }

    // Метод для транспонирования матрицы
    public static void transposeMatrix(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // Метод для вывода матрицы
    public static void printMatrix(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%.2f ", matrix[i][j]));
            }
            System.out.println();
        }
    }
}