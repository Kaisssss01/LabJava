
import java.util.Arrays;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class ArrayTasks {

    private int[] arr;

    public ArrayTasks(int[] arr) {
        this.arr = arr;
    }

    /**
     * 6.2: Дан массив n элементов целочисленного массива. Среди положительных элементов массива (если такие есть) найти наименьший.
     * @return Наименьший положительный элемент массива, или null если таких элементов нет.
     */
    public Integer task6_2() {
        Integer minPositive = null;
        for (int num : arr) {
            if (num > 0) {
                if (minPositive == null || num < minPositive) {
                    minPositive = num;
                }
            }
        }
        return minPositive;
    }

    /**
     * 6.5: Дан массив n элементов целочисленного массива. Найти количество тех элементов массива, которые меньше суммы своих соседей. Крайние элементы массива тоже имеют соседей!
     * @return Количество элементов, меньших суммы своих соседей.
     */
    public int task6_5() {
        int count = 0;
        if (arr.length < 3) {
            return 0; // Массив должен содержать минимум 3 элемента
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i - 1] + arr[i + 1]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 6.7: Дано число n. Заполнить целочисленный массив из n элементов всеми значениями от 1 до n в случайном порядке.
     * @param n Размер массива и максимальное значение элемента.
     * @return Заполненный массив.
     */
    public int[] task6_7(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        Random random = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    /**
     * 6.9: Коэффициенты многочлена n-ой степени an*x^n + an-1*x^(n-1) + ... + a1*x + a0 можно разместить в вещественном массиве размера n+1: a0, a1, ..., an-1, an. Даны два многочлена P(x) и Q(x) степеней m и n соответственно, заданные своими коэффициентами. Найти коэффициенты многочлена, равного сумме многочленов P(x) и Q(x).
     * @param q Коэффициенты второго многочлена.
     * @return Коэффициенты многочлена, являющегося суммой двух исходных.
     */
    public double[] task6_9(double[] q) {
        int lenP = arr.length;
        int lenQ = q.length;
        int maxLen = Math.max(lenP, lenQ);
        double[] result = new double[maxLen];

        for (int i = 0; i < maxLen; i++) {
            double pVal = (i < lenP) ? arr[i] : 0;
            double qVal = (i < lenQ) ? q[i] : 0;
            result[i] = pVal + qVal;
        }
        return result;
    }

    /**
     * 6.10: Линейный массив заполняется случайными целыми числами. Осуществить циклический сдвиг элементов массива на такое количество позиций вправо, чтобы максимальный элемент оказался в начале массива.
     * @return Массив после циклического сдвига.
     */
    public int[] task6_10() {
        if (arr.length == 0) {
            return arr; // Nothing to shift
        }

        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        int shift = arr.length - maxIndex;
        int[] shiftedArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            shiftedArr[i] = arr[(i + maxIndex) % arr.length];
        }

        arr = shiftedArr;  // Update the original array
        return arr;
    }


    /**
     * 6.13: Дан массив N вещественных чисел. Найти среднее арифметическое всех элементов массива, а также количество тех элементов, которые его превосходят.
     * @return Массив из двух элементов: среднее арифметическое и количество элементов, его превосходящих.
     */
    public double[] task6_13() {
        if (arr.length == 0) {
            return new double[]{0, 0}; // Avoid division by zero
        }
        double sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = sum / arr.length;
        int countGreater = 0;
        for (int num : arr) {
            if (num > average) {
                countGreater++;
            }
        }
        return new double[]{average, countGreater};
    }

    /**
     * 6.15: Дан массив из N вещественных чисел. Левую половину массива отсортировать по убыванию, а правую - по возрастанию.
     * @return Отсортированный массив.
     */
    public double[] task6_15() {
        int mid = arr.length / 2;
        double[] left = new double[mid];
        double[] right = new double[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        Arrays.sort(left);
        Arrays.sort(right);

        // Reverse left array
        for (int i = 0; i < left.length / 2; i++) {
            double temp = left[i];
            left[i] = left[left.length - 1 - i];
            left[left.length - 1 - i] = temp;
        }

        double[] sortedArr = new double[arr.length];
        System.arraycopy(left, 0, sortedArr, 0, left.length);
        System.arraycopy(right, 0, sortedArr, left.length, right.length);
        return sortedArr;
    }

    /**
     * 6.17: Даны два массива A и B по n целочисленных элементов в каждом. Элементы каждого массива не повторяются. Считая A и B множествами элементов, найти их пересечение.
     * @param b Второй массив.
     * @return Массив, содержащий элементы, входящие в оба массива.
     */
    public int[] task6_17(int[] b) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int num : arr) {
            setA.add(num);
        }

        for (int num : b) {
            setB.add(num);
        }

        for (int num : setA) {
            if (setB.contains(num)) {
                intersection.add(num);
            }
        }

        int[] result = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            result[i++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] initialArray = {1, -2, 3, 4, -5, 6, 0};
        ArrayTasks tasks = new ArrayTasks(initialArray);

        System.out.println("Исходный массив: " + Arrays.toString(initialArray));
        System.out.println("6.2: Наименьший положительный элемент: " + tasks.task6_2());
        System.out.println("6.5: Элементов < суммы соседей: " + tasks.task6_5());

        //Для 6.7
        int[] array6_7 = tasks.task6_7(5);
        System.out.println("6.7: Заполненный массив случайными числами от 1 до 5: " + Arrays.toString(array6_7));

        //Для 6.9
        double[] q = {2.0, 1.0, 3.0};
        double[] sumPolynomials = tasks.task6_9(q);
        System.out.println("6.9: Сумма многочленов: " + Arrays.toString(sumPolynomials));

        // Для 6.10. Печатаем массив, *после* сдвига
        int[] array6_10 = tasks.task6_10();
        System.out.println("6.10: Циклический сдвиг массива: " + Arrays.toString(array6_10));

        //Для 6.13
        double[] avgAndCount = tasks.task6_13();
        System.out.println("6.13: Среднее и количество > среднего: Среднее = " + avgAndCount[0] + ", Больше среднего = " + (int)avgAndCount[1]);

        //Для 6.15
        double[] array6_15 = tasks.task6_15();
        System.out.println("6.15: Отсортированный массив (лево убыв., право возр.): " + Arrays.toString(array6_15));

        // Для 6.17. Вызываем метод и печатаем результат.
        int[] b = {4, 5, 7, 8, 0};
        int[] intersection = tasks.task6_17(b);
        System.out.println("6.17: Пересечение множеств А и B: " + Arrays.toString(intersection));
    }
}
